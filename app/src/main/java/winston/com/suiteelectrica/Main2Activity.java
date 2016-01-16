package winston.com.suiteelectrica;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

public class Main2Activity extends Activity {
    public float init_x;
    private ViewFlipper vf;
    private ImageButton atras, delante;
    private Button comenzar;
    private boolean estado;



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            cargarPreferencias();
            if (estado){
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }else {
                guardarPreferencias(true);
            }

        vf = (ViewFlipper)findViewById(R.id.vf);
        atras = (ImageButton)findViewById(R.id.btnatras1);
        delante = (ImageButton)findViewById(R.id.btndelante1);
            comenzar = (Button)findViewById(R.id.comenzar);

            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent comenzar = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(comenzar);
                    finish();
                }
            });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.showPrevious();
            }
        });

        delante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.showNext();
            }
        });

            vf.setOnTouchListener(new ListenerTouchViewFlipper());

    }

    private void cargarPreferencias(){
        SharedPreferences mispreferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        estado = mispreferencias.getBoolean("isLoad", false);


    }

    private void guardarPreferencias(boolean valor){

        SharedPreferences mispreferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
       SharedPreferences.Editor editor = mispreferencias.edit();
        editor.putBoolean("isLoad", valor);
        editor.commit();


    }

    private class ListenerTouchViewFlipper implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: //Cuando el usuario toca la pantalla por primera vez
                    init_x=event.getX();
                    return true;
                case MotionEvent.ACTION_UP: //Cuando el usuario deja de presionar
                    float distance =init_x-event.getX();

                    if(distance>0)
                    {
                        vf.setInAnimation(inFromRightAnimation());
                        vf.setOutAnimation(outToLeftAnimation());
                        vf.showPrevious();
                    }

                    if(distance<0)
                    {
                        vf.setInAnimation(inFromLeftAnimation());
                        vf.setOutAnimation(outToRightAnimation());
                        vf.showNext();
                    }

                default:
                    break;
            }

            return false;
        }

    }

    private Animation inFromRightAnimation() {

        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,  +1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f );

        inFromRight.setDuration(500);
        inFromRight.setInterpolator(new AccelerateInterpolator());

        return inFromRight;

    }

    private Animation outToLeftAnimation() {
        Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoLeft.setDuration(500);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;
    }

    private Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(500);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }

    private Animation outToRightAnimation() {
        Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoRight.setDuration(500);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }


}




