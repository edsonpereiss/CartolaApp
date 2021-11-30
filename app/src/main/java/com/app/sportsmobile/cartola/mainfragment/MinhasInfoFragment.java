package com.app.sportsmobile.cartola.mainfragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sportsmobile.cartola.R;
import com.app.sportsmobile.cartola.childfragment.MeuTimeFragment;
import com.app.sportsmobile.cartola.childfragment.MinhasLigasFragment;
import com.app.sportsmobile.cartola.model.Patrimonio;
import com.app.sportsmobile.cartola.model.Pontos;
import com.app.sportsmobile.cartola.model.Time;
import com.app.sportsmobile.cartola.utils.FragmentHelper;
import com.app.sportsmobile.cartola.utils.HttpHandler;
import com.app.sportsmobile.cartola.utils.SessionManager;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Edson on 17/01/2017.
 */
public class MinhasInfoFragment extends Fragment {

    private View view;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private MeuTimeFragment f_meu_time;
    private MinhasLigasFragment f_minhas_ligas;
    private Handler mHandler = new Handler();
    private ProgressDialog pDialog;
    private static final String TAG = "CARTOLA";
    private static final String url = "https://login.globo.com/login/438";
    private WebView wv;
    Fragment fragment = null;
    Time time = new Time();
    Pontos pontos = new Pontos();
    Patrimonio patrimonio = new Patrimonio();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(SessionManager.getToken(getActivity()) != null){

            view = inflater.inflate(R.layout.fragment_minhas_info, null);
            setHasOptionsMenu(true);
            initComponent();
            if (viewPager != null) {
                setupViewPager(viewPager);
            }

            initAction();
            Log.d(TAG, "Valor de GLBID " + getCookie());

        }else{

            getActivity().setTitle(R.id.nav_estatisticas);
            view = inflater.inflate(R.layout.fragment_webview, null);
            setHasOptionsMenu(true);
            initWebview();
            Log.d(TAG, "Valor de GLBID Não encontrado");
        }
        return view;
    }

    private void initAction() {
        new AsyncFetch().execute();
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.fixed_tab);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initWebview() {
        wv = (WebView) view.findViewById(R.id.webView);
        WebSettings webSettings = wv.getSettings();
        wv.getSettings().setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        wv.loadUrl(url);
        wv.setWebViewClient(new MyWebViewClient());

    }

    private void initComponent() {
        appBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentHelper adapter = new FragmentHelper(getChildFragmentManager());

        if (f_meu_time == null) {
            f_meu_time = new MeuTimeFragment();

        }
        if (f_minhas_ligas == null) {
            f_minhas_ligas = new MinhasLigasFragment();
        }
        adapter.addFragment(f_meu_time, getString(R.string.txt_meu_time));
        adapter.addFragment(f_minhas_ligas, getString(R.string.txt_minhas_ligas));
        viewPager.setAdapter(adapter);


    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(final WebView view, String url) {

            if(getCookie()!= null){

                SessionManager.setToken(view.getContext(),getCookie());
                MinhasInfoFragment fragment = new MinhasInfoFragment();
                Bundle args = new Bundle();
                fragment.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame_content,fragment).addToBackStack(null).commit();
                Log.d(TAG, "Valor de GLBID " + getCookie());
                cleanWebview(view);
            }

        }

    }

    public void cleanWebview(final WebView view){

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.loadUrl("https://login.globo.com/logout?url=https://cartolafc.globo.com/#/home");
            }
        }, 5000);

    }

    public static String getCookie(){

        String CookieValue = null;
        CookieManager cookieManager = CookieManager.getInstance();
        String cookies = cookieManager.getCookie(url);

        String[] temp = cookies.split(";");
        for (String ar1 : temp){
            if(ar1.contains("GLBID")){
                String[] temp1=ar1.split("=");
                CookieValue = temp1[1];
            }

        }
        return CookieValue;
    }



    private class AsyncFetch extends AsyncTask<Void, Void, Void> {
        ProgressDialog pdLoading = new ProgressDialog(getContext());

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(getContext());
            pDialog.setMessage("Carregando...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            String url = "http://104.199.162.107/cartola/auth/"+SessionManager.getToken(getContext())+"/time";
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {

                    JSONObject jsonObj = new JSONObject(jsonStr);
                    final String loudScreaming = jsonObj.getString("body");
                    JSONObject jsonObj2 = new JSONObject(loudScreaming);
                    JSONObject t = jsonObj2.getJSONObject("time");
                    time.nome = t.getString("nome");
                    time.nome_cartola = t.getString("nome_cartola");
                    time.slug = t.getString("slug");
                    time.url_escudo_png = t.getString("url_escudo_png");
                    time.url_camisa_png = t.getString("url_camisa_png");
                    pontos.pontos = jsonObj2.getDouble("pontos");
                    patrimonio.patrimonio = jsonObj2.getDouble("patrimonio");


                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");


            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            if (pDialog.isShowing())
                pDialog.dismiss();


            TextView roomNome = (TextView) view.findViewById(R.id.nome);
            roomNome.setText(time.nome);

            TextView roomNomeCartola = (TextView) view.findViewById(R.id.nome_cartola);
            roomNomeCartola.setText(time.nome_cartola);

            ImageView roomEscudo = (ImageView) view.findViewById(R.id.url_escudo_png);
            Picasso.with(getContext()).load(time.url_escudo_png).placeholder(R.drawable.ic_escudo2).into(roomEscudo);


            ImageView roomCamisa = (ImageView) view.findViewById(R.id.url_camisa_png);
            Picasso.with(getContext()).load(time.url_camisa_png).placeholder(R.drawable.ic_camisa).into(roomCamisa);

            TextView roomPatrimonio = (TextView) view.findViewById(R.id.patrimonio);
            roomPatrimonio.setText(String.valueOf(patrimonio.patrimonio));

            double d = pontos.pontos;
            BigDecimal bd = new BigDecimal(d).setScale(2, RoundingMode.HALF_EVEN);
            TextView roomPontos = (TextView) view.findViewById(R.id.pontos);
            roomPontos.setText(String.valueOf(bd));

        }
    }

}


