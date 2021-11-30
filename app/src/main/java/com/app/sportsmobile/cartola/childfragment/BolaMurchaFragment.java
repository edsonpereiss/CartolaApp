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
import android.widget.TextView;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.app.sportsmobile.cartola.R;
import com.app.sportsmobile.cartola.adapter.BolaMurchaViewHolder;
import com.app.sportsmobile.cartola.model.Atletas;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

/**
 * Created by Edson on 23/01/2017.
 */
public class BolaMurchaFragment extends Fragment {

    public TextView roomTexto;
    private View view;
    public static final String ROOMS = "cartola/atletas/key/content/atletas";
    private RecyclerView mRoomRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<Atletas, BolaMurchaViewHolder> mFirebaseAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bola_murcha, null);

        roomTexto = (TextView) getActivity().findViewById(R.id.roomTexto);
        mRoomRecyclerView = (RecyclerView)view.findViewById(R.id.roomRecyclerView);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mLinearLayoutManager.setStackFromEnd(false);
        mLinearLayoutManager.setReverseLayout(true);
        setHasOptionsMenu(true);

        getFiltroMercado("scout/CV", 1);


        return view;
    }

    private void getFiltroMercado(final String orderBy, int mStartAt){


        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Atletas, BolaMurchaViewHolder>(
                Atletas.class,
                R.layout.item_bola_murcha,
                BolaMurchaViewHolder.class,
                mFirebaseDatabaseReference.child(ROOMS).orderByChild(orderBy).startAt(mStartAt)) {

            @Override
            protected void populateViewHolder(final BolaMurchaViewHolder viewHolder, final Atletas model, int position) {

                if (orderBy == "scout/CA"){
                    if(model.scout != null){

                        viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        viewHolder.roomLayComNumeros.setVisibility(View.VISIBLE);
                        viewHolder.roomLaySemNumeros.setVisibility(View.GONE);
                        viewHolder.roomCartaoAmarelo.setVisibility(View.VISIBLE);
                        viewHolder.roomFaltasCometidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesDefendidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesParaFora.setVisibility(View.GONE);
                        viewHolder.roomFaltasSofridas.setVisibility(View.GONE);
                        viewHolder.roomGols.setVisibility(View.GONE);
                        viewHolder.roomPassesErrados.setVisibility(View.GONE);
                        viewHolder.roomRoubadaDeBola.setVisibility(View.GONE);
                        viewHolder.roomAssistencia.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesNaTrave.setVisibility(View.GONE);
                        viewHolder.roomImpedimento.setVisibility(View.GONE);
                        viewHolder.roomPenaltiPerdido.setVisibility(View.GONE);
                        viewHolder.roomGolContra.setVisibility(View.GONE);
                        viewHolder.roomCartaoVermelho.setVisibility(View.GONE);
                        viewHolder.roomSemSofrerGol.setVisibility(View.GONE);
                        viewHolder.roomDefesasDificeis.setVisibility(View.GONE);
                        viewHolder.roomDefesaDePenalti.setVisibility(View.GONE);
                        viewHolder.roomGolSofrido.setVisibility(View.GONE);

                        if(model.scout.CA!= 0){
                            viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        }else{
                            viewHolder.roomLayJogador.setVisibility(View.GONE);
                        }
                    }else{
                        viewHolder.roomLayJogador.setVisibility(View.GONE);

                    }
                }

                if (orderBy == "scout/CV"){
                    if(model.scout != null){

                        viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        viewHolder.roomLayComNumeros.setVisibility(View.VISIBLE);
                        viewHolder.roomLaySemNumeros.setVisibility(View.GONE);
                        viewHolder.roomCartaoAmarelo.setVisibility(View.GONE);
                        viewHolder.roomFaltasCometidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesDefendidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesParaFora.setVisibility(View.GONE);
                        viewHolder.roomFaltasSofridas.setVisibility(View.GONE);
                        viewHolder.roomGols.setVisibility(View.GONE);
                        viewHolder.roomPassesErrados.setVisibility(View.GONE);
                        viewHolder.roomRoubadaDeBola.setVisibility(View.GONE);
                        viewHolder.roomAssistencia.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesNaTrave.setVisibility(View.GONE);
                        viewHolder.roomImpedimento.setVisibility(View.GONE);
                        viewHolder.roomPenaltiPerdido.setVisibility(View.GONE);
                        viewHolder.roomGolContra.setVisibility(View.GONE);
                        viewHolder.roomCartaoVermelho.setVisibility(View.VISIBLE);
                        viewHolder.roomSemSofrerGol.setVisibility(View.GONE);
                        viewHolder.roomDefesasDificeis.setVisibility(View.GONE);
                        viewHolder.roomDefesaDePenalti.setVisibility(View.GONE);
                        viewHolder.roomGolSofrido.setVisibility(View.GONE);

                        if(model.scout.CV!= 0){
                            viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        }else{
                            viewHolder.roomLayJogador.setVisibility(View.GONE);
                        }
                    }else{
                        viewHolder.roomLayJogador.setVisibility(View.GONE);

                    }
                }

                if (orderBy == "scout/FC"){
                    if(model.scout != null){

                        viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        viewHolder.roomLayComNumeros.setVisibility(View.VISIBLE);
                        viewHolder.roomLaySemNumeros.setVisibility(View.GONE);
                        viewHolder.roomCartaoAmarelo.setVisibility(View.GONE);
                        viewHolder.roomFaltasCometidas.setVisibility(View.VISIBLE);
                        viewHolder.roomFinalizacoesDefendidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesParaFora.setVisibility(View.GONE);
                        viewHolder.roomFaltasSofridas.setVisibility(View.GONE);
                        viewHolder.roomGols.setVisibility(View.GONE);
                        viewHolder.roomPassesErrados.setVisibility(View.GONE);
                        viewHolder.roomRoubadaDeBola.setVisibility(View.GONE);
                        viewHolder.roomAssistencia.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesNaTrave.setVisibility(View.GONE);
                        viewHolder.roomImpedimento.setVisibility(View.GONE);
                        viewHolder.roomPenaltiPerdido.setVisibility(View.GONE);
                        viewHolder.roomGolContra.setVisibility(View.GONE);
                        viewHolder.roomCartaoVermelho.setVisibility(View.GONE);
                        viewHolder.roomSemSofrerGol.setVisibility(View.GONE);
                        viewHolder.roomDefesasDificeis.setVisibility(View.GONE);
                        viewHolder.roomDefesaDePenalti.setVisibility(View.GONE);
                        viewHolder.roomGolSofrido.setVisibility(View.GONE);

                        if(model.scout.FC!= 0){
                            viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        }else{
                            viewHolder.roomLayJogador.setVisibility(View.GONE);
                        }
                    }else{
                        viewHolder.roomLayJogador.setVisibility(View.GONE);

                    }
                }

                if (orderBy == "scout/PE"){
                    if(model.scout != null){

                        viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        viewHolder.roomLayComNumeros.setVisibility(View.VISIBLE);
                        viewHolder.roomLaySemNumeros.setVisibility(View.GONE);
                        viewHolder.roomCartaoAmarelo.setVisibility(View.GONE);
                        viewHolder.roomFaltasCometidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesDefendidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesParaFora.setVisibility(View.GONE);
                        viewHolder.roomFaltasSofridas.setVisibility(View.GONE);
                        viewHolder.roomGols.setVisibility(View.GONE);
                        viewHolder.roomPassesErrados.setVisibility(View.VISIBLE);
                        viewHolder.roomRoubadaDeBola.setVisibility(View.GONE);
                        viewHolder.roomAssistencia.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesNaTrave.setVisibility(View.GONE);
                        viewHolder.roomImpedimento.setVisibility(View.GONE);
                        viewHolder.roomPenaltiPerdido.setVisibility(View.GONE);
                        viewHolder.roomGolContra.setVisibility(View.GONE);
                        viewHolder.roomCartaoVermelho.setVisibility(View.GONE);
                        viewHolder.roomSemSofrerGol.setVisibility(View.GONE);
                        viewHolder.roomDefesasDificeis.setVisibility(View.GONE);
                        viewHolder.roomDefesaDePenalti.setVisibility(View.GONE);
                        viewHolder.roomGolSofrido.setVisibility(View.GONE);

                        if(model.scout.PE!= 0){
                            viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        }else{
                            viewHolder.roomLayJogador.setVisibility(View.GONE);
                        }
                    }else{
                        viewHolder.roomLayJogador.setVisibility(View.GONE);

                    }
                }

                if (orderBy == "scout/I"){
                    if(model.scout != null){

                        viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        viewHolder.roomLayComNumeros.setVisibility(View.VISIBLE);
                        viewHolder.roomLaySemNumeros.setVisibility(View.GONE);
                        viewHolder.roomCartaoAmarelo.setVisibility(View.GONE);
                        viewHolder.roomFaltasCometidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesDefendidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesParaFora.setVisibility(View.GONE);
                        viewHolder.roomFaltasSofridas.setVisibility(View.GONE);
                        viewHolder.roomGols.setVisibility(View.GONE);
                        viewHolder.roomPassesErrados.setVisibility(View.GONE);
                        viewHolder.roomRoubadaDeBola.setVisibility(View.GONE);
                        viewHolder.roomAssistencia.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesNaTrave.setVisibility(View.GONE);
                        viewHolder.roomImpedimento.setVisibility(View.VISIBLE);
                        viewHolder.roomPenaltiPerdido.setVisibility(View.GONE);
                        viewHolder.roomGolContra.setVisibility(View.GONE);
                        viewHolder.roomCartaoVermelho.setVisibility(View.GONE);
                        viewHolder.roomSemSofrerGol.setVisibility(View.GONE);
                        viewHolder.roomDefesasDificeis.setVisibility(View.GONE);
                        viewHolder.roomDefesaDePenalti.setVisibility(View.GONE);
                        viewHolder.roomGolSofrido.setVisibility(View.GONE);

                        if(model.scout.I!= 0){
                            viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        }else{
                            viewHolder.roomLayJogador.setVisibility(View.GONE);
                        }
                    }else{
                        viewHolder.roomLayJogador.setVisibility(View.GONE);

                    }
                }

                if (orderBy == "scout/GC"){
                    if(model.scout != null){

                        viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        viewHolder.roomLayComNumeros.setVisibility(View.VISIBLE);
                        viewHolder.roomLaySemNumeros.setVisibility(View.GONE);
                        viewHolder.roomCartaoAmarelo.setVisibility(View.GONE);
                        viewHolder.roomFaltasCometidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesDefendidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesParaFora.setVisibility(View.GONE);
                        viewHolder.roomFaltasSofridas.setVisibility(View.GONE);
                        viewHolder.roomGols.setVisibility(View.GONE);
                        viewHolder.roomPassesErrados.setVisibility(View.GONE);
                        viewHolder.roomRoubadaDeBola.setVisibility(View.GONE);
                        viewHolder.roomAssistencia.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesNaTrave.setVisibility(View.GONE);
                        viewHolder.roomImpedimento.setVisibility(View.GONE);
                        viewHolder.roomPenaltiPerdido.setVisibility(View.GONE);
                        viewHolder.roomGolContra.setVisibility(View.VISIBLE);
                        viewHolder.roomCartaoVermelho.setVisibility(View.GONE);
                        viewHolder.roomSemSofrerGol.setVisibility(View.GONE);
                        viewHolder.roomDefesasDificeis.setVisibility(View.GONE);
                        viewHolder.roomDefesaDePenalti.setVisibility(View.GONE);
                        viewHolder.roomGolSofrido.setVisibility(View.GONE);

                        if(model.scout.GC!= 0){
                            viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        }else{
                            viewHolder.roomLayJogador.setVisibility(View.GONE);
                        }
                    }else{
                        viewHolder.roomLayJogador.setVisibility(View.GONE);

                    }
                }

                if (orderBy == "scout/PP"){
                    if(model.scout != null){

                        viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        viewHolder.roomLayComNumeros.setVisibility(View.VISIBLE);
                        viewHolder.roomLaySemNumeros.setVisibility(View.GONE);
                        viewHolder.roomCartaoAmarelo.setVisibility(View.GONE);
                        viewHolder.roomFaltasCometidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesDefendidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesParaFora.setVisibility(View.GONE);
                        viewHolder.roomFaltasSofridas.setVisibility(View.GONE);
                        viewHolder.roomGols.setVisibility(View.GONE);
                        viewHolder.roomPassesErrados.setVisibility(View.GONE);
                        viewHolder.roomRoubadaDeBola.setVisibility(View.GONE);
                        viewHolder.roomAssistencia.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesNaTrave.setVisibility(View.GONE);
                        viewHolder.roomImpedimento.setVisibility(View.GONE);
                        viewHolder.roomPenaltiPerdido.setVisibility(View.VISIBLE);
                        viewHolder.roomGolContra.setVisibility(View.GONE);
                        viewHolder.roomCartaoVermelho.setVisibility(View.GONE);
                        viewHolder.roomSemSofrerGol.setVisibility(View.GONE);
                        viewHolder.roomDefesasDificeis.setVisibility(View.GONE);
                        viewHolder.roomDefesaDePenalti.setVisibility(View.GONE);
                        viewHolder.roomGolSofrido.setVisibility(View.GONE);

                        if(model.scout.PP!= 0){
                            viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        }else{
                            viewHolder.roomLayJogador.setVisibility(View.GONE);
                        }
                    }else{
                        viewHolder.roomLayJogador.setVisibility(View.GONE);

                    }
                }

                if (orderBy == "scout/GS"){
                    if(model.scout != null){

                        viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        viewHolder.roomLayComNumeros.setVisibility(View.VISIBLE);
                        viewHolder.roomLaySemNumeros.setVisibility(View.GONE);
                        viewHolder.roomCartaoAmarelo.setVisibility(View.GONE);
                        viewHolder.roomFaltasCometidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesDefendidas.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesParaFora.setVisibility(View.GONE);
                        viewHolder.roomFaltasSofridas.setVisibility(View.GONE);
                        viewHolder.roomGols.setVisibility(View.GONE);
                        viewHolder.roomPassesErrados.setVisibility(View.GONE);
                        viewHolder.roomRoubadaDeBola.setVisibility(View.GONE);
                        viewHolder.roomAssistencia.setVisibility(View.GONE);
                        viewHolder.roomFinalizacoesNaTrave.setVisibility(View.GONE);
                        viewHolder.roomImpedimento.setVisibility(View.GONE);
                        viewHolder.roomPenaltiPerdido.setVisibility(View.GONE);
                        viewHolder.roomGolContra.setVisibility(View.GONE);
                        viewHolder.roomCartaoVermelho.setVisibility(View.GONE);
                        viewHolder.roomSemSofrerGol.setVisibility(View.GONE);
                        viewHolder.roomDefesasDificeis.setVisibility(View.GONE);
                        viewHolder.roomDefesaDePenalti.setVisibility(View.GONE);
                        viewHolder.roomGolSofrido.setVisibility(View.VISIBLE);

                        if(model.scout.GS!= 0){
                            viewHolder.roomLayJogador.setVisibility(View.VISIBLE);
                        }else{
                            viewHolder.roomLayJogador.setVisibility(View.GONE);
                        }
                    }else{
                        viewHolder.roomLayJogador.setVisibility(View.GONE);

                    }
                }

                viewHolder.bindToPost(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View roomLayJogador) {

                    }
                });

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
                if (lastVisiblePosition == -1 || (positionStart >= (roomCount -1) && lastVisiblePosition == (positionStart -1))){
                    mRoomRecyclerView.scrollToPosition(positionStart);
                }
            }
        });

        mRoomRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRoomRecyclerView.setAdapter(mFirebaseAdapter);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_estatisticas_jogador, menu);
        menu.findItem(R.id.action_bola_cheia).setVisible(false);
        menu.findItem(R.id.action_bola_murcha).setVisible(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_bola_murcha:
                MaterialDialog.Builder builder =  new MaterialDialog.Builder(view.getContext());
                builder.title(R.string.txt_titulo);
                builder.contentColor(Color.WHITE);
                builder.negativeText(R.string.txt_negativo);
                builder.titleGravity(GravityEnum.CENTER);
                builder.titleColorRes(R.color.white);
                builder.widgetColorRes(R.color.white);
                builder.buttonRippleColorRes(R.color.white);
                builder.backgroundColorRes(R.color.grey_hard);
                final CharSequence[] items = {"Cartões Amarelo","Cartões Vermelho","Faltas Cometidas","Passes Errados","Impedimentos","Gols Contra","Pênaltis Perdido","Gols Sofridos"};
                builder.items(items);
                builder.itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {

                    @Override
                    public boolean onSelection( MaterialDialog dialog, View view, int which, CharSequence text) {

                        switch(which)
                        {
                            case 0:
                                //SettingManager.setLastKeyword(MainActivity.this,"preco_num");
                                getFiltroMercado("scout/CA",1);
                                break;
                            case 1:
                                //SettingManager.setLastKeyword(MainActivity.this,"pontos_num");
                                getFiltroMercado("scout/CV",1);
                                break;
                            case 2:
                                //SettingManager.setLastKeyword(MainActivity.this,"media_num");
                                getFiltroMercado("scout/FC",1);
                                break;
                            case 3:
                                //SettingManager.setLastKeyword(MainActivity.this,"apelido");
                                getFiltroMercado("scout/PE",1);
                                break;
                            case 4:
                                getFiltroMercado("scout/I",1);
                                break;
                            case 5:
                                //SettingManager.setLastKeyword(MainActivity.this,"variacao_num");
                                getFiltroMercado("scout/GC",1);
                                break;

                            case 6:
                                //SettingManager.setLastKeyword(MainActivity.this,"variacao_num");
                                getFiltroMercado("scout/PP",1);
                                break;

                            case 7:
                                //SettingManager.setLastKeyword(MainActivity.this,"variacao_num");
                                getFiltroMercado("scout/GS",1);
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
