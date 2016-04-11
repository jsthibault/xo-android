package com.example.mowgli.xo_project;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by mowgli on 11/04/2016.
 */

public class Currency {

    protected String _key;
    protected Context _context;
    protected String _To;
    protected String _From;

    Currency(String key, Context context) {
        this._key = key;
        this._context = context;
    }

    public void modifyTextView(double cFrom, double cTo)
    {
        double res = 1 * cFrom;
        res = res * cTo;
    }

    public void current(String From, String To)
    {
        this._To = To.toUpperCase();
        this._From = From.toUpperCase();
        Ion.with(this._context)
                .load("http://www.apilayer.net/api/live?access_key=" + this._key + "&currencies=" + this._To + "," + this._From)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {

                        result = result.getAsJsonObject("quotes");

                        modifyTextView(Integer.valueOf(result.get("USD" + _To).toString()), Integer.valueOf(result.get("USD" + _From).toString()));
                        Log.v("Res1: ", result.get("USD" + _To).toString());
                        Log.v("Res2: ", result.get("USD" + _From).toString());


                    }
                });


    }
}
