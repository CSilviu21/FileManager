package itts.volta.quintocinf.letturascritturafile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String scriviFile(String nomeFile, Context c){
        String esito = "";
        FileOutputStream fileO;
        try {
            String str = "Questo è il testo da scrivere";
            fileO = c.openFileOutput(nomeFile, Context.MODE_PRIVATE);
            fileO.write(str.getBytes());
            fileO.close();
            esito = "File scritto correttamente";
        } catch (FileNotFoundException e) {
            esito = "Impossibili creare il file";
            e.printStackTrace();
        } catch (IOException e) {
            esito = "Errore di scrittura";
            e.printStackTrace();
        }
        return "";


    }
}