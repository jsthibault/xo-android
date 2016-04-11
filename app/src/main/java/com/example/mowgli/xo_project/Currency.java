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

    Currency(String key, Context context) {
        this._key = key;
        this._context = context;
    }

    protected void modifyFrom()
    {

    }

    protected void modifyTo()
    {

    }

    public void current(String From, String To)
    {
        this._To = To.toUpperCase();
        Ion.with(this._context)
                .load("http://www.apilayer.net/api/live?access_key=" + this._key + "&currencies=" + this._To)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {

                        result = result.getAsJsonObject("quotes");
                        Log.v("Res: ", result.get("USD" + _To).toString());
                    }
                });


    }
}
