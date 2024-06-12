package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContatosAdapter extends RecyclerView.Adapter<ContatosAdapter.ViewHolder> {

    private List<String> contatos;
    private OnItemClickListener clickListener;

    public interface OnItemClickListener {
        void onItemClick(String contato);
    }

    public ContatosAdapter(List<String> contatos, OnItemClickListener clickListener) {
        this.contatos = contatos;
        this.clickListener = clickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNome;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String contato = contatos.get(position);
        holder.textViewNome.setText(contato);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(contato);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contatos.size();
    }
}
