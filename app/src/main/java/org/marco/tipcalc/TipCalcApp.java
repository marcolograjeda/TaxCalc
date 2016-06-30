package org.marco.tipcalc;

import android.app.Application;

/**
 * Created by Angel on 19/06/16.
 */
public class TipCalcApp extends Application {
    private final static String ABOUT_URL = "https://about.me/adriancatalan";

    public static String getAboutUrl() {
        return ABOUT_URL;
    }
}
