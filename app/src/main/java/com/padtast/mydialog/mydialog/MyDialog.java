package com.padtast.mydialog.mydialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

public class MyDialog {

    private Dialog dialog = null;
    private static volatile MyDialog instance = null;
    /**
     * 带有 确认，取消按钮
     * 如果 底部两个按钮 不修改可以不传参
     * 两个监听事件 也是一样
     *    new MyDialog.Builder().setContext(MainActivity.this)
     *                           .setMsgString("荒诞收看电视看电视")
     *                           .setStrategy(MyDialog.OKANDREMOVE)
     *                           .setOkButtonString("姜思达")
     *                           .setCancelButtonString("圣诞节绝对是")
     *                           .build();
     */
    public static int OKANDREMOVE = 1;

    private MyDialog() {
    }

    public static MyDialog getInstance() {
        if (instance == null) {
            synchronized (MyDialog.class) {
                if (instance == null) {
                    instance = new MyDialog();
                }
            }
        }
        return instance;
    }

    private Dialog getDialog(Context context) {
        if (null == dialog) {
            return new Dialog(context);
        }
        return dialog;
    }


    private void setShow(Builder builder) {
        DialogStrategy dialogStrategy = null;
        if (builder.strategy == OKANDREMOVE) {
            dialogStrategy = new ConfirmAndRemoveDialog(getDialog(builder.context));
        }
        if(null != dialogStrategy){
            dialogStrategy.setBuilder(builder);
            dialogStrategy.show();
        }
    }


    public static class Builder {
        private Context context;
        private int strategy;
        private View.OnClickListener okOnClickListener;
        private View.OnClickListener cancelClickListener;
        private String okString;
        private String cancelString;
        private String msgString;

        public Context getContext() {
            return context;
        }

        public int getStrategy() {
            return strategy;
        }

        public View.OnClickListener getOkOnClickListener() {
            return okOnClickListener;
        }

        public View.OnClickListener getCancelClickListener() {
            return cancelClickListener;
        }

        public String getOkString() {
            return okString;
        }

        public String getCancelString() {
            return cancelString;
        }

        public String getMsgString() {
            return msgString;
        }

        public Builder setStrategy(int strategy) {
            this.strategy = strategy;
            return this;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setOkClickListener(View.OnClickListener onClickListener) {
            this.okOnClickListener = onClickListener;
            return this;
        }

        public Builder setCancelClickListener(View.OnClickListener onClickListener) {
            this.okOnClickListener = onClickListener;
            return this;
        }
        public Builder setOkButtonString(String okString) {
            this.okString = okString;
            return this;
        }

        public Builder setCancelButtonString(String cancelString) {
            this.cancelString = cancelString;
            return this;
        }
        public Builder setMsgString(String msgString) {
            this.msgString = msgString;
            return this;
        }
        public void build() {
            getInstance().setShow(this);
        }
    }


}
