package com.example.mowgli.xo_project;

import android.database.CursorIndexOutOfBoundsException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class        MainActivity extends AppCompatActivity {

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button BSend = (Button) this.findViewById(R.id.Button);
        final EditText editText = (EditText) this.findViewById(R.id.ET_Value);
        final Spinner spinnerFrom = (Spinner) this.findViewById(R.id.ActivityMain_Spinner_From);
        final Spinner spinnerTo = (Spinner) this.findViewById(R.id.ActivityMain_Spinner_To);

        if (BSend != null && editText != null && spinnerFrom != null && spinnerTo != null)
            BSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str;
                    double value;
                    String currencyFrom;
                    String currencyTo;

                    if ((str = editText.getText().toString()).equals("")) {
                        Toast.makeText(MainActivity.this,
                                MainActivity.this.getResources().getText(R.string.ErrorValue),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    currencyFrom = spinnerFrom.getSelectedItem().toString();
                    currencyTo = spinnerTo.getSelectedItem().toString();
                    if (currencyFrom.equals(currencyTo)) {
                        Toast.makeText(MainActivity.this,
                                MainActivity.this.getResources().getText(R.string.ErrorCurrency),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if ((value = Double.valueOf(str)) == 0) {
                        Toast.makeText(MainActivity.this,
                                MainActivity.this.getResources().getText(R.string.Value0),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    appCurent(currencyFrom, currencyTo, value);
                }
            });
    }

    final void appCurent(String from, String to, Double value) {
        TextView textView = (TextView) findViewById(R.id.value);

        if (textView == null) {
            Toast.makeText(getApplicationContext(), getResources().getText(R.string.textViewFail),
                    Toast.LENGTH_LONG);
            return;
        }
        Currency currency = new Currency("", getApplicationContext());
        currency.current(from, to, value, textView);
    }
}
