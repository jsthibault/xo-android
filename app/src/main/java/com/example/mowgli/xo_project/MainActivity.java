package com.example.mowgli.xo_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Currency currency = new Currency("a3572f1ebfa5e95944d715fcd2ce35cc", this.getApplicationContext());
        currency.current("EUR");
    }
}
