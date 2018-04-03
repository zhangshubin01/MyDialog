package com.padtast.mydialog.mydialog;

/**
 * 基类
 */
public interface DialogStrategy {
  void show();

  void setBuilder(MyDialog.Builder builder);
}
