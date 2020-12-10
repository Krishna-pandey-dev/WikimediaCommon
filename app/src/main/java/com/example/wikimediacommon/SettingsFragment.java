package com.example.wikimediacommon;

import android.os.Bundle;

import androidx.preference.PreferenceFragment;

import java.util.prefs.PreferenceChangeEvent;

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        addPreferencesFromResource(R.xml.preferences);


    }
}
