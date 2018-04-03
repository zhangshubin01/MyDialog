package com.padtast.mydialog.mydialog;

import android.app.Dialog;

public class BaseDialogConfigure implements DialogStrategy {
    protected MyDialog.Builder builder;
    protected Dialog dialog;

    BaseDialogConfigure(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void setBuilder(MyDialog.Builder builder) {
        this.builder = builder;
    }

    @Override
    public void show() {

    }

}
