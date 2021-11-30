package com.app.sportsmobile.cartola.mainfragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.app.sportsmobile.cartola.R;
import com.app.sportsmobile.cartola.childfragment.RodadaFragment;
import com.app.sportsmobile.cartola.childfragment.ClassificacaoFragment;
import com.app.sportsmobile.cartola.utils.FragmentHelper;

/**
 * Created by Edson on 17/01/2017.
 */
public class InfoCampeonatoFragment extends Fragment {
    private View view;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private DrawerLayout drawerLayout;
    public FloatingActionButton fab;
    private Toolbar searchToolbar;
    private ViewPager viewPager;
    private RodadaFragment f_rodada;
    private ClassificacaoFragment f_classificacao;
    Menu myMenu;

    public android.support.v7.app.ActionBar actionBar;
    private View parent_view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info_campeonato, null);
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
    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentHelper adapter = new FragmentHelper(getChildFragmentManager());

        if (f_rodada == null) {
            f_rodada = new RodadaFragment();

        }
        if (f_classificacao == null) {
            f_classificacao = new ClassificacaoFragment();
        }

        adapter.addFragment(f_rodada, getString(R.string.txt_rodada));
        adapter.addFragment(f_classificacao, getString(R.string.txt_classificacao));
        viewPager.setAdapter(adapter);


    }


}