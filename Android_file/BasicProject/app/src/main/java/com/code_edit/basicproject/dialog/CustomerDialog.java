package com.code_edit.basicproject.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;

import com.code_edit.basicproject.R;

/**
 * Created by Student on 2018/3/12.
 */

public class CustomerDialog extends Dialog {
    public Activity c;
    public Dialog d;

    public CustomerDialog(Activity c) {
        super(c);
        this.c=c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.customer_dialog);
    }
}
