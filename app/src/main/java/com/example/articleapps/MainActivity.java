package com.example.articleapps;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView btFavorite,btAccount;
    ImageButton btHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        btHome      = findViewById(R.id.btHome);
        btFavorite  = findViewById(R.id.btFavorite);
        btAccount   = findViewById(R.id.btAccount);

        btHome.setOnClickListener(this);
        btFavorite.setOnClickListener(this);
        btAccount.setOnClickListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment!=null){
            FragmentManager fragmentManager         = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,fragment);
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
            fragmentTransaction.commit();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btHome :
                loadFragment(new HomeFragment());
                break;
            case R.id.btFavorite:
                loadFragment(new FavoriteFragment());
                break;
            case R.id.btAccount :
                loadFragment(new AccountFragment());
                break;
        }
    }
}
