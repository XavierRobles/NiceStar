package com.Xavi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Carga la pantalla principal de la aplicacion iniciada con un boton que te lleva a otro main
 * @author Xavier Robles
 * @see MainActivity2
 */
public class MainActivity extends AppCompatActivity {
    Button botonMain2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonMain2 = findViewById(R.id.bnt_Main2);
        botonMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }
}