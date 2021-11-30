package com.app.sportsmobile.cartola.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edson on 09/01/2017.
 */
public class Content {

    public List<Atletas> atletas = new ArrayList<Atletas>();
    public List<Clubes> clubes = new ArrayList<Clubes>();

    public Content(List atletas,
                   List clubes
    )
    {

        this.atletas = atletas;
        this.clubes = clubes;
    }

    public List<Atletas> getAtletas(){
        return atletas;
    }

    public void setAtletas(List<Atletas> atletas){
        atletas = atletas;
    }


    public List<Clubes> getClubes(){
        return clubes;
    }

    public void setClubes(List<Clubes> clubes){
        clubes = clubes;
    }

}
