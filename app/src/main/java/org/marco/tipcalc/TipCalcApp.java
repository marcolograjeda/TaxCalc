package org.marco.tipcalc;

import android.app.Application;

/**
 * Created by marco on 6/28/16.
 */
public class TipCalcApp extends Application{
    private final static String ABOUT_URL = "https://about.me/adriancatalan";

    public String getAboutUrl() {
        return ABOUT_URL;
    }
}
