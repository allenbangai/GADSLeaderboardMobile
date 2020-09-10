package com.example.gadsleaderboardmobile.Util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Helper {
    private Intent intent;
    private Context context;
    private ProgressDialog progressDialog;

    public Helper() {
    }

    public Helper(Context context) {
        this.context = context;
    }

    //progress dialog functions
    public void progressDialogStart(String titleMessage, String detailMessage){
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(titleMessage);
        progressDialog.setMessage(detailMessage);
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(true);
    }

    public void progressDialogEnd(){
        progressDialog.dismiss();
    }

    public void toastMessage(String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public void toastMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
