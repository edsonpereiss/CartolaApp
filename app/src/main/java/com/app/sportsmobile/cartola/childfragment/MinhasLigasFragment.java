package com.app.sportsmobile.cartola.childfragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.app.sportsmobile.cartola.utils.HttpHandler;
import com.app.sportsmobile.cartola.R;
import com.app.sportsmobile.cartola.utils.SessionManager;
import com.app.sportsmobile.cartola.adapter.MinhasLigasViewHolder;
import com.app.sportsmobile.cartola.model.MinhasLigas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edson on 01/02/2017.
 */
public class MinhasLigasFragment extends Fragment {

    public static String TAG = "CARTOLA";
    List<MinhasLigas> minhasligasdata = new ArrayList<>();
    private ProgressDialog pDialog;
    private RecyclerView mRoomRecyclerView;
    private MinhasLigasViewHolder mAdapter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_minhas_ligas, null);

        new AsyncFetch().execute();
        setHasOptionsMenu(true);

        return view;
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

            String url = "http://104.199.162.107/cartola/auth/"+ SessionManager.getToken(getContext())+"/ligas";
            pdLoading.dismiss();
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {

                    JSONObject jsonObj = new JSONObject(jsonStr);
                    final String loudScreaming = jsonObj.getString("body");
                    JSONObject jsonObj2 = new JSONObject(loudScreaming);
                    JSONArray atletas = jsonObj2.getJSONArray("ligas");

                    for (int i = 0; i < atletas.length(); i++) {

                        JSONObject a = atletas.getJSONObject(i);
                        MinhasLigas minhasligas = new MinhasLigas();
                        minhasligas.nome = a.getString("nome");
                        minhasligas.descricao = a.getString("descricao");
                        minhasligas.slug = a.getString("slug");
                        minhasligas.url_flamula_png = a.getString("url_flamula_png");

                        minhasligasdata.add(minhasligas);

                    }


                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            if (pDialog.isShowing())
                pDialog.dismiss();

            mRoomRecyclerView = (RecyclerView)getView().findViewById(R.id.roomRecyclerView);
            mAdapter = new MinhasLigasViewHolder(getContext(), minhasligasdata);
            mRoomRecyclerView.setAdapter(mAdapter);
            mRoomRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        }
    }

}

