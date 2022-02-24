package itts.volta.quintocinf.letturascritturafile;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Gestore {
    public String leggiFile(String nomefile, Context c){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader fileDaLeggere = new BufferedReader();
        }
        return sb.toString();
    }
    public String scriviFile(String nomefile, Context c){
        String esito = "";
        FileOutputStream fileO;
        String contenuto = "Questo è quello che "  + "scriverò nel file";
        try {
            fileO = c.openFileOutput(nomefile, Context.MODE_PRIVATE);
            fileO.write(contenuto.getBytes());
            fileO.close();
            esito = "File creato con successo";
        } catch (FileNotFoundException e) {
            esito = "Errore non posso creare il file";
        } catch (IOException e) {
            esito = "Errore non posso scrivere il file";
        }

        return esito;

    }
    public String leggiFileRes(Context c){
        String testo="";
        StringBuilder sb = new StringBuilder();


        Resources res = c.getResources()
        InputStream fileLetto=res.openRawResource(R.raw.brani);
        BufferedReader br= new BufferedReader(new InputStreamReader(fileLetto));
        try{
            while((testo=br.readLine())!= null){
                sb.append(testo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
return sb.toString();
    }
    public String leggiRawFile(Context c){
        String testo;
        StringBuilder sb = new StringBuilder();
        Resources res = c.getResources();
        InputStream is = res.openRawResource(R.raw.brani);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(is));
        try {
        while((testo=br.readLine())!=null) {
            sb.append(testo + "\n");
        }
    } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

}
public String leggiFileAsset(Context c){
    AssetManager am = c.getAssets();
    try {
        InputStream is= am.open("brani.txt");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return "";
}
}