package com.Xavi.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.bottomappbar.BottomAppBar;

/**
 * Carga la pantalla de main2 de la aplicacion que lo unico que tiene es la action bar para poder salir
 * @author Xavier Robles
 * @see MainActivity
 */
public class MainActivity2 extends AppCompatActivity {
    ImageView fotochica;
    private ImageView fotoEstrellas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //fotoEstrellas =findViewById(R.id.img_fotorecortada);
        //Animation myanim1 = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        //fotoEstrellas.startAnimation(myanim1);

        fotochica = findViewById(R.id.imageViewChica);

//        Glide.with(this)
//                .load(R.drawable.girl)
//                .centerCrop()
//                .transition(DrawableTransitionOptions.withCrossFade(500))
//                //.placeholder(new ColorDrawable(this.getResources()
//                // .getColor(R.color.design_default_color_background)))
//                .circleCrop()
//                //.getDiskCacheStrategy(DiskCacheStrategy.NONE)
//                .into(fotochica);
        // cast al xml
        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);

        //click event en el  FAB
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "FAB Clicked.", Toast.LENGTH_SHORT).show();


            }
        });
        //click event en el Hamburguer menu
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Menu clicked!", Toast.LENGTH_SHORT).show();
//                sheetBehavior = BottomSheetBehavior.from(sheet);
            }


        });
        //click event en el Bottom bar menu item
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_app_bar_menu_share:
                        Toast.makeText(MainActivity2.this, "More clicked.", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.bottom_app_bar_menu_search:
                        Toast.makeText(MainActivity2.this, "Search clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_bookmark:
                        Toast.makeText(MainActivity2.this, "bookmark clicked.", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

    }

}