package com.smile.gilberto.fragmentexample;

import com.smile.gilberto.fragmentexample.FragmentListado.CorreosListener;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

public class MainActivity extends AppCompatActivity implements FragmentListado.CorreosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListado frgListado
                =(FragmentListado)getSupportFragmentManager()
                .findFragmentById(R.id.FrgListado);

        frgListado.setCorreosListener(this);
    }

    @Override
    public void onCorreoSeleccionado(Correo c) {
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.FrgDetalle) != null);

        if(hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager()
                    .findFragmentById(R.id.FrgDetalle)).mostrarDetalle(c.getTexto());
        }
        else {
            Intent i = new Intent(this, FragmentDetalle.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, c.getTexto());
            startActivity(i);
        }
    }


}
