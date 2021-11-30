package com.app.sportsmobile.cartola.model;

/**
 * Created by Edson on 09/01/2017.
 */
public class Clubes {

    public String abreviacao;
    public int id;
    public String nome;
    public int posicao;

    public Clubes(String abreviacao,
                  int id,
                  String nome,
                  int posicao
                  )
    {
        this.abreviacao = abreviacao;
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;

    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

}
