package com.damdos.tareanotificacionesdanielvivar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnPreferencias;
    private Button btnRecuperar;
    private Button btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPreferencias = findViewById(R.id.definir);

        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OpcionesPreferencias.class);
                startActivity(intent);

            }
        });

        btnRecuperar = findViewById(R.id.recuperar);

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Mostrando datos en el LOG", Toast.LENGTH_LONG).show();
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                Log.i("", "==> Único sistema operativo: " +pref.getBoolean("clave1", false));
                Log.i("", "==> Sistema operativo: " +pref.getString("clave2", "No asignada"));
                Log.i("", "==> Versión del sistema: " +pref.getString("clave3", "No asignada"));


            }
        });
        btnToast = findViewById(R.id.boton3);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityDos.class);
                startActivity(intent);

            }
        });

    }
}