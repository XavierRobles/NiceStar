package com.Xavi.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
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
    private MainActivity2 m = this;
    ImageView fotochica;
    private ImageView fotoEstrellas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fotoEstrellas =findViewById(R.id.img_fotorecortada);
        Animation myanim1 = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        fotoEstrellas.startAnimation(myanim1);

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

    /**
     *
     * @param menu creacion del app bar manu, con el archivo menu_contex.xml
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contex2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.volver:
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                Toast toast = Toast.makeText(this, "Activity Main", Toast.LENGTH_LONG);
                toast.show();

                break;
            case R.id.Setting:
                Toast toast2 = Toast.makeText(this, "Activity de opciones en construcción", Toast.LENGTH_LONG);
                toast2.show();
                break;
            case R.id.close:
                Intent intent1 = new Intent(MainActivity2.this, ConstraintSet.Motion.class);
                startActivity(intent1);
                Toast toast3 = Toast.makeText(this, "Cerrando app", Toast.LENGTH_LONG);
                toast3.show();

                break;
            case R.id.perfil:
                Toast toast4 = Toast.makeText(this, "Abriendo perfil", Toast.LENGTH_LONG);
                toast4.show();
                showAlertDialogButtonClicked(MainActivity2.this);
                break;

            case R.id.buscar:
                Toast toast5 = Toast.makeText(this, "Accediendo a la LUPA", Toast.LENGTH_LONG);
                toast5.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     *
     * @param view Showaler muestra la tarjeta con la informacion del perfil
     */
    public void showAlertDialogButtonClicked(MainActivity2 view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Perfil");
        builder.setMessage("Links de contacto");
        builder.setIcon(R.drawable.yo);

        // un XML a medida para el diálogo
        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        // add the buttons
        builder.setPositiveButton("Github", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Toast toast = Toast.makeText(m, "https://github.com/XavierRobles", Toast.LENGTH_LONG);
                toast.show();
                dialog.dismiss();

            }
        });

        builder.setNegativeButton("FaceBook", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                Toast toast = Toast.makeText(m, "https://es-es.facebook.com/", Toast.LENGTH_LONG);
                toast.show();

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("LinkedIn", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(m, "https://www.linkedin.com/in/xavier-robles-614987186/", Toast.LENGTH_LONG);
                toast.show();
                // do something like...


                dialog.dismiss();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}