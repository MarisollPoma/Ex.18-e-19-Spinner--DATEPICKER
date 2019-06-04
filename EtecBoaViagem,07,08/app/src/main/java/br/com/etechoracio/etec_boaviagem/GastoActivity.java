package br.com.etechoracio.etec_boaviagem;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.Calendar;

import br.com.etechoracio.etec_boaviagem.utils.DateTimeUtils;

public class GastoActivity extends AppCompatActivity {

    private Button btnData;
    private Spinner spnTipoGasto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto);

        spnTipoGasto = (Spinner) findViewById(R.id.spnTipoGasto);
        spnTipoGasto.setAdapter(getAdapterTipoGasto());

        btnData = findViewById(R.id.btnData);

    }

    private ArrayAdapter getAdapterTipoGasto() {
        return new ArrayAdapter<TipoGastoEnum>(this,
                R.layout.support_simple_spinner_dropdown_item,
                TipoGastoEnum.values());

    }

    private DatePickerDialog.OnDateSetListener datagasto = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {

            btnData.setText(DateTimeUtils.formatDate(dia, mes +1, ano));
        }
    };

    protected Dialog onCreateDialog(int id) {
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int ano = calendario.get(Calendar.YEAR);

        switch (id) {
            case R.id.btnData:
                return new DatePickerDialog(this, datagasto, dia, mes, ano);
        }
        return null;
    }

    public void onSelecionarData(View v) {
        showDialog(v.getId());
    }

}







