package com.herprogramacion.intercapappBeta.Email;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.herprogramacion.mysocialmediapotenciado.R;

public class EnvioCorreo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button = (Button) findViewById(R.id.btn_enviar_form);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                EditText user = (EditText) findViewById(R.id.campoUsuario);
                EditText pass = (EditText) findViewById(R.id.campoPass);
                EditText to = (EditText) findViewById(R.id.campoTo);
                EditText subject = (EditText) findViewById(R.id.campoAsunto);
                EditText body = (EditText) findViewById(R.id.campoMensaje);

                EmailSender emailSender = new EmailSender();

                emailSender.execute(user.getText().toString(), pass.getText().toString(), to.getText().toString(), subject.getText().toString(),
                        body.getText().toString(), "/sdcard/DCIM/Camera/test.jpg");

                //EmailSender emailSender2=new EmailSender();

                //emailSender.execute(emailSenderData.getAddress(), emailSenderData.getPassword(), arrayRecipients, "Novedad - " + format.format(newDate), emailBody, _fullThumbFileName);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}