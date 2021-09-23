package com.example.ussid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String usCode = "*"+"141"+"*"+"1"+ Uri.encode("#");
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + usCode)));
                }catch (Exception e){
                    Log.d("aaa", e.getMessage());
                }



            }
        });


    }
}