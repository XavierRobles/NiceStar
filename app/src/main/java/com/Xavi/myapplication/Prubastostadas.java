package com.Xavi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Prubastostadas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prubastostadas);
        Button boton_tostada;
        boton_tostada = findViewById(R.id.btn_Tostada);

        boton_tostada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Prubastostadas.this, "TOTADAAAAAAAAAAAAAA!!!!!.", Toast.LENGTH_SHORT).show();

            }
        });



    }
}