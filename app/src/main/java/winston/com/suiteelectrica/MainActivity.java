package winston.com.suiteelectrica;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    NavigationView navView;
    private CardView c, c1;
    private LinearLayout r;

    private RadioButton r1, r2, r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView = (NavigationView) findViewById(R.id.nav_view);


        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        switch (menuItem.getItemId()) {
                            case R.id.inicio:
                                Intent ini = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(ini);
                                finish();

                                break;

                            case R.id.sugerencias:
                                Intent ayu = new Intent(MainActivity.this, Sugerencia.class);
                                startActivity(ayu);
                                finish();
                                break;
                            case R.id.colabore:
                                Intent inf = new Intent(MainActivity.this, ColaboreConNosotros.class);
                                startActivity(inf);
                                finish();
                                break;
                            case R.id.acercade:
                                Intent acer = new Intent(MainActivity.this, SobreNosotros.class);
                                startActivity(acer);
                                finish();
                                break;

                            case R.id.deltaestrella:
                                Intent del = new Intent(MainActivity.this, DeltaEstrella.class);
                                startActivity(del);
                                finish();
                                break;
                            case R.id.leydeohm:
                                Intent ley = new Intent(MainActivity.this, LeydeOhm.class);
                                startActivity(ley);
                                finish();
                                break;
                            case R.id.calpotencia:
                                Intent pot = new Intent(MainActivity.this, Potencia.class);
                                startActivity(pot);
                                finish();
                                break;
                            case R.id.informacion:
                                Intent infor = new Intent(MainActivity.this, informacion.class);
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

        c = (CardView) findViewById(R.id.cardfun);

        c.setRadius(20);
        c.setCardElevation(15);
        c.setCardBackgroundColor(Color.WHITE);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Escoja una funcion para seguir", Toast.LENGTH_SHORT).show();
            }
        });

        c1 = (CardView) findViewById(R.id.card1);
        c1.setRadius(20);
        c1.setCardElevation(15);
        c1.setCardBackgroundColor(Color.WHITE);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Escoja una funcion para seguir", Toast.LENGTH_SHORT).show();
            }
        });

        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r = (LinearLayout) findViewById(R.id.rl1);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, actividadPrincipal.class);
                startActivity(a);
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MainActivity.this, LeydeOhm.class);
                startActivity(b);
            }
        });

        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(MainActivity.this, Potencia.class);
                startActivity(c);
            }
        });

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Escoja una funcion para seguir", Toast.LENGTH_SHORT).show();
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
            ab.setIcon(R.mipmap.ic_launcher);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ayudar:
                Intent ayu = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(ayu);
                //finish();


        }
        return true;
    }

}
