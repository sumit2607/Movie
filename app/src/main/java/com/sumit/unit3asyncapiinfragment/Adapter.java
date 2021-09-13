package com.sumit.unit3asyncapiinfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    List<ComingSoonDTO> list;
    OnClickListener onClickListener;

    public Adapter(List<ComingSoonDTO> list,OnClickListener onClickListener){
        this.list = list;
        this.onClickListener = onClickListener;
    }
    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        ComingSoonDTO model = list.get(position);
        holder.setData(model);

    }

    public  void update(ArrayList<ComingSoonDTO> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
