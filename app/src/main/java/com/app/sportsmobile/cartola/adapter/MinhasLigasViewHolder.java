package com.app.sportsmobile.cartola.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sportsmobile.cartola.R;
import com.app.sportsmobile.cartola.model.MinhasLigas;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * Created by Edson on 15/02/2017.
 */
public class MinhasLigasViewHolder extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    File localFile;
    List<MinhasLigas> data= Collections.emptyList();
    MinhasLigas current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public MinhasLigasViewHolder(Context context, List<MinhasLigas> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_minhas_ligas, parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        final MyHolder viewHolder= (MyHolder) holder;
        MinhasLigas current=data.get(position);
        viewHolder.roomNome.setText(current.getNome());
        viewHolder.roomDescricao.setText(current.getDescricao());



        String foto = current.getFlamula();
        if (foto != null){
            Picasso.with(context).load(foto).placeholder(R.drawable.ic_escudo2).into(viewHolder.roomFlamula);
        }else{
            Picasso.with(context).load(R.drawable.ic_escudo2).into(viewHolder.roomFlamula);
        }


    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        public TextView roomNome;
        public TextView roomDescricao;
        public ImageView roomFlamula;


        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            roomFlamula = (ImageView) itemView.findViewById(R.id.flamula_imagem);
            roomNome = (TextView)itemView.findViewById(R.id.nome);
            roomDescricao = (TextView)itemView.findViewById(R.id.descricao);

        }



    }
}

