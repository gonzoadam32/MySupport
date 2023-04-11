package com.example.mysupport;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

import androidx.annotation.Nullable;
import androidx.preference.ListPreference;

public class SettingsFragment extends PreferenceFragment{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // below line is used to add preference
        // fragment from our xml folder.
        addPreferencesFromResource(R.xml.preferences);


        PreferenceScreen p = getPreferenceScreen();

        ListPreference listPreference;

        Preference t =  p.getPreference(0);
        if(t instanceof android.preference.ListPreference) {
           // listPreference = (ListPreference) t;
        }

        //listPreference = (ListPreference) findPreference("@string/key_notifications");
    }
}

