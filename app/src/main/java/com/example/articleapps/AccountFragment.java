package com.example.articleapps;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    private RecyclerView rvMyArticle;
    private AdapterMyArticles mAdapter;
    String articles[]={"article1","article2","article3"};

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container, false);
        rvMyArticle = v.findViewById(R.id.rvMyArticle);
        rvMyArticle.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        rvMyArticle.setLayoutManager(layoutManager);

        ArrayList<String> dataArticles = new ArrayList<>();
        dataArticles.add(articles[0]);
        dataArticles.add(articles[1]);
        dataArticles.add(articles[2]);

        mAdapter    = new AdapterMyArticles(dataArticles,getActivity());
        rvMyArticle.setAdapter(mAdapter);

        return v;
    }

}
