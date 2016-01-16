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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ColaboreConNosotros extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    NavigationView navView;
    private CardView ca;
    private Button enviar;
    private TextView respuesta;
    private EditText nombre, apellido, telefono, correo;
    private Spinner opcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colabore_con_nosotros);

        navView = (NavigationView)findViewById(R.id.nav_view);


        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        switch (menuItem.getItemId()) {
                            case R.id.inicio:
                                Intent ini = new Intent(ColaboreConNosotros.this, MainActivity.class);
                                startActivity(ini);
                                finish();

                                break;

                            case R.id.sugerencias:
                                Intent ayu = new Intent(ColaboreConNosotros.this, Sugerencia.class);
                                startActivity(ayu);
                                finish();
                                break;
                            case R.id.colabore:
                                Intent inf = new Intent(ColaboreConNosotros.this, ColaboreConNosotros.class);
                                startActivity(inf);
                                finish();
                                break;
                            case R.id.acercade:
                                Intent acer = new Intent(ColaboreConNosotros.this, SobreNosotros.class);
                                startActivity(acer);
                                finish();
                                break;
                            case R.id.deltaestrella:
                                Intent del = new Intent(ColaboreConNosotros.this, DeltaEstrella.class);
                                startActivity(del);
                                finish();
                                break;
                            case R.id.leydeohm:
                                Intent ley = new Intent(ColaboreConNosotros.this, LeydeOhm.class);
                                startActivity(ley);
                                finish();
                                break;
                            case R.id.calpotencia:
                                Intent pot = new Intent(ColaboreConNosotros.this, Potencia.class);
                                startActivity(pot);
                                finish();
                                break;
                            case R.id.informacion:
                                Intent infor = new Intent(ColaboreConNosotros.this, informacion.class);
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

        ca = (CardView) findViewById(R.id.caview2);

        ca.setRadius(20);
        ca.setCardElevation(15);
        ca.setCardBackgroundColor(Color.WHITE);

        enviar = (Button) findViewById(R.id.btnEnviar);

        nombre = (EditText) findViewById(R.id.txtNombre);
        apellido = (EditText) findViewById(R.id.txtApellido);
        telefono = (EditText) findViewById(R.id.txtTelefono);
        correo = (EditText) findViewById(R.id.TxtCorreo);
        opcion = (Spinner) findViewById(R.id.spinner);

        String[] op = {"Android", "IOS", "Web", "Windows Phone"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, op);
        opcion.setAdapter(adapter);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.getText().length() == 0 || apellido.getText().length() == 0 || telefono.getText().length() == 0
                        || correo.getText().length() == 0) {
                    Toast.makeText(ColaboreConNosotros.this, "Rellene los campos vacios", Toast.LENGTH_SHORT).show();
                } else {
                    nombre.setText("");
                    apellido.setText("");
                    telefono.setText("");
                    correo.setText("");


                    Toast.makeText(ColaboreConNosotros.this, "Solicitud Enviada", Toast.LENGTH_SHORT).show();
                    nombre.requestFocus();
                    respuesta.setText("En breve los desarrolladores de la app se pondran en contacto");
                    InputMethodManager imm = (InputMethodManager) getSystemService(
                            INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"wijurost@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Trabaje con nosotros");
                i.putExtra(Intent.EXTRA_TEXT, "\nNombre: " + nombre.getText().toString() + "\nApellido: " + apellido.getText().toString() + "\nTelefono: " + telefono.getText().toString() + "\nCorreo: " + correo.getText().toString() + "\nProgramador: " + opcion.getSelectedItem().toString());
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ColaboreConNosotros.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                nombre.setText("");
                apellido.setText("");
                telefono.setText("");
                correo.setText("");
                nombre.requestFocus();

                Toast.makeText(ColaboreConNosotros.this, "Envie el correo para que los desarrolladores se pongan en contacto con usted", Toast.LENGTH_SHORT).show();
                InputMethodManager imm = (InputMethodManager) getSystemService(
                        INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
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

