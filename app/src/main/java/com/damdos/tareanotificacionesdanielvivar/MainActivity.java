package com.damdos.tareanotificacionesdanielvivar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
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
    private NotificationManager notificador;
    private static final String CHANNEL_ID = "23";
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

                notificador = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setContentTitle("Notificación de acceso")
                        .setContentText("Si desea acceder al apartado del Toas pulse aqui. ")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setTicker("AVISO DE NOTIFICACION");

                createNotificationChannel();
                Intent intent = new Intent(MainActivity.this, ActivityDos.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
                stackBuilder.addParentStack(MainActivity.class);
                stackBuilder.addNextIntent(intent);

                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_MUTABLE);
                builder.setContentIntent(resultPendingIntent);

                builder.setAutoCancel(true);
                notificador.notify(1, builder.build());


                //builder.setFullScreenIntent(resultPendingIntent, true);
            }

        });

    }
    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}