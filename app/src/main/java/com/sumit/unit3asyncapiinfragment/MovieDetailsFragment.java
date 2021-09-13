package com.sumit.unit3asyncapiinfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class MovieDetailsFragment extends Fragment {



    private ImageView image;
    private TextView title, subtitle;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intitView(view);
        setdata();
    }

    private void setdata() {
        String imageID = SharedPreferenceHelper.getStringSharedPreference(getContext(),"imageId");
        String titleId = SharedPreferenceHelper.getStringSharedPreference(getContext(),"titleId");
        String subtitleId = SharedPreferenceHelper.getStringSharedPreference(getContext(),"subtitleId");
        Glide.with(image).load(imageID).into(image);
        title.setText(titleId);
        subtitle.setText(subtitleId);

    }

    private void intitView(View view) {
        image= view.findViewById(R.id.image);
        title = view.findViewById(R.id.image_description);
        subtitle = view.findViewById(R.id.image_description2);
    }
}