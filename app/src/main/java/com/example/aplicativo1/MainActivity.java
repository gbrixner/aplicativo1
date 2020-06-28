package com.example.aplicativo1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    Double valorPagamento;
    Date dtNascimento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void consultar(View view) throws ParseException {
        EditText vCPF = findViewById(R.id.editText);
        EditText vDtNascimento = findViewById(R.id.editText2);
        EditText vRendaMensal = findViewById(R.id.editText3);

        valorPagamento = Double.parseDouble(String.valueOf(vRendaMensal.getText())) * 0.7;
        if (valorPagamento > 475.00){
            valorPagamento = 475.00;
        }

        //Descobrir a data de Pagamento
        String s = String.valueOf(vDtNascimento.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        Date date = sdf.parse(s);
        Date dateAux = sdf.parse(s);
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(date);
        cal2.setTime(dateAux);
        cal.add(Calendar.DAY_OF_MONTH, 20);
        cal.set(Calendar.YEAR, 2020);
        date = cal.getTime();
        //Toast.makeText(this, "Data 1: "+date, Toast.LENGTH_LONG).show();

        //Descobrir a Idade
        int idade = cal.after(cal2) ? -1 : 0;
        cal.setTime(date);
        idade = cal.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        //Toast.makeText(this, "Idade : "+idade, Toast.LENGTH_LONG).show();

        dtNascimento = date;
       if (Double.parseDouble(String.valueOf(vRendaMensal.getText())) > 5000.00) {
            //Retornar pro usuário
            Toast.makeText(this, "Auxilio Negado", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(MainActivity.this, ActivitySecond.class);
            Bundle b = new Bundle();
            b.putString("data", dtNascimento.toString());
            b.putString("valor", valorPagamento.toString());
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }
}