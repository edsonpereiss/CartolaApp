package com.app.sportsmobile.cartola.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.sportsmobile.cartola.R;
import com.app.sportsmobile.cartola.model.MeuTime;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by Edson on 15/02/2017.
 */
public class MeuTimeViewHolder extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<MeuTime> data= Collections.emptyList();
    MeuTime current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public MeuTimeViewHolder(Context context, List<MeuTime> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_meu_time, parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        final MyHolder viewHolder= (MyHolder) holder;
        MeuTime current=data.get(position);
        viewHolder.roomApelido.setText(current.getApelido());
        viewHolder.roomJogosNum.setText(String.valueOf(current.getJogosNum()));
        viewHolder.roomMediaNum.setText(String.valueOf(current.getMediaNum()));
        viewHolder.roomPontosNum.setText(String.valueOf(current.getPontosNum()));
        viewHolder.roomPosicaoId.setText(String.valueOf(current.getPosicaoId()));
        viewHolder.roomPrecoNum.setText(String.valueOf(current.getPrecoNum()));
        viewHolder.roomVariacaoNum.setText(String.valueOf(current.getVariacaoNum()));

        String search_variacao_negativa  = "-";
        String search_variacao_neutra  = "0.0";
        String media_num = String.valueOf(current.getVariacaoNum());
        boolean hasMediaNegativa = (media_num.toLowerCase().indexOf(search_variacao_negativa .toLowerCase()) != -1);
        boolean hasMediaNeutra = (media_num.toLowerCase().indexOf(search_variacao_neutra .toLowerCase()) != -1);

        if (hasMediaNegativa) {
            viewHolder.roomVariacaoNum.setTextColor(context.getResources().getColor(R.color.color_position_down));

        }else if (hasMediaNeutra)
        {
            viewHolder.roomVariacaoNum.setTextColor(context.getResources().getColor(R.color.color_position_stop));
        }
        else
        {
            viewHolder.roomVariacaoNum.setTextColor(context.getResources().getColor(R.color.color_position_up));
        }


        int status_id = current.getStatusId();
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


        int posicao_id = current.getPosicaoId();
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



        String foto = current.getFoto();
        if (foto != null){
            Picasso.with(context).load(foto.replace("FORMATO","140x140")).placeholder(R.drawable.ic_people3).into(viewHolder.roomFoto);
        }else{
            Picasso.with(context).load(R.drawable.ic_people3).into(viewHolder.roomFoto);
        }


    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        public LinearLayout roomLayJogador;
        public LinearLayout roomLayDetalhes;
        public LinearLayout roomLayComNumeros;
        public LinearLayout roomLaySemNumeros;
        public TextView roomApelido;
        public ImageView roomClubeImagem;
        public ImageView roomFoto;
        public TextView roomJogosNum;
        public TextView roomMediaNum;
        public TextView roomPontosNum;
        public TextView roomPosicaoId;
        public TextView roomPrecoNum;
        public ImageView roomStatusId;
        public TextView roomVariacaoNum;

        public ImageView roomClubeMandanteImagem;
        public ImageView roomClubeVisitanteImagem;
        public TextView roomCartaoAmarelo;
        public TextView roomFaltasCometidas;
        public TextView roomFinalizacoesDefendidas;
        public TextView roomFinalizacoesParaFora;
        public TextView roomFaltasSofridas;
        public TextView roomGols;
        public TextView roomPassesErrados;
        public TextView roomRoubadaDeBola;
        public TextView roomAssistencia;
        public TextView roomFinalizacoesNaTrave;
        public TextView roomImpedimento;
        public TextView roomPenaltiPerdido;
        public TextView roomGolContra;
        public TextView roomCartaoVermelho;
        public TextView roomSemSofrerGol;
        public TextView roomDefesasDificeis;
        public TextView roomDefesaDePenalti;
        public TextView roomGolSofrido;
        public LinearLayout roomLayCartaoAmarelo;
        public LinearLayout roomLayFaltasCometidas;
        public LinearLayout roomLayFinalizacoesDefendidas;
        public LinearLayout roomLayFinalizacoesParaFora;
        public LinearLayout roomLayFaltasSofridas;
        public LinearLayout roomLayGols;
        public LinearLayout roomLayPassesErrados;
        public LinearLayout roomLayRoubadaDeBola;
        public LinearLayout roomLayAssistencia;
        public LinearLayout roomLayFinalizacoesNaTrave;
        public LinearLayout roomLayImpedimento;
        public LinearLayout roomLayPenaltiPerdido;
        public LinearLayout roomLayGolContra;
        public LinearLayout roomLayCartaoVermelho;
        public LinearLayout roomLaySemSofrerGol;
        public LinearLayout roomLayDefesasDificeis;
        public LinearLayout roomLayDefesaDePenalti;
        public LinearLayout roomLayGolSofrido;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            roomClubeImagem = (ImageView) itemView.findViewById(R.id.clube_imagem);
            roomLayJogador = (LinearLayout)itemView.findViewById(R.id.lay_jogador);
            roomLayComNumeros = (LinearLayout)itemView.findViewById(R.id.lay_com_numeros);
            roomLaySemNumeros = (LinearLayout)itemView.findViewById(R.id.lay_sem_numeros);
            roomLayDetalhes = (LinearLayout)itemView.findViewById(R.id.lay_detalhes);
            roomApelido = (TextView)itemView.findViewById(R.id.apelido);
            roomFoto = (ImageView) itemView.findViewById(R.id.foto);
            roomJogosNum = (TextView) itemView.findViewById(R.id.jogos_num);
            roomMediaNum = (TextView) itemView.findViewById(R.id.media_num);
            roomPontosNum = (TextView) itemView.findViewById(R.id.pontos_num);
            roomPosicaoId= (TextView) itemView.findViewById(R.id.posicao_id);
            roomPrecoNum = (TextView) itemView.findViewById(R.id.preco_num);
            roomStatusId = (ImageView) itemView.findViewById(R.id.status_id);
            roomVariacaoNum = (TextView) itemView.findViewById(R.id.variacao_num);
            roomCartaoAmarelo = (TextView) itemView.findViewById(R.id.cartao_amarelo);
            roomFaltasCometidas = (TextView) itemView.findViewById(R.id.faltas_cometidas);
            roomFinalizacoesDefendidas = (TextView) itemView.findViewById(R.id.finalizacoes_defendidas);
            roomFinalizacoesParaFora = (TextView) itemView.findViewById(R.id.finalizacoes_fora);
            roomFaltasSofridas = (TextView) itemView.findViewById(R.id.faltas_sofridas);
            roomGols = (TextView) itemView.findViewById(R.id.gols);
            roomPassesErrados = (TextView) itemView.findViewById(R.id.passes_errados);
            roomRoubadaDeBola = (TextView) itemView.findViewById(R.id.roubada_bola);
            roomAssistencia = (TextView) itemView.findViewById(R.id.assistencia);
            roomFinalizacoesNaTrave = (TextView) itemView.findViewById(R.id.finalizacoes_trave);
            roomImpedimento = (TextView) itemView.findViewById(R.id.impedimento);
            roomPenaltiPerdido = (TextView) itemView.findViewById(R.id.penalti_perdido);
            roomGolContra = (TextView) itemView.findViewById(R.id.gol_contra);
            roomCartaoVermelho = (TextView) itemView.findViewById(R.id.cartao_vermelho);
            roomSemSofrerGol = (TextView) itemView.findViewById(R.id.sem_sofrer_gol);
            roomDefesasDificeis = (TextView) itemView.findViewById(R.id.defesas_dificeis);
            roomDefesaDePenalti = (TextView) itemView.findViewById(R.id.defesa_penalti);
            roomGolSofrido = (TextView) itemView.findViewById(R.id.gol_sofrido);

            roomClubeMandanteImagem = (ImageView) itemView.findViewById(R.id.clube_mandante_imagem);
            roomClubeVisitanteImagem = (ImageView) itemView.findViewById(R.id.clube_visitante_imagem);
            roomLayCartaoAmarelo = (LinearLayout) itemView.findViewById(R.id.lay_cartao_amarelo);
            roomLayFaltasCometidas = (LinearLayout) itemView.findViewById(R.id.lay_faltas_cometidas);
            roomLayFinalizacoesDefendidas = (LinearLayout) itemView.findViewById(R.id.lay_finalizacoes_defendidas);
            roomLayFinalizacoesParaFora = (LinearLayout) itemView.findViewById(R.id.lay_finalizacoes_fora);
            roomLayFaltasSofridas = (LinearLayout) itemView.findViewById(R.id.lay_faltas_sofridas);
            roomLayGols = (LinearLayout) itemView.findViewById(R.id.lay_gols);
            roomLayPassesErrados = (LinearLayout) itemView.findViewById(R.id.lay_passes_errados);
            roomLayRoubadaDeBola = (LinearLayout) itemView.findViewById(R.id.lay_roubada_bola);
            roomLayAssistencia = (LinearLayout) itemView.findViewById(R.id.lay_assistencia);
            roomLayFinalizacoesNaTrave = (LinearLayout) itemView.findViewById(R.id.lay_finalizacoes_trave);
            roomLayImpedimento = (LinearLayout) itemView.findViewById(R.id.lay_impedimento);
            roomLayPenaltiPerdido = (LinearLayout) itemView.findViewById(R.id.lay_penalti_perdido);
            roomLayGolContra = (LinearLayout) itemView.findViewById(R.id.lay_gol_contra);
            roomLayCartaoVermelho = (LinearLayout) itemView.findViewById(R.id.lay_cartao_vermelho);
            roomLaySemSofrerGol = (LinearLayout) itemView.findViewById(R.id.lay_sem_sofrer_gol);
            roomLayDefesasDificeis = (LinearLayout) itemView.findViewById(R.id.lay_defesas_dificeis);
            roomLayDefesaDePenalti = (LinearLayout) itemView.findViewById(R.id.lay_defesa_penalti);
            roomLayGolSofrido = (LinearLayout) itemView.findViewById(R.id.lay_gol_sofrido);
        }



    }

}