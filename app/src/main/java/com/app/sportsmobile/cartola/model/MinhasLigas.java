package com.app.sportsmobile.cartola.model;

/**
 * Created by Edson on 15/02/2017.
 */
public class MinhasLigas {

    public String nome;
    public String descricao;
    public String slug;
    public String url_flamula_png;


    public MinhasLigas() {
    }

    public MinhasLigas(String nome,
                       String descricao,
                       String slug,
                       String url_flamula_png
    )
    {
        this.nome = nome;
        this.descricao = descricao;
        this.slug = slug;
        this.url_flamula_png = url_flamula_png;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }


    public String getFlamula() {
        return url_flamula_png;
    }

    public void setFlamula(String url_flamula_svg) {
        this.url_flamula_png = url_flamula_svg;
    }
}