package com.Xavi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Genera un fondo animado durante unos segundos y carga la pantalla de login
 * @author Xavier Robles
 * @see LoginActivity
 */
public class SplashSreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sreen);

        openApp(true);
        ImageView fotoFeto = findViewById(R.id.feto_png);
        ImageView nubes = findViewById(R.id.img_nubes);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.traslatenubes);

        fotoFeto.startAnimation(myanim);
        nubes.startAnimation(myanim2);
        openApp(true);


        Glide.with(this)
                .load("https://media0.giphy.com/media/ZcVQhycvngidG46dMO/giphy.gif")
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                //.placeholder(new ColorDrawable(this.getResources()
                       // .getColor(R.color.design_default_color_background)))
                .circleCrop()
                //.getDiskCacheStrategy(DiskCacheStrategy.NONE)
                .into(fotoFeto);


        ImageView fotolucha = findViewById(R.id.img_lucha);
        Glide.with(this)
                .load("https://i.pinimg.com/originals/55/29/69/5529695a29cde671e1795ea289d09930.gif")
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                //.placeholder(new ColorDrawable(this.getResources()
                // .getColor(R.color.design_default_color_background)))
                .circleCrop()
                //.getDiskCacheStrategy(DiskCacheStrategy.NONE)
                .into(fotolucha);


    }




    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashSreen
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 7000);
    }
}