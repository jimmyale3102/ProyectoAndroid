package com.jimmy.hospitalsapp.serialization;

import android.content.Context;

import com.jimmy.hospitalsapp.logic.ManagementApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class SerializacionApp implements Serializable {

    private static final long serialVersionUID = 123L;

    private File file;
    private File folder;
    private String fileName;
    private String filePath;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public File getFile() {
        return file;
    }

    public SerializacionApp() {

    }

    public void openFile() {
        file = new File(filePath + fileName);
    }

    public void writeSerializable(ManagementApp managementApp) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
            stream.writeObject(managementApp);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ManagementApp readerSerializable() {
        ManagementApp proyect = null;
        ObjectInputStream stream = null;
        try {
            stream = new ObjectInputStream(new FileInputStream(file));
            proyect = (ManagementApp) stream.readObject();
            stream.close();

        } catch (IOException e) {
            // TODO Bloque catch generado autom�ticamente
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Bloque catch generado autom�ticamente
            e.printStackTrace();
        }
        return proyect;
    }

    public SerializacionApp(Context context, String fileName) {
        this.fileName = fileName;
        this.folder = new File(context.getFilesDir(), "data");
        open();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void open() {
        if (folder != null) folder.mkdirs();
        this.file = new File(folder, fileName);

    }
}
