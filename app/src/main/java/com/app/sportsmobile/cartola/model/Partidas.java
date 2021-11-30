package com.app.sportsmobile.cartola.model;

import java.util.List;

/**
 * Created by Edson on 16/01/2017.
 */
public class Partidas {

    public int clube_casa_id;
    public int clube_casa_posicao;
    public int clube_visitante_id;
    public int clube_visitante_posicao;
    public String local;
    public String partida_data;
    public String url_confronto;
    public String url_trasmissao;
    public boolean valida;
    public List<String> aproveitamento_mandante;
    public List<String> aproveitamento_visitante;
    public Partidas(){

    }

    public Partidas(int clube_casa_id,
                    int clube_casa_posicao,
                    int clube_visitante_id,
                    int clube_visitante_posicao,
                    String local,
                    String partida_data,
                    String url_confronto,
                    String url_trasmissao,
                    boolean valida)
    {
        this.clube_casa_id = clube_casa_id;
        this.clube_casa_posicao = clube_casa_posicao;
        this.clube_visitante_id = clube_visitante_id;
        this.clube_visitante_posicao = clube_visitante_posicao;
        this.local = local;
        this.partida_data = partida_data;
        this.url_confronto = url_confronto;
        this.url_trasmissao = url_trasmissao;
        this.valida = valida;

    }

    public int getClubeCasaId() {
        return clube_casa_id;
    }

    public void setClubeCasaId(int clube_casa_id) {
        this.clube_casa_id = clube_casa_id;
    }


    public int getClubeCasaPosicao() {
        return clube_casa_posicao;
    }

    public void setClubeCasaPosicao(int clube_casa_posicao) {
        this.clube_casa_posicao = clube_casa_posicao;
    }


    public int getClubeVisitanteId() {
        return clube_visitante_id;
    }

    public void setClubeVisitanteId(int clube_visitante_id) {
        this.clube_visitante_id = clube_visitante_id;
    }


    public int getClubeVisitantePosicao() {
        return clube_visitante_posicao;
    }

    public void setClubeVisitantePosicao(int clube_visitante_posicao) {
        this.clube_visitante_posicao = clube_visitante_posicao;
    }


    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }


    public String getPartidaData() {
        return partida_data;
    }

    public void setPartidaData(String partida_data) {
        this.partida_data = partida_data;
    }


    public String getUrlConfronto() {
        return url_confronto;
    }

    public void setUrlConfronto(String url_confronto) {
        this.url_confronto = url_confronto;
    }


    public boolean getValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }


    public String getUrlTransmissao(){
        return url_trasmissao;
    }

    public void setUrlTransmissao(String url_trasmissao) {
        this.url_trasmissao = url_trasmissao;
    }

    public List<String> getAproveitamento_mandante() {
        return aproveitamento_mandante;
    }

    public void setAproveitamento_mandante(List<String> aproveitamento_mandante) {
        this.aproveitamento_mandante = aproveitamento_mandante;
    }

    public List<String> getAproveitamento_visitante() {
        return aproveitamento_visitante;
    }

    public void setAproveitamento_visitante(List<String> aproveitamento_visitante) {
        this.aproveitamento_visitante = aproveitamento_visitante;
    }

}

