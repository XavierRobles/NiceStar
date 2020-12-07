package com.Xavi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Carga la pantalla de peticion de dadtos para llevar a cabo el registro y poder acceder a la aplicacion desde la pantalla login
 * @author Xavier Robles
 * @see LoginActivity
 */
public class RegistroActivity extends AppCompatActivity {
    private Button cancelarregistro;
    private ImageView fotoEstrellas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        fotoEstrellas =findViewById(R.id.img_fotorecortada);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        fotoEstrellas.startAnimation(myanim2);


        cancelarregistro=findViewById(R.id.btn_cancel);
        cancelarregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }


    //    login.findViewById(R.id.btn_login);
//    login.setOnClickListener(new View.OnClickListener() {
//        @Override
//       public void onClick(View v) {
//           Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//           startActivity(intent);
//        }
//    });
}