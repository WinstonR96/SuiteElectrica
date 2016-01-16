package winston.com.suiteelectrica;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class actividadPrincipal extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    NavigationView navView;
    private CardView c, c1;
    private RadioButton r1, r2, r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        c = (CardView) findViewById(R.id.card2);

        c.setRadius(20);
        c.setCardElevation(15);
        c.setCardBackgroundColor(Color.WHITE);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(actividadPrincipal.this, "Seleccione una Configuracion", Toast.LENGTH_SHORT).show();
            }
        });

        c1 = (CardView) findViewById(R.id.card1);
        c1.setRadius(20);
        c1.setCardElevation(15);
        c1.setCardBackgroundColor(Color.WHITE);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(actividadPrincipal.this, "Seleccione una Configuracion", Toast.LENGTH_SHORT).show();
            }
        });


        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);


        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevaventana = new Intent(actividadPrincipal.this, DeltaEstrella.class);
                startActivity(nuevaventana);
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newwindows = new Intent(actividadPrincipal.this, EstrellaDelta.class);
                startActivity(newwindows);
            }
        });




        navView = (NavigationView)findViewById(R.id.nav_view);


        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        switch (menuItem.getItemId()) {
                            case R.id.inicio:
                                Intent ini = new Intent(actividadPrincipal.this, MainActivity.class);
                                startActivity(ini);
                                finish();

                                break;

                            case R.id.sugerencias:
                                Intent ayu = new Intent(actividadPrincipal.this, Sugerencia.class);
                                startActivity(ayu);
                                finish();
                                break;
                            case R.id.colabore:
                                Intent inf = new Intent(actividadPrincipal.this, ColaboreConNosotros.class);
                                startActivity(inf);
                                finish();
                                break;
                            case R.id.acercade:
                                Intent acer = new Intent(actividadPrincipal.this, SobreNosotros.class);
                                startActivity(acer);
                                finish();
                                break;
                            case R.id.deltaestrella:
                                Intent del = new Intent(actividadPrincipal.this, DeltaEstrella.class);
                                startActivity(del);
                                finish();
                                break;
                            case R.id.leydeohm:
                                Intent ley = new Intent(actividadPrincipal.this, LeydeOhm.class);
                                startActivity(ley);
                                finish();
                                break;
                            case R.id.calpotencia:
                                Intent pot = new Intent(actividadPrincipal.this, Potencia.class);
                                startActivity(pot);
                                finish();
                                break;
                            case R.id.informacion:
                                Intent infor = new Intent(actividadPrincipal.this, informacion.class);
                                startActivity(infor);
                                finish();
                                break;


                            case R.id.cerrar:
                                finish();
                                break;
                        }


                        menuItem.setChecked(true);


                        drawerLayout.closeDrawers();

                        return true;
                    }
                });
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.mipmap.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }


    }
