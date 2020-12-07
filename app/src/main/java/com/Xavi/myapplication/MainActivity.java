package com.Xavi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Carga la pantalla principal de la aplicacion iniciada con un boton que te lleva a otro main
 *
 * @author Xavier Robles
 * @see MainActivity2
 */
public class MainActivity extends AppCompatActivity {
    private Button botonMain2;
    private ImageView fotoGlide2;
    private ImageView fotoEstrellas;

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

        fotoEstrellas =findViewById(R.id.img_fotorecortada);
        Animation myanim1 = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        fotoEstrellas.startAnimation(myanim1);

        fotoGlide2 = findViewById(R.id.imgview_alien);

        Glide.with(this)
                .load(R.drawable.alien)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                //.placeholder(new ColorDrawable(this.getResources()
               // .getColor(R.color.design_default_color_background)))
                .circleCrop()
                //.getDiskCacheStrategy(DiskCacheStrategy.NONE)
                .into(fotoGlide2);
    }
}