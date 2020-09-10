package com.example.gadsleaderboardmobile.Util;

import android.content.Context;
import android.widget.Toast;

public class Helper {
    public Helper() {
    }

    Context context;

    public Helper(Context context) {
        this.context = context;
    }

    public void toastMessage(String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public void toastMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
