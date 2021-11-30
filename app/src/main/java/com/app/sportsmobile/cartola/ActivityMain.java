package com.app.sportsmobile.cartola;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sportsmobile.cartola.mainfragment.EscalarTimeFragment;
import com.app.sportsmobile.cartola.mainfragment.EstatisticasJogadorFragment;
import com.app.sportsmobile.cartola.mainfragment.InfoCampeonatoFragment;
import com.app.sportsmobile.cartola.mainfragment.MinhasInfoFragment;
import com.app.sportsmobile.cartola.utils.SessionManager;
import com.app.sportsmobile.cartola.utils.Tools;
import com.balysv.materialripple.MaterialRippleLayout;

public class ActivityMain extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private ActionBar actionBar;
    private Menu menu;
    private View parent_view;
    private NavigationView nav_view;
    private MaterialRippleLayout roomLayLogin;
    private TextView roomLogin;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parent_view = findViewById(R.id.main_content);
        initToolbar();
        setupDrawerLayout();

        // display first page
        displayView(R.id.nav_escalar_time, getString(R.string.menu_escalar_time));
        actionBar.setTitle(R.string.menu_escalar_time);

        // for system bar in lollipop
        Tools.systemBarLolipop(this);
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        actionBar = getSupportActionBar();
        getSupportActionBar().setElevation(0);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void setupDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nav_view = (NavigationView) findViewById(R.id.navigation_view);
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {

                roomLayLogin = (MaterialRippleLayout) findViewById(R.id.lay_login_button);
                roomLogin = (TextView) findViewById(R.id.txt_login);
                if(SessionManager.getToken(getBaseContext()) != null){

                    roomLogin.setText("Desconectar");
                    roomLayLogin.setClickable(true);
                    roomLayLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            SessionManager.logoutUser(getBaseContext());
                            roomLogin.setText("Conectar");
                            if (fragment != null) {
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.frame_content, fragment);
                                fragmentTransaction.commit();
                                //initToolbar();
                            }
                        }
                    });


                }else{

                    roomLogin.setText("Conectar");
                    roomLayLogin.setClickable(true);
                    roomLayLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            drawerLayout.closeDrawers();
                            Bundle bundle = new Bundle();
                            fragment = new MinhasInfoFragment();
                            fragment.setArguments(bundle);

                            if (fragment != null) {
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.frame_content, fragment);
                                fragmentTransaction.commit();
                                //initToolbar();
                            }


                        }
                    });
                }
                super.onDrawerOpened(drawerView);
            }
        };
        // Set the drawer toggle as the DrawerListener
        drawerLayout.setDrawerListener(mDrawerToggle);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                actionBar.setTitle(menuItem.getTitle());
                displayView(menuItem.getItemId(), menuItem.getTitle().toString());
                return true;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.action_credit:
                Snackbar.make(parent_view, "Credit Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Snackbar.make(parent_view, "Setting Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_about: {
                Snackbar.make(parent_view, "About Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayView(int id, String title) {
        actionBar.setDisplayShowCustomEnabled(false);
        actionBar.setDisplayShowTitleEnabled(true);
        Fragment fragment = null;
        Bundle bundle = new Bundle();

        switch (id) {
            case R.id.nav_info_campeonato:
                fragment = new InfoCampeonatoFragment();
                break;
            case R.id.nav_escalar_time:
                fragment = new EscalarTimeFragment();
                break;
            case R.id.nav_estatisticas:
                fragment = new EstatisticasJogadorFragment();
                break;
            case R.id.nav_minhas_info:
                fragment = new MinhasInfoFragment();
                break;

        } fragment.setArguments(bundle);

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_content, fragment);
            fragmentTransaction.commit();
            //initToolbar();
        }


    }

    private long exitTime = 0;

    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        doExitApp();
    }
}