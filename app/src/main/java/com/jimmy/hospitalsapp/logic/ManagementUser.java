package com.jimmy.hospitalsapp.logic;

import android.content.Context;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Clase encargada de manejar el elogin de la entrada de los usuarios
 * Created by Jimmy and Sergio  on 06/12/2016.
 */

public class ManagementUser implements Serializable{

    private static final long serialVersionUID = 123L;
    private Context context;
    private Properties properties;


    public ManagementUser(Context context) {
        this.context = context;
        this.properties = new Properties();
        loadUsers();
    }

    /**
     *Metodo para cargar los usuarios
     */
    public void loadUsers() {
        try {
            properties.load(context.getResources().getAssets().open("users.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *Metodo qeu valida los usuarios
     * @param userName Nombre del Usuario, atributo de tipo String
     * @param password clave de usuarion , atributo de tipo String
     * @return tipo boolean
     */

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
