package com.adsinc.ecom;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> list2 = new ArrayList<>();
    private RecyclerView recyclerView1, recyclerView2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView1 = findViewById(R.id.recyclerView);
        recyclerView2 = findViewById(R.id.recyclerView1);
        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
// Set the status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor("#f5f9f9"));}
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        // Adding each category to the list
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
        list.add(createCategory("Drinks"));
        list.add(createCategory("Canned Items"));
        list.add(createCategory("Haircare"));
        list.add(createCategory("Health Care"));
        list.add(createCategory("Frozen Foods"));
        list.add(createCategory("Fresh Vegetables"));
        list.add(createCategory("Religious Items"));
        list.add(createCategory("Perfume"));
        list2.add(createproduct("Mama Instant Oriental Kitchen Hot Korean Noodles -85g", "https://desipolska.pl/desi/wp-content/uploads/2024/02/mama-oriental-kitchen-hot-korean.jpg", "1000"));
        // Assuming you would want to do something with the list here,
        // for example printing each category.
        for (HashMap<String, Object> category : list) {
            System.out.println(category.get("category"));
        }
        recyclerView1.setAdapter(new Recyclerview1Adapter(list));
        recyclerView1.setLayoutManager(new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setAdapter(new Recyclerview2Adapter(list2));
        recyclerView2.setLayoutManager(new GridLayoutManager(this, 2));

    // Helper method to create category map

    }
    private static HashMap<String, Object> createCategory(String categoryName) {
        HashMap<String, Object> category = new HashMap<>();
        category.put("category", categoryName);
        return category;
    }
    private static HashMap<String, Object> createproduct(String name, String image, String price) {
        HashMap<String, Object> category = new HashMap<>();
        category.put("name", name);
        category.put("image", image);
        category.put("price", price);
        return category;
    }
    public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
        ArrayList<HashMap<String, Object>> _data;
        public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
            _data = _arr;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater _inflater = getLayoutInflater();
            View _v = _inflater.inflate(R.layout.catlist, null);
            RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            _v.setLayoutParams(_lp);
            return new ViewHolder(_v);
        }
        @Override
        public void onBindViewHolder(ViewHolder _holder, final int _position) {
            View _view = _holder.itemView;
            final TextView textview1 = _view.findViewById(R.id.name);
            if (_data.get((int)_position).get("category").toString().equals("Home")) {
                LinearLayout layout = _view.findViewById(R.id.linear);
                layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.round));
                ImageView imageView = _view.findViewById(R.id.image);
                imageView.setImageResource(R.drawable.home);
                imageView.setColorFilter(getResources().getColor(R.color.base5));
            }else {
                LinearLayout layout = _view.findViewById(R.id.linear);
                layout.setBackgroundColor(Color.parseColor("#00000000"));
                ImageView imageView = _view.findViewById(R.id.image);
                imageView.setImageResource(R.drawable.shop);
                imageView.setColorFilter(getResources().getColor(R.color.base1));}
            textview1.setText(_data.get((int)_position).get("category").toString());
            RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            _view.setLayoutParams(_lp);
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
    public class Recyclerview2Adapter extends RecyclerView.Adapter<Recyclerview2Adapter.ViewHolder> {
        ArrayList<HashMap<String, Object>> _data;
        public Recyclerview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
            _data = _arr;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater _inflater = getLayoutInflater();
            View _v = _inflater.inflate(R.layout.products, null);
            RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            _v.setLayoutParams(_lp);
            return new ViewHolder(_v);
        }
        @Override
        public void onBindViewHolder(ViewHolder _holder, final int _position) {
            View _view = _holder.itemView;
            final TextView textview1 = _view.findViewById(R.id.name);
            textview1.setText(_data.get((int)_position).get("name").toString());
            ImageView imageView = _view.findViewById(R.id.image);
            imageView.setImageResource(R.drawable.shop);
            try {


                Glide.with(getApplicationContext()).load(_data.get((int) _position).get("image").toString()).into(imageView);
            }catch (Exception e){
                e.printStackTrace();
            }

            RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            _view.setLayoutParams(_lp);
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
