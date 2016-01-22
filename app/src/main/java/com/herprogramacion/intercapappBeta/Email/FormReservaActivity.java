package com.herprogramacion.intercapappBeta.Email;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.herprogramacion.mysocialmediapotenciado.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormReservaActivity extends Activity implements OnClickListener
{
    private Button botonEnviarForm;
    private TextView resVtaNro, resEmailCli, resCantidad, resNotaVe;
    private List<String> recipientEmailList;
    private String strRecipientEmail, strAsunto, strCantidad, strNotaVe, strNroVta,strTituloVta;
    private String strSenderEmail = "intercapsrlapp@gmail.com";
    private String strSenderPassword = "Sikalq5k#1";
    private TextView nroVta_res, tituloVta_res, descripPool_res;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_reserva);
        initializeWidgets();


        nroVta_res = (TextView)findViewById(R.id.textVtaNro);
        tituloVta_res = (TextView)findViewById(R.id.textVtaTitulo);


        //Recogiendo intent desde MainActivity

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {

            String datoNro = (String)extras.get("nroVta");
            String datoTitulo = (String)extras.get("tituloVta");


            nroVta_res.setText(datoNro);
            tituloVta_res.setText(datoTitulo);

        }

    }

    private void initializeWidgets()
    {
        botonEnviarForm = (Button) this.findViewById(R.id.btnReservar);
        resVtaNro = (TextView) this.findViewById(R.id.textVtaNro);
        resCantidad = (TextView) this.findViewById(R.id.editCantidad);
        resEmailCli = (TextView) this.findViewById(R.id.editEmailCli);
        resNotaVe = (TextView) this.findViewById(R.id.editNotaVe);
        recipientEmailList = new ArrayList<String>();
        botonEnviarForm.setOnClickListener(this);
    }

    private void getValues()
    {
        strRecipientEmail = resEmailCli.getText().toString();
        strCantidad = resCantidad.getText().toString();
        recipientEmailList = Arrays.asList(strRecipientEmail.split("\\s*,\\s*"));
        strAsunto = "Reserva de VE "+resVtaNro.getText().toString();
        strNroVta = nroVta_res.getText().toString();
        strTituloVta = tituloVta_res.getText().toString();
        strNotaVe = resNotaVe.getText().toString();
    }

    @Override
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        switch(v.getId())
        {
            case R.id.btnReservar:
                getValues();
                new SendMailTask(FormReservaActivity.this).execute(strSenderEmail, strSenderPassword, recipientEmailList,
                        strAsunto,"Nro de VE: "+strNroVta+
                                  "Titulo de VE: "+ strTituloVta +
                                  "Nota: "+ strNotaVe + "\n" +
                                  "Cantidades: " +strCantidad);
                break;
        }
    }
}