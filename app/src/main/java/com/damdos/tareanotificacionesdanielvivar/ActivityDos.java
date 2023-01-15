package com.damdos.tareanotificacionesdanielvivar;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityDos extends AppCompatActivity {
    Button mostrarToast;
    EditText editText;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);
        editText = findViewById(R.id.textView2);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                if(i == 1)
                {
                    Toast.makeText(ActivityDos.this,"ARRIBA", Toast.LENGTH_LONG).show();
                    Log.i("", "==> Posición del Toast: ARRIBA");
                }
                if(i == 2)
                {
                    Toast.makeText(ActivityDos.this,"CENTRO", Toast.LENGTH_LONG).show();
                    Log.i("", "==> Posición del Toast: CENTRO");
                }
                if(i == 3)
                {
                    Toast.makeText(ActivityDos.this,"ABAJO", Toast.LENGTH_LONG).show();
                    Log.i("", "==> Posición del Toast: ABAJO");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mostrarToast = findViewById(R.id.mostrarToast);
        mostrarToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityDos.this, editText.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}