package com.adsinc.ecom;

import static com.adsinc.ecom.HomeActivity.createCategory;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import aglibs.loading.skeleton.layout.SkeletonRelativeLayout;
import aglibs.loading.skeleton.view.SkeletonButtonView;

public class buyproduct extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SkeletonRelativeLayout skeletonLayout;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyproduct);
        recyclerView = findViewById(R.id.recyclerView);
        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

// Set the status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor("#FFFFFF"));}
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        skeletonLayout = findViewById(R.id.skeletonLayout);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                skeletonLayout.stopLoading();
            }
        }, 5000); // 5 seconds in milliseconds

        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        list.add(createCategory("Home"));
        list.add(createCategory("Skincare"));
        list.add(createCategory("Tea"));
        list.add(createCategory("Incense Sticks"));
        list.add(createCategory("Cosmetics"));
        list.add(createCategory("Halal Meat"));
        list.add(createCategory("Tooth Pastes"));
        list.add(createCategory("Rice"));
        list.add(createCategory("Flour"));
        list.add(createCategory("Lentils & Beans"));
        list.add(createCategory("Spices"));
        list.add(createCategory("Ready to Eat"));
        list.add(createCategory("Snacks"));
        list.add(createCategory("Sweets"));
        list.add(createCategory("Biscuits"));
        list.add(createCategory("Pastes & Pickles"));
        list.add(createCategory("Home"));
        list.add(createCategory("Skincare"));
        recyclerView.setAdapter(new Recyclerview3Adapter(list));
        recyclerView.setLayoutManager(new LinearLayoutManager(buyproduct.this, LinearLayoutManager.HORIZONTAL, false));
    }
    public class Recyclerview3Adapter extends RecyclerView.Adapter<buyproduct.Recyclerview3Adapter.ViewHolder> {
        ArrayList<HashMap<String, Object>> _data;
        public Recyclerview3Adapter(ArrayList<HashMap<String, Object>> _arr) {
            _data = _arr;
        }
        @Override
        public buyproduct.Recyclerview3Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater _inflater = getLayoutInflater();
            View _v = _inflater.inflate(R.layout.products, null);

            /* .placeholder(drawable)*/

           /* RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            _v.setLayoutParams(_lp);*/
            return new buyproduct.Recyclerview3Adapter.ViewHolder(_v);
        }
        @Override
        public void onBindViewHolder(buyproduct.Recyclerview3Adapter.ViewHolder _holder, final int _position) {
            View _view = _holder.itemView;

        }
        @Override
        public int getItemCount() {
            return _data.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(View v) {
                super(v);
            }
        }
    }

}
