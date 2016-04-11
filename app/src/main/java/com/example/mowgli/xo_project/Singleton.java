package com.example.mowgli.xo_project;

/**
 * Created by mowgli on 11/04/2016.
 */
public class Singleton {

    static Singleton ourInstance;
    static Singleton getInstance()
    {
        if (ourInstance == null)
        {
            ourInstance = new Singleton();
        }
        return (ourInstance);
    }

    public double from = 0;
    public double to = 0;
}
