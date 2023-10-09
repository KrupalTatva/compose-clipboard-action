package com.example.customclipboardaction;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class ClipBoardActivity extends AppCompatActivity {

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //todo : please check styles and manifest for floating window functionality 

        if (getIntent() != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // Intent.EXTRA_PROCESS_TEXT  support from 23 or

                text = getIntent().getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT).toString();
                Log.i("Custom Action", text);
                showAlert();
            } else {
                Log.i("Custom Action", "your device not support Intent.EXTRA_PROCESS_TEXT");
            }

        } else {
            text = "";
            Log.i("Custom Action", "No action text found");
        }
    }

    private void showAlert() {
        new AlertDialog
                .Builder(this)
                .setTitle("Custom text action")
                .setMessage("Selected text : " + text)
                .setCancelable(true)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
    }


}