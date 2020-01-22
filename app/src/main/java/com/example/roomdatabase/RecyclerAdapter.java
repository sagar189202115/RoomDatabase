package com.example.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<User> arrayList;
    Context context;
public RecyclerAdapter(Context context, List<User> arrayList)
{
    this.arrayList=arrayList;
    this.context=context;
}
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.item_view,parent,false);
        RecyclerAdapter.ViewHolder rv=new RecyclerAdapter.ViewHolder(view);
        return rv;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        User model=arrayList.get(position);
        holder.name.setText(model.getName());
        holder.id.setText(model.getId());
        holder.email.setText(model.getEmail());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder

    {
        TextView name,id,email;
        private ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            id=itemView.findViewById(R.id.id);
            email=itemView.findViewById(R.id.email);

        }
    }
}
