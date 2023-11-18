package com.example.androidplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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

public class MainActivity extends AppCompatActivity {
    EditText firstName, lastName, remarks;
    Button insertBtn, displayBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstname);
        lastName = findViewById(R.id.lastname);
        remarks = findViewById(R.id.remarks);
        insertBtn = findViewById(R.id.insert_btn);
        displayBtn = findViewById(R.id.display_btn);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_name = firstName.getText().toString();
                String last_name = lastName.getText().toString();
                String _remarks = remarks.getText().toString();
                Boolean isInserted = databaseHelper.insertData(first_name,last_name,_remarks);
                if(isInserted) {
                    Toast.makeText(MainActivity.this, "Student record inserted successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Failed to insert record", Toast.LENGTH_SHORT).show();
                }
            }
        });

        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = databaseHelper.getAllData();

                if(result != null && result.getCount() > 0) {
                    while(result.moveToNext()) {
                        StringBuffer stringBuffer = new StringBuffer();
//                        result.getString(0); // id
//                        result.getString(1); // firstname
//                        result.getString(2); // lastname
//                        result.getString(3); // remarks
                        stringBuffer.append("ID: " + result.getString(0)+"\n");
                        stringBuffer.append("First Name: " + result.getString(1)+"\n");
                        stringBuffer.append("Last Name: " + result.getString(2)+"\n");
                        stringBuffer.append("Remarks: " + result.getString(3)+"\n");
                        Toast.makeText(MainActivity.this, stringBuffer.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "No record to display", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}