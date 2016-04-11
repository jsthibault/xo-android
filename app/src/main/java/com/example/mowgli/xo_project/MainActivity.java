package com.example.mowgli.xo_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
                    long value;
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
                    if ((value = Long.valueOf(str)) == 0) {
                        Toast.makeText(MainActivity.this,
                                MainActivity.this.getResources().getText(R.string.Value0),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            });
    }

}
