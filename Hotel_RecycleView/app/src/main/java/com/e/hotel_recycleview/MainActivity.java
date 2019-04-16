package com.e.hotel_recycleview;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements RvClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rv= findViewById(R.id.bis);


        RecyclerView.LayoutManager manager=new GridLayoutManager(this,3);

        rv.setLayoutManager(manager);

        MyAdapter adapter=new MyAdapter(this, al);
        rv.setAdapter(adapter);

        Work();
    }



    ArrayList<ItemS> al = new ArrayList<>();

    ItemS a = new ItemS(1,  "Nikesh", "1100");
    ItemS b = new ItemS(2, "There", "1300");
    ItemS c = new ItemS(3,  "Bishwash", "1100");
    ItemS d = new ItemS(4,  "Aniket", "1100");
    ItemS e = new ItemS(5,  "Anup", "1100");
    ItemS f = new ItemS(6,  "Solveen", "1100");

    public void Work() {
        al.add(a);
        al.add(b);
        al.add(c);
        al.add(d);
        al.add(e);
        al.add(f);


    }

    @Override
    public void onClick(ItemS user) {
        Toast.makeText(this,String.valueOf(user.getName() + " " +  user.getPrice() +  " " + user.getId()), Toast.LENGTH_LONG).show();

    }
}
