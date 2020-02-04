package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.RecyclerViewHolder>{

    private Context context;
    private List<ModelMotos> modelMotos = new ArrayList<>();

    public AdapterRecycler(Context context, List<ModelMotos> modelMotos) {
        this.context = context;
        this.modelMotos = modelMotos;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView id;
        private TextView userId;
        private TextView model;
        private TextView volume;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idMoto);
            userId = itemView.findViewById(R.id.userIdMoto);
            model = itemView.findViewById(R.id.modelMoto);
            volume = itemView.findViewById(R.id.volumeMoto);

        }
    }

    @NonNull
    @Override
    public AdapterRecycler.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.task_list_item,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler.RecyclerViewHolder holder, int position) {
        if (modelMotos.size() !=0){
            ModelMotos modelMotos = this.modelMotos.get(position);
            holder.id.setText(modelMotos.getId());
            holder.userId.setText(modelMotos.getUserId());
            holder.model.setText(modelMotos.getModel());
            holder.volume.setText(modelMotos.getVolume());

        }
    }

    @Override
    public int getItemCount() {
        return modelMotos.size();
    }

    public void onChange (List<ModelMotos> modelMotos) {
        this.modelMotos.clear();
        this.modelMotos.addAll(modelMotos);
        notifyDataSetChanged();
    }

}
