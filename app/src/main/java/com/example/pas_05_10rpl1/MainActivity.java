package com.example.pas_05_10rpl1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[] , s2[];
    Integer images[] = {R.drawable.i, R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        s1 = getResources().getStringArray(R.array.nameprof);
        s2 = getResources().getStringArray(R.array.numberhp);

        Adapter adapter = new Adapter(this, s1 ,s2, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}