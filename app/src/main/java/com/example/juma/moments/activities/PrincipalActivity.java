package com.example.juma.moments.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.juma.moments.R;
import com.example.juma.moments.fragments.AddFragment;
import com.example.juma.moments.fragments.MapsFragment;
import com.example.juma.moments.fragments.NearFragment;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);



        ((BottomNavigationView)findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return navigationAcoordinTo(item.getItemId());
            }
        });


        navigationAcoordinTo(R.id.navigation_NearMoments);
    }


    private Fragment getFragmentFor(int id){
        switch (id){
            case R.id.navigation_NearMoments:
                return new NearFragment();
            case R.id.navigation_Maps:
                return new MapsFragment();
            case R.id.navigation_addMoments:
                return new AddFragment();
        }
        return null;
    }

    private boolean navigationAcoordinTo(int id){
        try {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content,getFragmentFor(id))
                    .commit();
            return  true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
