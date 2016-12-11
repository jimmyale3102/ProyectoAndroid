package com.jimmy.hospitalsapp.logic;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by Jimmy on 09/12/2016.
 */

public class ManagementUser {

    private Context context;
    private Properties properties;

    public ManagementUser(Context context) {
        this.context = context;
        this.properties = new Properties();
        loadUsers();
    }

    public void loadUsers() {
        try {
            properties.load(context.getResources().getAssets().open("users.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean validateUser(String userName, String password) {
        if (properties == null) return false;
        Enumeration<Object> keys = properties.keys();
        if (keys == null) return false;
        while (keys.hasMoreElements()) {
            String key = keys.nextElement().toString();
            if (key.equals(userName)) {
                return properties.getProperty(key).equals(password);
            }
        }
        return false;
    }

}
