package com.app.sportsmobile.cartola.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.sportsmobile.cartola.R;
import com.app.sportsmobile.cartola.model.Atletas;

/**
 * Created by Edson on 23/01/2017.
 */
public class BolaCheiaViewHolder extends RecyclerView.ViewHolder {


    public LinearLayout roomLayJogador;
    public LinearLayout roomLayDetalhes;
    public LinearLayout roomLayComNumeros;
    public LinearLayout roomLaySemNumeros;
    public TextView roomApelido;
    public ImageView roomClubeImagem;
    public ImageView roomFoto;
    public TextView roomPosicaoId;

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




    public BolaCheiaViewHolder(View itemView) {
        super(itemView);

        roomClubeImagem = (ImageView) itemView.findViewById(R.id.clube_imagem);
        roomLayJogador = (LinearLayout)itemView.findViewById(R.id.lay_jogador);
        roomLayComNumeros = (LinearLayout)itemView.findViewById(R.id.lay_com_numeros);
        roomLaySemNumeros = (LinearLayout)itemView.findViewById(R.id.lay_sem_numeros);
        roomLayDetalhes = (LinearLayout)itemView.findViewById(R.id.lay_detalhes);
        roomApelido = (TextView)itemView.findViewById(R.id.apelido);
        roomFoto = (ImageView) itemView.findViewById(R.id.foto);
        roomPosicaoId= (TextView) itemView.findViewById(R.id.posicao_id);
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

    public void bindToPost(Atletas atletas, View.OnClickListener jogadorClickListener) {

        roomApelido.setText(atletas.getApelido());
        roomPosicaoId.setText(String.valueOf(atletas.getPosicaoId()));
        roomLayJogador.setOnClickListener(jogadorClickListener);

        if (atletas.scout != null) {
            roomLayComNumeros.setVisibility(View.VISIBLE);
            roomLaySemNumeros.setVisibility(View.GONE);
            roomCartaoAmarelo.setText(Integer.toString(atletas.getScout().getCartaoAmarelo()));
            roomFaltasCometidas.setText(Integer.toString(atletas.getScout().getFaltasCometidas()));
            roomFinalizacoesDefendidas.setText(Integer.toString(atletas.getScout().getFinalizacoesDefendidas()));
            roomFinalizacoesParaFora.setText(Integer.toString(atletas.getScout().getFinalizacoesParaFora()));
            roomFaltasSofridas.setText(Integer.toString(atletas.getScout().getFaltasSofridas()));
            roomGols.setText(Integer.toString(atletas.getScout().getGols()));
            roomPassesErrados.setText(Integer.toString(atletas.getScout().getPassesErrados()));
            roomRoubadaDeBola.setText(Integer.toString(atletas.getScout().getRoubadaDeBola()));
            roomAssistencia.setText(Integer.toString(atletas.getScout().getAssistencia()));
            roomFinalizacoesNaTrave.setText(Integer.toString(atletas.getScout().getFinalizacoesNaTrave()));
            roomImpedimento.setText(Integer.toString(atletas.getScout().getImpedimento()));
            roomPenaltiPerdido.setText(Integer.toString(atletas.getScout().getPenaltiPerdido()));
            roomGolContra.setText(Integer.toString(atletas.getScout().getGolContra()));
            roomCartaoVermelho.setText(Integer.toString(atletas.getScout().getCartaoVermelho()));
            roomSemSofrerGol.setText(Integer.toString(atletas.getScout().getSemSofrerGol()));
            roomDefesasDificeis.setText(Integer.toString(atletas.getScout().getDefesasDificeis()));
            roomDefesaDePenalti.setText(Integer.toString(atletas.getScout().getDefesaDePenalti()));
            roomGolSofrido.setText(Integer.toString(atletas.getScout().getGolSofrido()));

            if(atletas.scout.CA!= 0){
                roomLayCartaoAmarelo.setVisibility(View.VISIBLE);
            }else{
                roomLayCartaoAmarelo.setVisibility(View.GONE);
            }

            if(atletas.scout.FC!= 0){
                roomLayFaltasCometidas.setVisibility(View.VISIBLE);
            }else{
                roomLayFaltasCometidas.setVisibility(View.GONE);
            }

            if(atletas.scout.FD!= 0){
                roomLayFinalizacoesDefendidas.setVisibility(View.VISIBLE);
            }else{
                roomLayFinalizacoesDefendidas.setVisibility(View.GONE);
            }

            if(atletas.scout.FF!= 0){
                roomLayFinalizacoesParaFora.setVisibility(View.VISIBLE);
            }else{
                roomLayFinalizacoesParaFora.setVisibility(View.GONE);
            }

            if(atletas.scout.FS!= 0){
                roomLayFaltasSofridas.setVisibility(View.VISIBLE);
            }else{
                roomLayFaltasSofridas.setVisibility(View.GONE);
            }


            if(atletas.scout.G!= 0){
                roomLayGols.setVisibility(View.VISIBLE);
            }else{
                roomLayGols.setVisibility(View.GONE);
            }

            if(atletas.scout.PE!= 0){
                roomLayPassesErrados.setVisibility(View.VISIBLE);
            }else{
                roomLayPassesErrados.setVisibility(View.GONE);
            }


            if(atletas.scout.RB!= 0){
                roomLayRoubadaDeBola.setVisibility(View.VISIBLE);
            }else{
                roomLayRoubadaDeBola.setVisibility(View.GONE);
            }

            if(atletas.scout.A!= 0){
                roomLayAssistencia.setVisibility(View.VISIBLE);
            }else{
                roomLayAssistencia.setVisibility(View.GONE);
            }

            if(atletas.scout.FT!= 0){
                roomLayFinalizacoesNaTrave.setVisibility(View.VISIBLE);
            }else{
                roomLayFinalizacoesNaTrave.setVisibility(View.GONE);
            }

            if(atletas.scout.I!= 0){
                roomLayImpedimento.setVisibility(View.VISIBLE);
            }else{
                roomLayImpedimento.setVisibility(View.GONE);
            }

            if(atletas.scout.PP!= 0){
                roomLayPenaltiPerdido.setVisibility(View.VISIBLE);
            }else{
                roomLayPenaltiPerdido.setVisibility(View.GONE);
            }

            if(atletas.scout.GC!= 0){
                roomLayGolContra.setVisibility(View.VISIBLE);
            }else{
                roomLayGolContra.setVisibility(View.GONE);
            }

            if(atletas.scout.CV!= 0){
                roomLayCartaoVermelho.setVisibility(View.VISIBLE);
            }else{
                roomLayCartaoVermelho.setVisibility(View.GONE);
            }

            if(atletas.scout.SG!= 0){
                roomLaySemSofrerGol.setVisibility(View.VISIBLE);
            }else{
                roomLaySemSofrerGol.setVisibility(View.GONE);
            }

            if(atletas.scout.DD!= 0){
                roomLayDefesasDificeis.setVisibility(View.VISIBLE);
            }else{
                roomLayDefesasDificeis.setVisibility(View.GONE);
            }

            if(atletas.scout.DP!= 0){
                roomLayDefesaDePenalti.setVisibility(View.VISIBLE);
            }else{
                roomLayDefesaDePenalti.setVisibility(View.GONE);
            }

            if(atletas.scout.GS!= 0){
                roomLayGolSofrido.setVisibility(View.VISIBLE);
            }else{
                roomLayGolSofrido.setVisibility(View.GONE);
            }

        }else{

            roomLayComNumeros.setVisibility(View.GONE);
            roomLaySemNumeros.setVisibility(View.VISIBLE);

        }


    }


}
