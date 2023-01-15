package com.damdos.tareanotificacionesdanielvivar;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class OpcionesPreferencias extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);

    }
}
