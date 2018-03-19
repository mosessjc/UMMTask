package com.ummtask.moses.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ummtask.moses.R;
import com.ummtask.moses.constants.Data;
import com.ummtask.moses.presenter.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VEntertainmentFragment extends Fragment {
    //RecyclerView
    Unbinder unbinder;
    @BindView(R.id.rvEntertainment)
    RecyclerView rvEntertainment;
    public static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    View view;

    public VEntertainmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.ventertainment_fragment, container, false);
        unbinder =  ButterKnife.bind(this, view);
        setUpViews();
        setUpListeners();
        return view;
    }

    public void setUpViews() {
        //RecyclerView
        rvEntertainment = (RecyclerView) view.findViewById(R.id.rvEntertainment);
        rvEntertainment.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rvEntertainment.setLayoutManager(mLayoutManager);

        mAdapter = new Presenter(getActivity(), Data.othersData());
        rvEntertainment.setAdapter(mAdapter);
    }

    public void setUpListeners() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
