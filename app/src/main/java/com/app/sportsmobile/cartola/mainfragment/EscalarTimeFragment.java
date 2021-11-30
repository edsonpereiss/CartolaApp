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

import com.app.sportsmobile.cartola.R;
import com.app.sportsmobile.cartola.childfragment.EsquemaTaticoFragment;
import com.app.sportsmobile.cartola.childfragment.MercadoFragment;
import com.app.sportsmobile.cartola.utils.FragmentHelper;

/**
 * Created by Edson on 20/01/2017.
 */
public class EscalarTimeFragment extends Fragment {
    private View view;

    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private DrawerLayout drawerLayout;
    public FloatingActionButton fab;
    private Toolbar searchToolbar;
    private ViewPager viewPager;
    private MercadoFragment f_mercado;
    private EsquemaTaticoFragment f_esquema_tatico;


    public android.support.v7.app.ActionBar actionBar;
    private View parent_view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_escalar_time, null);
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

        if (f_mercado == null) {
            f_mercado = new MercadoFragment();

        }
        if (f_esquema_tatico == null) {
            f_esquema_tatico = new EsquemaTaticoFragment();
        }

        adapter.addFragment(f_mercado, getString(R.string.txt_mecado));
        adapter.addFragment(f_esquema_tatico, getString(R.string.txt_esquema_tatico));
        viewPager.setAdapter(adapter);


    }


}