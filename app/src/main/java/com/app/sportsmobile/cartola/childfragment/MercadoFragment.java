package com.app.sportsmobile.cartola.childfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.app.sportsmobile.cartola.R;
import com.app.sportsmobile.cartola.adapter.MercadoViewHolder;
import com.app.sportsmobile.cartola.model.Atletas;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

/**
 * Created by Edson on 17/01/2017.
 */
public class MercadoFragment extends Fragment {

    private View view;
    public static final String ROOMS = "cartola/atletas/key/content/atletas";
    private RecyclerView mRoomRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<Atletas, MercadoViewHolder> mFirebaseAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mercado, null);

        mRoomRecyclerView = (RecyclerView)view.findViewById(R.id.roomRecyclerView);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mLinearLayoutManager.setStackFromEnd(false);
        setHasOptionsMenu(true);
        getFiltroMercado("apelido");

        return view;
    }

    private void getFiltroMercado(String orderBy){

        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Atletas, MercadoViewHolder>(
                Atletas.class,
                R.layout.item_mercado,
                MercadoViewHolder.class,
                mFirebaseDatabaseReference.child(ROOMS).orderByChild(orderBy)) {

            @Override
            protected void populateViewHolder(final MercadoViewHolder viewHolder, final Atletas model,  int position) {


                viewHolder.bindToPost(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View roomLayJogador) {

                        if (viewHolder.roomLayDetalhes.getVisibility() == View.GONE) {
                            viewHolder.roomLayDetalhes.setVisibility(View.VISIBLE);
                        } else {
                            viewHolder.roomLayDetalhes.setVisibility(View.GONE);

                        }
                    }
                });

                String search_variacao_negativa  = "-";
                String search_variacao_neutra  = "0.0";
                String media_num = String.valueOf(model.getVariacaoNum());
                boolean hasMediaNegativa = (media_num.toLowerCase().indexOf(search_variacao_negativa .toLowerCase()) != -1);
                boolean hasMediaNeutra = (media_num.toLowerCase().indexOf(search_variacao_neutra .toLowerCase()) != -1);

                if (hasMediaNegativa) {
                    viewHolder.roomVariacaoNum.setTextColor(getResources().getColor(R.color.color_position_down));

                }else if (hasMediaNeutra)
                {
                    viewHolder.roomVariacaoNum.setTextColor(getResources().getColor(R.color.color_position_stop));
                }
                else
                {
                    viewHolder.roomVariacaoNum.setTextColor(getResources().getColor(R.color.color_position_up));
                }


                int status_id = model.getStatusId();
                if (status_id == 2){
                    viewHolder.roomStatusId.setImageResource(R.drawable.ic_duvida);
                    viewHolder.roomStatusId.setVisibility(View.VISIBLE);
                }else if (status_id == 3){
                    viewHolder.roomStatusId.setImageResource(R.drawable.ic_suspenso);
                    viewHolder.roomStatusId.setVisibility(View.VISIBLE);
                }else if (status_id == 5){
                    viewHolder.roomStatusId.setImageResource(R.drawable.ic_contundido);
                    viewHolder.roomStatusId.setVisibility(View.VISIBLE);
                }else if (status_id == 6){
                    viewHolder.roomStatusId.setImageResource(R.drawable.ic_nulo);
                    viewHolder.roomStatusId.setVisibility(View.INVISIBLE);
                }else if (status_id == 7){
                    viewHolder.roomStatusId.setImageResource(R.drawable.ic_provavel);
                    viewHolder.roomStatusId.setVisibility(View.VISIBLE);
                }else{
                    viewHolder.roomStatusId.setImageResource(R.drawable.ic_nulo);
                    viewHolder.roomStatusId.setVisibility(View.INVISIBLE);
                }


                int posicao_id = model.getPosicaoId();
                if(posicao_id == 1){
                    viewHolder.roomPosicaoId.setText("GOLEIRO");
                }else if(posicao_id == 2){
                    viewHolder.roomPosicaoId.setText("LATERAL");
                }else if(posicao_id == 3){
                    viewHolder.roomPosicaoId.setText("ZAGUEIRO");
                }else if(posicao_id == 4){
                    viewHolder.roomPosicaoId.setText("MEIA");
                }else if(posicao_id == 5){
                    viewHolder.roomPosicaoId.setText("ATACANTE");
                }else if(posicao_id == 6){
                    viewHolder.roomPosicaoId.setText("TÉCNICO");
                }



                String foto = model.getFoto();
                if (foto != null){
                    Picasso.with(getContext()).load(foto.replace("FORMATO","140x140")).placeholder(R.drawable.ic_people3).into(viewHolder.roomFoto);
                }else{
                    Picasso.with(getContext()).load(R.drawable.ic_people3).into(viewHolder.roomFoto);
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
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_escalar_time, menu);
        menu.findItem(R.id.action_filtro).setVisible(true);
        menu.findItem(R.id.action_esquema_tatico).setVisible(false);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_filtro:
                MaterialDialog.Builder builder =  new MaterialDialog.Builder(view.getContext());
                builder.title(R.string.txt_titulo);
                builder.contentColor(Color.WHITE);
                builder.negativeText(R.string.txt_negativo);
                builder.titleGravity(GravityEnum.CENTER);
                builder.titleColorRes(R.color.white);
                builder.widgetColorRes(R.color.white);
                builder.buttonRippleColorRes(R.color.white);
                builder.backgroundColorRes(R.color.grey_hard);
                final CharSequence[] items = {"Preço","Última Pontuação","Pontuação Média","Nome","Valorização","Desvalorização"};
                builder.items(items);
                builder.itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {

                    @Override
                    public boolean onSelection( MaterialDialog dialog, View view, int which, CharSequence text) {

                        switch(which)
                        {
                            case 0:
                                //SettingManager.setLastKeyword(MainActivity.this,"preco_num");
                                getFiltroMercado("preco_num");
                                break;
                            case 1:
                                //SettingManager.setLastKeyword(MainActivity.this,"pontos_num");
                                getFiltroMercado("pontos_num");
                                break;
                            case 2:
                                //SettingManager.setLastKeyword(MainActivity.this,"media_num");
                                getFiltroMercado("media_num");
                                break;
                            case 3:
                                //SettingManager.setLastKeyword(MainActivity.this,"apelido");
                                getFiltroMercado("apelido");
                                break;
                            case 4:

                                break;
                            case 5:
                                //SettingManager.setLastKeyword(MainActivity.this,"variacao_num");
                                getFiltroMercado("variacao_num");
                                break;
                        }
                        return true;
                    }




                });
                builder.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onStart() {
        super.onStart();
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
