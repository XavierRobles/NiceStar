package com.Xavi.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

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
    private WebView web;
    ProgressBar progressBar;
    MainActivity m = this;

    //Ventanita
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mycontext = (ImageView) findViewById(R.id.imgview_alien);
        registerForContextMenu(mycontext);
        //ventanita
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        botonMain2 = findViewById(R.id.bnt_Main2);
        botonMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);


            }
        });


        fotoEstrellas = findViewById(R.id.img_fotorecortada);
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





        // *** EXPANDABLE CARD ***

        ExpandableCardView card = findViewById(R.id.profile);
        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show();

            }
        });
    }


    //    creamos una lista de eventos para los items del menus contextual

    /**
     *
     * @param item botones al pulsar el alien y su funciones
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.main:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                Toast toast = Toast.makeText(this, "Activity Main", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.Setting:
                Toast toast2 = Toast.makeText(this, "Activity de opciones en construcción", Toast.LENGTH_LONG);
                toast2.show();
                break;
            case R.id.close:
                Intent intent1 = new Intent(MainActivity.this, ConstraintSet.Motion.class);
                startActivity(intent1);
                Toast toast3 = Toast.makeText(this, "Cerrando app", Toast.LENGTH_LONG);
                toast3.show();
                break;
            case R.id.perfil:
                Toast toast4 = Toast.makeText(this, "Abriendo perfil", Toast.LENGTH_LONG);
                toast4.show();
                showAlertDialogButtonClicked(MainActivity.this);
                break;
            case R.id.buscar:
                Toast toast5 = Toast.makeText(this, "Accediendo a la LUPA", Toast.LENGTH_LONG);
                toast5.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    /**
     *
     * @param menu creacion del app bar manu, con el archivo menu_contex.xml
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contex, menu);
        return true;
    }

    /**
     *
     * @param item potones del Appbar menu y sus funciones
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.main:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                Toast toast = Toast.makeText(this, "Activity Main", Toast.LENGTH_LONG);
                toast.show();


                break;
            case R.id.Setting:
                Toast toast2 = Toast.makeText(this, "Activity de opciones en construcción", Toast.LENGTH_LONG);
                toast2.show();
                break;
            case R.id.close:
                Intent intent1 = new Intent(MainActivity.this, ConstraintSet.Motion.class);
                startActivity(intent1);
                Toast toast3 = Toast.makeText(this, "Cerrando app", Toast.LENGTH_LONG);
                toast3.show();

                break;
            case R.id.perfil:
                Toast toast4 = Toast.makeText(this, "Abriendo perfil", Toast.LENGTH_LONG);
                toast4.show();
                showAlertDialogButtonClicked(MainActivity.this);
                break;
            case R.id.buscar:
                Toast toast5 = Toast.makeText(this, "Accediendo a la LUPA", Toast.LENGTH_LONG);
                toast5.show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }
    // *** SWIPEREFRESH con SNACKBAR ***

    //    construimos el Swipe y aplicamos un Listener que lanza un SnackBar y desactiva a continuación del Swipe la animación

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //    opción TOAST
            //
//                      Toast toast0 = Toast.makeText(MainActivity.this, "going swipeREFRESH", Toast.LENGTH_LONG);
//                      toast0.show();
            //   opción SNACKBAR

//           SUSTITUIR POR CONSTRAINT EN SU CASO
            final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.activity_main_context);
            //           final RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.activity_main_context);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "Refrescando el activity", Snackbar.LENGTH_LONG)
                    .setAction("Hecho", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Activity listo", Snackbar.LENGTH_SHORT);
                            snackbar1.show();


                        }
                    });

            snackbar.show();

            swipeLayout.setRefreshing(true);

        }
    };


    // *** DIALOGO MODAL ***

    /**
     *
     * @param view Showaler muestra la tarjeta con la informacion del perfil
     */
    public void showAlertDialogButtonClicked(MainActivity view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Perfil");
        builder.setMessage("Links de contacto");
        builder.setIcon(R.drawable.yo);

        // un XML a medida para el diálogo
        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));
        web = findViewById(R.id.wv_web);
        // add the buttons
        builder.setPositiveButton("Github", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...


                Toast toast = Toast.makeText(m, "https://github.com/XavierRobles", Toast.LENGTH_LONG);
                toast.show();
                web.setVisibility(View.VISIBLE);
                web = findViewById(R.id.wv_web);
                web.setWebViewClient(new WebViewClient());
                String url ="https://github.com/XavierRobles";
                web.loadUrl(url);

                dialog.dismiss();

            }
        });

        builder.setNegativeButton("FaceBook", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                web.setVisibility(View.VISIBLE);
                web = findViewById(R.id.wv_web);
                web.setWebViewClient(new WebViewClient());
                String url ="https://www.facebook.com/Xavi.Robles.Robles";
                web.loadUrl(url);
                // do something like...
                Toast toast = Toast.makeText(m, "https://www.facebook.com/Xavi.Robles.Robles", Toast.LENGTH_LONG);
                toast.show();

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("LinkedIn", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                web.setVisibility(View.VISIBLE);
                web = findViewById(R.id.wv_web);
                web.setWebViewClient(new WebViewClient());
                String url ="https://www.linkedin.com/";
                web.loadUrl(url);
                Toast toast = Toast.makeText(m, "https://www.linkedin.com/in/xavier-robles-614987186", Toast.LENGTH_LONG);
                toast.show();
                // do something like...


                dialog.dismiss();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

        @Override
        public void onCreateContextMenu (ContextMenu menu, View v,
            ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contex, menu);

    }

    }