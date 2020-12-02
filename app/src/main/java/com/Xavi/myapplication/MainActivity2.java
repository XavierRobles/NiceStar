package com.Xavi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Carga la pantalla de main2 de la aplicacion que lo unico que tiene es la action bar para poder salir
 * @author Xavier Robles
 * @see MainActivity
 */
public class MainActivity2 extends AppCompatActivity {
    ImageView fotochica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        fotochica = findViewById(R.id.imageViewChica);

        Glide.with(this)
                .load(R.drawable.girl)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                //.placeholder(new ColorDrawable(this.getResources()
                // .getColor(R.color.design_default_color_background)))
                .circleCrop()
                //.getDiskCacheStrategy(DiskCacheStrategy.NONE)
                .into(fotochica);


    }
}