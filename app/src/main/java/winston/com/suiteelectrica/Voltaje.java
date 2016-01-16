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
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Voltaje extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    NavigationView navView;
    public CardView c, c2;
    public Button aceptar, borrar;
    public TextView res;
    public EditText r1, r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voltaje);
        navView = (NavigationView)findViewById(R.id.nav_view);


        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        switch (menuItem.getItemId()) {
                            case R.id.inicio:
                                Intent ini = new Intent(Voltaje.this, MainActivity.class);
                                startActivity(ini);
                                finish();

                                break;

                            case R.id.sugerencias:
                                Intent ayu = new Intent(Voltaje.this, Sugerencia.class);
                                startActivity(ayu);
                                finish();
                                break;
                            case R.id.colabore:
                                Intent inf = new Intent(Voltaje.this, ColaboreConNosotros.class);
                                startActivity(inf);
                                finish();
                                break;
                            case R.id.acercade:
                                Intent acer = new Intent(Voltaje.this, SobreNosotros.class);
                                startActivity(acer);
                                finish();
                                break;
                            case R.id.deltaestrella:
                                Intent del = new Intent(Voltaje.this, DeltaEstrella.class);
                                startActivity(del);
                                finish();
                                break;
                            case R.id.leydeohm:
                                Intent ley = new Intent(Voltaje.this, LeydeOhm.class);
                                startActivity(ley);
                                finish();
                                break;
                            case R.id.calpotencia:
                                Intent pot = new Intent(Voltaje.this, Potencia.class);
                                startActivity(pot);
                                finish();
                                break;
                            case R.id.informacion:
                                Intent infor = new Intent(Voltaje.this, informacion.class);
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

        aceptar = (Button) findViewById(R.id.btn1);
        borrar = (Button) findViewById(R.id.btn2);

        res = (TextView)findViewById(R.id.Resultado);

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setText("");
                r2.setText("");
                res.setText("");
                r1.requestFocus();
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r1.getText().length()==0 || r2.getText().length()==0 ){
                    Toast.makeText(Voltaje.this, "Rellene los campos vacios", Toast.LENGTH_SHORT).show();


                }else {
                    String val1 = r1.getText().toString();
                    String val2 = r2.getText().toString();
                    Double corriente = Double.parseDouble(val1);
                    Double resistencia = Double.parseDouble(val2);
                    double vol = (corriente*resistencia);
                    String resu = String.valueOf(vol);
                    res.setText("el voltaje es: "+resu+" v");
                    InputMethodManager imm = (InputMethodManager) getSystemService(
                            INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                }
            }
        });

        aceptar.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER){

                    if (r1.getText().length()==0 || r2.getText().length()==0 ){
                        Toast.makeText(Voltaje.this, "Rellene los campos vacios", Toast.LENGTH_SHORT).show();


                    }else {
                        String val1 = r1.getText().toString();
                        String val2 = r2.getText().toString();
                        Double corriente = Double.parseDouble(val1);
                        Double resistencia = Double.parseDouble(val2);
                        double vol = (corriente*resistencia);
                        String resu = String.valueOf(vol);
                        res.setText("el voltaje es: "+resu+" v");
                        InputMethodManager imm = (InputMethodManager) getSystemService(
                                INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                    }
                    return true;
                }
                return false;
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