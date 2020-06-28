package com.example.aplicativo1;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ActivitySecond extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        inTheActivitySecond();
    }

    private void inTheActivitySecond() {
        Bundle b = getIntent().getExtras();
        String saldo = null;
        String data = null;

        TextView vSaldo = findViewById(R.id.textSaldo);
        TextView vData = findViewById(R.id.textData);
        if (b != null) {
            saldo = b.getString("valor");
            vSaldo.setText(saldo);
            data = b.getString("data");
            Date date = new Date(data);
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = formato.format(date);
            vData.setText(dataFormatada);
        }
    }
}
