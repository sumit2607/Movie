package com.sumit.unit3asyncapiinfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements onClicked {


    private RecyclerView recyclerView;
    private Adapter adapter;
    private final List<ComingSoonDTO> list = new ArrayList<>();
    private  List<NowShowingDTO> nowShowingDTOS = new ArrayList<>();

    private FragmentManager fragmentManager;

    private ShimmerFrameLayout shimmer;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

        setRecyclerView();
        buildList();
        fragmentManager = getActivity().getSupportFragmentManager();

    }

    private void setRecyclerView() {
        adapter = new Adapter((List<ComingSoonDTO>) list, (model, position) -> onClicked(model, position));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);
    }

    private void buildList() {

        ApiService apiCall = Network.getInstance().create(ApiService.class);
       // Call<ArrayList<ResponseDTO>> call = apiCall.getResponse();
        apiCall.getResponse().enqueue(new Callback<ArrayList<ResponseDTO>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseDTO>> call, Response<ArrayList<ResponseDTO>> response) {
                if(response.body()!=null){
                    shimmer.setVisibility(View.GONE);
                    shimmer.stopShimmer();
                    recyclerView.setVisibility(View.VISIBLE);

                    adapter.update((ArrayList<ComingSoonDTO>) list);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseDTO>> call, Throwable t) {

            }
        });
    }

    private void initView(View view) {
        shimmer = view.findViewById(R.id.shimmerFrameLayout);
        recyclerView = view.findViewById(R.id.recyclerView);
    }

    @Override
    public void onClicked(ComingSoonDTO model, int position) {

        SharedPreferenceHelper.writeStringSharedPreference(getContext(),"imageId",model.getPosterurl());
//       //SharedPreferenceHelper.writeStringSharedPreference(getContext(),"titleId",model.getTitle());
//        //SharedPreferenceHelper.writeStringSharedPreference(getContext(),"subtitleId",model.getSubTitle());
//
//        ItemDetailsFragment itemDetailsActivity = new ItemDetailsFragment();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.Container,itemDetailsActivity,"fragmentDetails").addToBackStack("null");
//        transaction.commit();




    }

    @Override
    public void onResume() {
        shimmer.startShimmer();
        super.onResume();
    }

    @Override
    public void onClicked(ResponseDTO model, int position) {

    }
}