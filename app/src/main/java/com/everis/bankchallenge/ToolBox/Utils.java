package com.everis.bankchallenge.ToolBox;

import android.content.Context;
import android.content.DialogInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.appcompat.app.AlertDialog;

public class Utils {

    public static void alertDialog(String title, String message, boolean cancelable, String positive, String negative,
                                   Context context, final Runnable if_ok, final Runnable if_false) {

        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);


        alertBuilder.setTitle(title).setMessage(message).setCancelable(cancelable);


        alertBuilder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (if_ok != null) {
                    if_ok.run();
                }
            }
        });
        alertBuilder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (if_false != null) {
                    if_false.run();
                }
            }
        });

        alertBuilder.create().show();

    }


    public static boolean validatePassword(final String password) {
        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*+=])(?=\\S+$).{4,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static boolean validateEmail(String email) {
        Matcher matcher;
        Pattern pattern;

        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
