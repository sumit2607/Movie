package com.sumit.unit3asyncapiinfragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView etTitle, etSubTitle;
    private ImageView etImage;
    private LinearLayout linearLayout;
    private OnClickListener onClickListener;

    public ViewHolder(@NonNull  View itemView,OnClickListener onClickListener) {
        super(itemView);
        this.onClickListener = onClickListener;
        initView(itemView);
    }

    private void initView(View itemView) {
        etTitle = itemView.findViewById(R.id.textview1);
        etSubTitle = itemView.findViewById(R.id.textview12);
        etImage = itemView.findViewById(R.id.ivImage);
        linearLayout = itemView.findViewById(R.id.LinearLayout);


    }

    public void setData(ComingSoonDTO model){

        Glide.with(etImage).load(model.getPosterurl()).into(etImage);
        //etTitle.setText(model.getTitle());
      //  etSubTitle.setText(model.getSubTitle());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClicked(model,getAdapterPosition());
            }
        });
    }
}