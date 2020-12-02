package com.Xavi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Carga la pantalla inicial de la aplicacion donde da las opciones de iniciar la aplicacio o registrarse
 * @author Xavier Robles
 * @see RegistroActivity
 */
public class LoginActivity extends AppCompatActivity {
    private TextView registrate;
    private  Button login;
    private ImageView fotoGlide;
    private ImageView fotoEstrellas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fotoEstrellas =findViewById(R.id.img_fotorecortada);

        Animation myanim9 = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        fotoEstrellas.startAnimation(myanim9);

    registrate = findViewById(R.id.tv_registrate);
    registrate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
            startActivity(intent);

        }
    });

    login = findViewById(R.id.btn_login);
    login.setOnClickListener(new View.OnClickListener() {
        @Override
       public void onClick(View v) {

           Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
           startActivity(intent);

        }
    });

    }
    }




