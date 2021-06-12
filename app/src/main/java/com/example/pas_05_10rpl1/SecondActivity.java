package com.example.pas_05_10rpl1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView name , number;

    String data1 , data2;
    Integer myimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.MainImageView);
        name = findViewById(R.id.name);
        number = findViewById(R.id.number);

        getData();
        setData();
    }

    private void getData() {
        if(getIntent().hasExtra("myimage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")) {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myimage = getIntent().getIntExtra("myimage", 1);

        }else {
            Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData() {
        name.setText(data1);
        number.setText(data2);
        mainImageView.setImageResource(myimage);
    }
}
