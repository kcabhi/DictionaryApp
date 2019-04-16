package com.example.dictionaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String country[] = {
            "Nepal", "Kathmandu",
            "America", "Washington DC",
            "UK", "London",
            "Bhutan", "Thimpu"
    };
    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView coun = findViewById(R.id.coun);


        dictionary = new HashMap<>();
        for (int i = 0; i < country.length; i += 2) {
            dictionary.put(country[i], country[i + 1]);
        }
        ArrayAdapter countryAdpater = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );

        coun.setAdapter(countryAdpater);
        coun.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String count = parent.getItemAtPosition(position).toString();
                String capital = dictionary.get(count);


                Intent intent = new Intent(MainActivity.this,CapitalActivity.class);
                intent.putExtra("meaning",capital);
                startActivity(intent);

            }
        });
    }
}
