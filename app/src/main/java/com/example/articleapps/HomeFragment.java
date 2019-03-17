package com.example.articleapps;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView rvArticles;
    AdapterArticles mAdapter;
    String articles[]={"article1","article2","article3"};

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rvArticles = v.findViewById(R.id.rvArticles);
        rvArticles.setHasFixedSize(true);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvArticles.setLayoutManager(layoutManager);

        ArrayList<String> dataArticles = new ArrayList<>();
        dataArticles.add(articles[0]);
        dataArticles.add(articles[1]);
        dataArticles.add(articles[2]);

        mAdapter = new AdapterArticles(dataArticles, getActivity());
        rvArticles.setAdapter(mAdapter);
        rvArticles.setPadding(130,100,130,100);

        final SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rvArticles);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                RecyclerView.ViewHolder viewHolder = rvArticles.findViewHolderForAdapterPosition(0);
                RelativeLayout rl1 = viewHolder.itemView.findViewById(R.id.rl1);
                rl1.animate().scaleY(1).scaleX(1).setDuration(350).setInterpolator(new AccelerateInterpolator()).start();
            }
        },100);

        rvArticles.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                View v = snapHelper.findSnapView(layoutManager);
                int pos = layoutManager.getPosition(v);

                RecyclerView.ViewHolder viewHolder = rvArticles.findViewHolderForAdapterPosition(pos);
                RelativeLayout rl1 = viewHolder.itemView.findViewById(R.id.rl1);

                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    rl1.animate().setDuration(350).scaleX(1).scaleY(1).setInterpolator(new AccelerateInterpolator()).start();
                }else{
                    rl1.animate().setDuration(350).scaleX(0.75f).scaleY(0.75f).setInterpolator(new AccelerateInterpolator()).start();
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        return v;
    }

}
