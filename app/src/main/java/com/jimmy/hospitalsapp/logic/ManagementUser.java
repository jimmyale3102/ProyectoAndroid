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
    private ArrayList<User> users;

    public ManagementUser(Context context) {
this.context = context;
    }

    public void loadUsers() {
        Properties properties = new Properties();
        try {
            properties.load(context.getResources().getAssets().open("users.properties"));
        }catch (IOException e){
            e.getStackTrace();
        }
        Enumeration<Object> keys = properties.keys();
        while(keys.hasMoreElements()) {
            String user = (String) keys.nextElement();
            String pass = (String) properties.getProperty(user);
            if (findUser(user) != null) {
                users.add(new User(user, pass));
            } else {
                //JOptionPane.showMessageDialog(null, "El usuario ya existe");
            }
        }
    }

    public User findUser(String userName) {
        ArrayList<User> userAux = (ArrayList<User>) users.clone();
        userAux = sortPassword();
        short middle = 0;
        short begin = 0;
        short finish = (short) (userAux.size() - 1);
        while (begin <= finish) {
            middle = (short) ((begin + finish) / 2);
            if (userAux.get(middle).getUserName().equals(userName)) {
                return userAux.get(middle);
            } else if (userAux.get(middle).getUserName().compareTo(userName) > 0) {
                finish = (short) (middle - 1);
            } else {
                begin = (short) (middle + 1);
            }
        }
        return null;
    }

    public ArrayList<User> sortPassword() {
        User userObject = new User();
        ArrayList<User> userAux = (ArrayList<User>) users.clone();
        for (int aux = userAux.size(); aux > 0; aux--) {
            for (int i = 0; i < aux - 1; i++) {
                if (userAux.get(i).getUserName().compareTo(userAux.get(i + 1).getUserName()) > 0) {
                    userObject = userAux.get(i);
                    userAux.set(i, userAux.get(i + 1));
                    userAux.set(i + 1, userObject);
                }
            }
        }
        return userAux;
    }

    public boolean validateUserName(String userName) {
        return false;
    }

    public boolean validatePassword(String password) {
        return false;
    }

}
