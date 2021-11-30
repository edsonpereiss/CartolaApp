package com.app.sportsmobile.cartola.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.sportsmobile.cartola.R;
import com.app.sportsmobile.cartola.model.Partidas;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;


public class PartidasViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout roomLayRodada;
    public ImageView roomImagemMandante;
    public ImageView roomImagemVisitante;
    public TextView roomLocal;
    public TextView roomPartidaData;
    public TextView roomPosicaoMandante;
    public TextView roomPosicaoVisitante;
    public LinearLayout roomLayAproveitamentoMandante;
    public LinearLayout roomLayAproveitamentoVisitante;


    public PartidasViewHolder(View itemView) {
        super(itemView);
        roomLayRodada = (LinearLayout)itemView.findViewById(R.id.lay_rodada);
        roomImagemVisitante = (ImageView) itemView.findViewById(R.id.visitante_imagem);
        roomImagemMandante = (ImageView) itemView.findViewById(R.id.mandante_imagem);
        roomLocal = (TextView) itemView.findViewById(R.id.local);
        roomPartidaData = (TextView) itemView.findViewById(R.id.data);
        roomPosicaoMandante = (TextView) itemView.findViewById(R.id.posicao_mandante);
        roomPosicaoVisitante = (TextView) itemView.findViewById(R.id.posicao_visitante);
        roomLayAproveitamentoMandante = (LinearLayout)itemView.findViewById(R.id.lay_aproveitamento_mandante);
        roomLayAproveitamentoVisitante = (LinearLayout)itemView.findViewById(R.id.lay_aproveitamento_visitante);

    }

    public void bindToPost(Partidas partidas, View.OnClickListener rodadaClickListener) {


        roomLocal.setText(partidas.getLocal());
        roomPartidaData.setText(partidas.getPartidaData());
        roomPosicaoMandante.setText(String.valueOf(partidas.getClubeCasaPosicao()));
        roomPosicaoVisitante.setText(String.valueOf(partidas.getClubeVisitantePosicao()));
        roomLayRodada.setOnClickListener(rodadaClickListener);

    }


}