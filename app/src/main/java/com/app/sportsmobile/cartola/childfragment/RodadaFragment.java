package com.app.sportsmobile.cartola.childfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.sportsmobile.cartola.R;

import com.app.sportsmobile.cartola.adapter.PartidasViewHolder;

import com.app.sportsmobile.cartola.model.Partidas;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RodadaFragment extends Fragment {

    private View view;
    public static final String ROOMS = "cartola/partidas/key/content/partidas";
    private RecyclerView mRoomRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<Partidas, PartidasViewHolder> mFirebaseAdapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rodada, null);

        mRoomRecyclerView = (RecyclerView)view.findViewById(R.id.roomRecyclerView);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mLinearLayoutManager.setStackFromEnd(false);
        setHasOptionsMenu(true);

        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Partidas, PartidasViewHolder>(
                Partidas.class,
                R.layout.item_rodada,
                PartidasViewHolder.class,
                mFirebaseDatabaseReference.child(ROOMS)){

            @Override
            protected void populateViewHolder(final PartidasViewHolder viewHolder, final Partidas model, int position) {


                viewHolder.bindToPost(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View roomLayRodada) {
                    }
                });


                for (int i = 0; i < model.aproveitamento_mandante.size(); i++) {
                    String valor_aproveitamento_mandante = model.aproveitamento_mandante.get(i);

                    if (valor_aproveitamento_mandante.equals("v")) {
                        ImageView imageview = new ImageView(getContext());
                        LinearLayout.LayoutParams params = new LinearLayout
                                .LayoutParams(20,20);

                        // Add image path from drawable folder.
                        imageview.setImageResource(R.drawable.ic_vitoria);
                        imageview.setMaxHeight(20);
                        imageview.setMaxWidth(20);
                        imageview.setLayoutParams(params);
                        viewHolder.roomLayAproveitamentoMandante.addView(imageview);

                    }else if(valor_aproveitamento_mandante.equals("e")){


                        ImageView imageview = new ImageView(getContext());
                        LinearLayout.LayoutParams params = new LinearLayout
                                .LayoutParams(20,20);

                        // Add image path from drawable folder.
                        imageview.setImageResource(R.drawable.ic_empate);
                        imageview.setMaxHeight(20);
                        imageview.setMaxWidth(20);
                        imageview.setLayoutParams(params);
                        viewHolder.roomLayAproveitamentoMandante.addView(imageview);

                    }else if(valor_aproveitamento_mandante.equals("d")){


                        ImageView imageview = new ImageView(getContext());
                        LinearLayout.LayoutParams params = new LinearLayout
                                .LayoutParams(20,20);

                        // Add image path from drawable folder.
                        imageview.setImageResource(R.drawable.ic_derrota);
                        imageview.setMaxHeight(20);
                        imageview.setMaxWidth(20);
                        imageview.setLayoutParams(params);
                        viewHolder.roomLayAproveitamentoMandante.addView(imageview);

                    }
                }


                for (int i = 0; i < model.aproveitamento_visitante.size(); i++) {
                    String valor_aproveitamento_visitante = model.aproveitamento_visitante.get(i);

                    if (valor_aproveitamento_visitante.equals("v")) {
                        ImageView imageview = new ImageView(getContext());
                        LinearLayout.LayoutParams params = new LinearLayout
                                .LayoutParams(20,20);

                        // Add image path from drawable folder.
                        imageview.setImageResource(R.drawable.ic_vitoria);
                        imageview.setMaxHeight(20);
                        imageview.setMaxWidth(20);
                        imageview.setLayoutParams(params);
                        viewHolder.roomLayAproveitamentoVisitante.addView(imageview);

                    }else if(valor_aproveitamento_visitante.equals("e")){


                        ImageView imageview = new ImageView(getContext());
                        LinearLayout.LayoutParams params = new LinearLayout
                                .LayoutParams(20,20);

                        // Add image path from drawable folder.
                        imageview.setImageResource(R.drawable.ic_empate);
                        imageview.setMaxHeight(20);
                        imageview.setMaxWidth(20);
                        imageview.setLayoutParams(params);
                        viewHolder.roomLayAproveitamentoVisitante.addView(imageview);

                    }else if(valor_aproveitamento_visitante.equals("d")){


                        ImageView imageview = new ImageView(getContext());
                        LinearLayout.LayoutParams params = new LinearLayout
                                .LayoutParams(20,20);

                        // Add image path from drawable folder.
                        imageview.setImageResource(R.drawable.ic_derrota);
                        imageview.setMaxHeight(20);
                        imageview.setMaxWidth(20);
                        imageview.setLayoutParams(params);
                        viewHolder.roomLayAproveitamentoVisitante.addView(imageview);

                    }

                }
            }

        };

        mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(){
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount){
                super.onItemRangeInserted(positionStart, itemCount);
                int roomCount = mFirebaseAdapter.getItemCount();
                int lastVisiblePosition = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisiblePosition == 1 || (positionStart >= (roomCount -1) && lastVisiblePosition == (positionStart -1))){
                    mRoomRecyclerView.scrollToPosition(positionStart);
                }
            }
        });

        mRoomRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRoomRecyclerView.setAdapter(mFirebaseAdapter);

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

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in.
        // TODO: Add code to check if user is signed in.
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}


