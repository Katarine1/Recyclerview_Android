package com.example.teste.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste.R;
import com.example.teste.model.Nomes;

import java.util.List;

public class NomesAdapter extends RecyclerView.Adapter<NomesAdapter.ViewHolderNomes> implements View.OnClickListener, View.OnLongClickListener {

    private View.OnClickListener listener;
    private View.OnLongClickListener listenerLong;

    private List<Nomes> lista;

    private Context context;
    private AlertDialog alert;

    public NomesAdapter(Context context, List<Nomes> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolderNomes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_nome, null, false);

        v.setOnClickListener(this);
        v.setOnLongClickListener(this);

        return new ViewHolderNomes(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderNomes holder, final int position) {

        holder.tNome.setText(lista.get(position).getNome());

        holder.btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

               AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
               builder.setTitle("Excluir");
               builder.setMessage("Deseja excluir o Item "+ position + " ?");
               builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               });
               builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Log.i("ITEM", "onClick: Item Selecionado = "+ position);
                       lista.remove(position);
                       Toast.makeText(v.getContext(), "Item removido !", Toast.LENGTH_SHORT).show();
                       Log.i("EXCLUIR", "onClick: Item removido !");
                       notifyItemChanged(position);
                       notifyDataSetChanged();
                   }
               });
               alert = builder.create();
               alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean onLongClick(View v) {
        if(listenerLong != null){
            listener.onClick(v);
        }
        return false;
    }

    public void setListenerLong(View.OnLongClickListener listenerLong) {
        this.listenerLong = listenerLong;
    }

    public class ViewHolderNomes extends RecyclerView.ViewHolder {

        TextView tId, tNome;
        ImageButton btnButton;

        public ViewHolderNomes(@NonNull final View itemView) {
            super(itemView);

            tNome = itemView.findViewById(R.id.t_nome);
            btnButton = itemView.findViewById(R.id.imageButtonExcluir);

        }
    }
}
