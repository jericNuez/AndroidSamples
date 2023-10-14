package com.example.androidplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
//    String[] heroes = {"Superman", "Iron Man", "Batman", "Spider Man", "Flash"};
    List<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        contacts = new ArrayList<>();
        contacts.add(new Contact(R.drawable.baseline_phone_24, "Superman", "Hello Batman"));
        contacts.add(new Contact(R.drawable.baseline_phone_24, "Iron Man", "Hello Batman"));
        contacts.add(new Contact(R.drawable.baseline_phone_24, "Spider Man", "Hello Batman"));
        contacts.add(new Contact(R.drawable.baseline_phone_24, "Flash", "Hello Batman"));

        CustomAdapter myCustomAdapter = new CustomAdapter(this, contacts);
        listView.setAdapter(myCustomAdapter);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,heroes);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "You selected: " + heroes[i], Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}