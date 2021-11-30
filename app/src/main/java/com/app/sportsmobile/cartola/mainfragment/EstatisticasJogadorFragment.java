package com.app.sportsmobile.cartola.mainfragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.sportsmobile.cartola.R;
import com.app.sportsmobile.cartola.childfragment.BolaCheiaFragment;
import com.app.sportsmobile.cartola.childfragment.BolaMurchaFragment;
import com.app.sportsmobile.cartola.utils.FragmentHelper;

/**
 * Created by Edson on 23/01/2017.
 */
public class EstatisticasJogadorFragment extends Fragment {
    private View view;

    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    TextView roomTexto;
    private AppBarLayout appBarLayout;
    private DrawerLayout drawerLayout;
    public FloatingActionButton fab;
    private Toolbar searchToolbar;
    private ViewPager viewPager;
    private BolaCheiaFragment f_bola_cheia;
    private BolaMurchaFragment f_bola_murcha;


    public android.support.v7.app.ActionBar actionBar;
    private View parent_view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_estatisticas_jogador, null);
        setHasOptionsMenu(true);
        initComponent();
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        initAction();
        return view;
    }

    private void initAction() {
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.fixed_tab);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initComponent() {
        appBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        roomTexto = (TextView) view.findViewById(R.id.roomTexto);
    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentHelper adapter = new FragmentHelper(getChildFragmentManager());

        if (f_bola_cheia == null) {
            f_bola_cheia = new BolaCheiaFragment();


        }
        if (f_bola_murcha == null) {
            f_bola_murcha = new BolaMurchaFragment();

        }

        adapter.addFragment(f_bola_cheia, getString(R.string.txt_bola_cheia));
        adapter.addFragment(f_bola_murcha, getString(R.string.txt_bola_murcha));
        viewPager.setAdapter(adapter);


    }


}