package com.example.thelendinghub.custom;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Toast;

public class Utils {

    public static int getScreenDpi(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.densityDpi;
    }

    public static void getScreenDensity(Context context){
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        int density = metrics.densityDpi;
        if (density <= DisplayMetrics.DENSITY_XXXHIGH && density>DisplayMetrics.DENSITY_XXHIGH){
            Toast.makeText(context, "DENSITY_XXXHIGH... Density is " + String.valueOf(density),  Toast.LENGTH_LONG).show();
        }else if (density <= DisplayMetrics.DENSITY_XXHIGH && density>DisplayMetrics.DENSITY_XHIGH){
            Toast.makeText(context, "DENSITY_XXHIGH... Density is " + String.valueOf(density),  Toast.LENGTH_LONG).show();
        }else if (density <= DisplayMetrics.DENSITY_XHIGH && density>DisplayMetrics.DENSITY_HIGH){
            Toast.makeText(context, "DENSITY_XHIGH... Density is " + String.valueOf(density),  Toast.LENGTH_LONG).show();
        }
        else if (density <= DisplayMetrics.DENSITY_HIGH && density>DisplayMetrics.DENSITY_MEDIUM) {
            Toast.makeText(context, "DENSITY_HIGH... Density is " + String.valueOf(density),  Toast.LENGTH_LONG).show();
        }
        else if (density <= DisplayMetrics.DENSITY_MEDIUM && density>DisplayMetrics.DENSITY_LOW) {
            Toast.makeText(context, "DENSITY_MEDIUM... Density is " + String.valueOf(density),  Toast.LENGTH_LONG).show();
        }
        else if (density <= DisplayMetrics.DENSITY_LOW) {
            Toast.makeText(context, "DENSITY_LOW... Density is " + String.valueOf(density),  Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, "Density is neither HIGH, MEDIUM OR LOW.  Density is " + String.valueOf(density),  Toast.LENGTH_LONG).show();
        }
    }
}
