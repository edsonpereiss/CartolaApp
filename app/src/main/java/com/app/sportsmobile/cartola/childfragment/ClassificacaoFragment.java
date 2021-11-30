package com.app.sportsmobile.cartola.childfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.app.sportsmobile.cartola.R;

public class ClassificacaoFragment extends Fragment {

    private RecyclerView mRoomRecyclerView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_classificacao, null);
        mRoomRecyclerView = (RecyclerView)view.findViewById(R.id.roomRecyclerView);
        setHasOptionsMenu(true);

        return view;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_info_campeonato, menu);
        menu.findItem(R.id.action_google_play).setVisible(true);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_google_play:
                Snackbar.make(view, item.getTitle()+" Clicked", Snackbar.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
