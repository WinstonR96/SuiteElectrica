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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeltaEstrella extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    NavigationView navView;
    public CardView c, c2;
    public Button aceptar, borrar;
    public TextView res;
    public EditText r1, r2, r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delta_estrella);
        navView = (NavigationView)findViewById(R.id.nav_view);


        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        switch (menuItem.getItemId()) {
                            case R.id.inicio:
                                Intent ini = new Intent(DeltaEstrella.this, MainActivity.class);
                                startActivity(ini);
                                finish();

                                break;

                            case R.id.sugerencias:
                                Intent ayu = new Intent(DeltaEstrella.this, Sugerencia.class);
                                startActivity(ayu);
                                finish();
                                break;
                            case R.id.colabore:
                                Intent inf = new Intent(DeltaEstrella.this, ColaboreConNosotros.class);
                                startActivity(inf);
                                finish();
                                break;
                            case R.id.acercade:
                                Intent acer = new Intent(DeltaEstrella.this, SobreNosotros.class);
                                startActivity(acer);
                                finish();
                                break;
                            case R.id.deltaestrella:
                                Intent del = new Intent(DeltaEstrella.this, DeltaEstrella.class);
                                startActivity(del);
                                finish();
                                break;
                            case R.id.leydeohm:
                                Intent ley = new Intent(DeltaEstrella.this, LeydeOhm.class);
                                startActivity(ley);
                                finish();
                                break;
                            case R.id.calpotencia:
                                Intent pot = new Intent(DeltaEstrella.this, Potencia.class);
                                startActivity(pot);
                                finish();
                                break;
                            case R.id.informacion:
                                Intent infor = new Intent(DeltaEstrella.this, informacion.class);
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

        c = (CardView)findViewById(R.id.card2);
        c2 = (CardView)findViewById(R.id.card3);

        c.setRadius(20);
        c.setCardElevation(15);
        c.setCardBackgroundColor(Color.WHITE);
        c2 = (CardView)findViewById(R.id.card3);
        c2.setRadius(20);
        c2.setCardElevation(15);
        c2.setCardBackgroundColor(Color.WHITE);

        r1 = (EditText)findViewById(R.id.R1);
        r2 = (EditText)findViewById(R.id.R2);
        r3 = (EditText)findViewById(R.id.R3);


        aceptar = (Button) findViewById(R.id.btn1);
        borrar = (Button) findViewById(R.id.btn2);

        res = (TextView)findViewById(R.id.Resultado);


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r1.getText().length()==0 || r2.getText().length()==0 || r3.getText().length()==0){
                    Toast.makeText(DeltaEstrella.this, "Rellene los campos vacios", Toast.LENGTH_SHORT).show();


                }else {
                    String val1 = r1.getText().toString();
                    String val2 = r2.getText().toString();
                    String val3 = r3.getText().toString();
                    Double resistenciaa = Double.parseDouble(val1);
                    Double resistenciab = Double.parseDouble(val2);
                    Double resistenciac = Double.parseDouble(val3);
                    double estrella1 = (resistenciaa * resistenciab) / (resistenciaa + resistenciab + resistenciac);
                    String res1 = String.valueOf(estrella1);
                    double estrella2 = (resistenciaa * resistenciac) / (resistenciaa + resistenciab + resistenciac);
                    String res2 = String.valueOf(estrella2);
                    double estrella3 = (resistenciab * resistenciac) / (resistenciaa + resistenciab + resistenciac);
                    String res3 = String.valueOf(estrella3);
                    res.setText("R1 = " + res1 + " Ω" + "\n" + "R2 = " + res2 + " Ω" + "\n" + "R3= " + res3 + " Ω");
                    InputMethodManager imm = (InputMethodManager) getSystemService(
                            INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                }
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setText("");
                r2.setText("");
                r3.setText("");
                res.setText("");
                r1.requestFocus();
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
