package com.app.sportsmobile.cartola.model;

/**
 * Created by Edson on 15/02/2017.
 */
public class Time {

    public String nome;
    public String nome_cartola;
    public String slug;
    public String url_escudo_png;
    public String url_camisa_png;
    public double patrimonio;
    public double pontos;

    public Time() {
    }

    public Time(String nome,
                   String nome_cartola,
                   String slug,
                   String url_escudo_png,
                   String url_camisa_png,
                   double patrimonio,
                   double pontos
    )
    {
        this.nome = nome;
        this.nome_cartola = nome_cartola;
        this.slug = slug;
        this.url_escudo_png = url_escudo_png;
        this.url_camisa_png = url_camisa_png;
        this.patrimonio = patrimonio;
        this.pontos = pontos;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCartola() {
        return nome_cartola;
    }

    public void setNomeCartola(String nome_cartola) {
        this.nome_cartola = nome_cartola;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCamisa() {
        return url_camisa_png;
    }

    public void setCamisa(String url_camisa_png) {
        this.url_camisa_png = url_camisa_png;
    }

    public String getEscudo() {
        return url_escudo_png;
    }

    public void setEscudo(String url_escudo_png) {
        this.url_escudo_png = url_escudo_png;
    }

}
