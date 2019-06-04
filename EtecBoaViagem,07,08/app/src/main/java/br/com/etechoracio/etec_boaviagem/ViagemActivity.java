package br.com.etechoracio.etec_boaviagem;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

import br.com.etechoracio.etec_boaviagem.utils.DateTimeUtils;


public class ViagemActivity extends AppCompatActivity {


    private Button btnDataChegada;
    private Button btnDataSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viagem);


        btnDataChegada = findViewById(R.id.btnDataChegada);
        btnDataSaida = findViewById(R.id.btnDataSaida);

    }

    private void showInsertMessage()  {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmação");
        builder.setMessage("Registro inserido com sucesso");
    }

    private DatePickerDialog.OnDateSetListener datachegada = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int ano, int mes, int dia) {
            btnDataChegada.setText(DateTimeUtils.formatDate(dia, mes + 1, ano));
        }
    };

    private DatePickerDialog.OnDateSetListener datasaida = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int ano, int mes, int dia) {
            String data1 = String.valueOf(dia) + "/" + String.valueOf(mes + 1) + "/" + String.valueOf(ano);
            btnDataSaida.setText(data1);
        }
    };

    protected Dialog onCreateDialog(int id){
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int ano = calendario.get(Calendar.YEAR);

        switch (id) {
            case R.id.btnDataChegada:
                return new DatePickerDialog(this, datachegada, dia, mes, ano);
            case R.id.btnDataSaida:
                return new DatePickerDialog(this,datasaida,dia,mes,ano);
        }
        return null;
    }
    public void onSelecionarData(View v){
        showDialog(v.getId());
    }

}




