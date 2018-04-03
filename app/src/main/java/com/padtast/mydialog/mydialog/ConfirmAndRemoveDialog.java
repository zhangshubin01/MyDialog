package com.padtast.mydialog.mydialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.padtast.mydialog.R;
import com.padtast.mydialog.StringUtils;


/**
 * 确认 和 取消按钮  的对话框
 */
public class ConfirmAndRemoveDialog extends BaseDialogConfigure{

    protected ConfirmAndRemoveDialog(Dialog dialog) {
        super(dialog);
    }

    @Override
    public void show() {
        super.show();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().setContentView(R.layout.view_hintmsg_ok_cancel);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.dismiss();
            }
        });
        TextView msgtextview = dialog.findViewById(R.id.szzc_view_hintmsg_msg);
        msgtextview.setText(builder.getMsgString());
        Button cancel = dialog.findViewById(R.id.szzc_view_hintmsg_cancel);
        if(!StringUtils.isEmpty(builder.getCancelString())){
            cancel.setText(builder.getCancelString());
        }
        if(null != builder.getCancelClickListener()){
            cancel.setOnClickListener(builder.getCancelClickListener());
        }else{
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        Button ok = dialog.findViewById(R.id.szzc_view_hintmsg_ok);
        if(!StringUtils.isEmpty(builder.getOkString())){
            ok.setText(builder.getOkString());
        }
        if(null != builder.getOkOnClickListener()){
            ok.setOnClickListener(builder.getOkOnClickListener());
        }else{
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }
        dialog.show();
    }

}
