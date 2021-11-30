package com.app.sportsmobile.cartola.model;

/**
 * Created by Edson on 15/02/2017.
 */
public class MeuTime {

    public String apelido;
    public int atleta_id;
    public int clube_id;
    public String foto;
    public int jogos_num;
    public double media_num;
    public String nome;
    public double pontos_num;
    public int posicao_id;
    public double preco_num;
    public int rodada_id;
    public int status_id;
    public double variacao_num;

    public MeuTime() {
    }

    public MeuTime(String apelido,
                   int atleta_id,
                   int clube_id,
                   String foto,
                   int jogos_num,
                   double media_num,
                   String nome,
                   double pontos_num,
                   int posicao_id,
                   double preco_num,
                   int rodada_id,
                   int status_id,
                   double variacao_num
    )
    {
        this.apelido = apelido;
        this.atleta_id = atleta_id;
        this.clube_id = clube_id;
        this.foto = foto;
        this.jogos_num = jogos_num;
        this.media_num = media_num;
        this.nome = nome;
        this.pontos_num = pontos_num;
        this.posicao_id = posicao_id;
        this.preco_num = preco_num;
        this.rodada_id = rodada_id;
        this.status_id = status_id;
        this.variacao_num = variacao_num;

    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }


    public int getAtletaId() {
        return atleta_id;
    }

    public void setAtletaId(int atleta_id) {
        this.atleta_id = atleta_id;
    }


    public int getClubeId() {
        return clube_id;
    }

    public void setClubeId(int clube_id) {
        this.clube_id = clube_id;
    }


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public int getJogosNum() {
        return jogos_num;
    }

    public void setJogosNum(int jogos_num) {
        this.jogos_num = jogos_num;
    }


    public double getMediaNum() {
        return media_num;
    }

    public void setMediaNum(double media_num) {
        this.media_num = media_num;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getPontosNum() {
        return pontos_num;
    }

    public void setPontosNum(double pontos_num) {
        this.pontos_num = pontos_num;
    }


    public int getPosicaoId() {
        return posicao_id;
    }

    public void setPosicaoId(int posicao_id) {
        this.posicao_id = posicao_id;
    }


    public double getPrecoNum() {
        return preco_num;
    }

    public void setPrecoNum(double preco_num) {
        this.preco_num = preco_num;
    }


    public int getRodadaId() {
        return rodada_id;
    }

    public void setRodadaId(int rodada_id) {
        this.rodada_id = rodada_id;
    }

    public int getStatusId() {
        return status_id;
    }

    public void setStatusId(int status_id) {
        this.status_id = status_id;
    }


    public double getVariacaoNum() {
        return variacao_num;
    }

    public void setVariacaoNum(double variacao_num) {
        this.variacao_num = variacao_num;
    }

}