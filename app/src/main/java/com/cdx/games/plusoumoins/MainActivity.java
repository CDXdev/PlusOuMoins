package com.cdx.games.plusoumoins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText monInput = null;
    Button monButton = null;
    TextView container = null;
    int nb_mystere = new Random().nextInt(1000), nb_input = 0, nb_essais = 0 ;
    String comparaison ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monButton = (Button)findViewById(R.id.button);
        monInput = (EditText)findViewById(R.id.editText);
        container = (TextView)findViewById(R.id.container);
        container.setMovementMethod(new ScrollingMovementMethod());
        monButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String tmp = container.getText().toString();
                if(monInput.getText().length()>0){
                    nb_input = Integer.parseInt(monInput.getText().toString());
                } else {
                    nb_input=-1;
                }
                if((nb_input<nb_mystere) && (nb_input>=0)){
                    comparaison="trop petit";
                    nb_essais++;
                } else if((nb_input>nb_mystere) && (nb_input<1000)){
                    comparaison="trop grand";
                    nb_essais++;
                } else if(nb_input==nb_mystere){
                    comparaison="Gagné ! seulement "+nb_essais+" essais!";
                } else {
                    comparaison="Entrée incorrecte : entrez un nombre entre 0 et 999";
                }
                container.setText(nb_input+"\n"+comparaison+"\n"+tmp);
                monInput.getText().clear(); // make the editText empty
            }
        });
    }
}
