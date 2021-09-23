package com.example.ussid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mojodiBtn,sharjBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial();
        CheckAndSendRequstPermission();

        mojodiBtn.setOnClickListener(new View.OnClickListener() {
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

        sharjBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String usCode = "*"+"7"+"*"+"1"+"*"+"1"+ Uri.encode("#");
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + usCode)));
                }catch (Exception e){
                    Log.d("aaa", e.getMessage());
                }

            }
        });

    }
    public void initial(){
        mojodiBtn = findViewById(R.id.mojodi);
        sharjBtn = findViewById(R.id.sharj);
    }
    public void CheckAndSendRequstPermission(){
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE}, 1);
        }
//        else {
//            Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
//        }

    }



}