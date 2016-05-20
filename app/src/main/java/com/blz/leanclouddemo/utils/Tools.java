package com.blz.leanclouddemo.utils;

import android.app.FragmentManager;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blz.leanclouddemo.R;
import com.roger.gifloadinglibrary.GifLoadingView;

/**
 * Created by BuLingzhuang
 * on 2016/5/20
 * E-mail bulingzhuang@foxmail.com
 */
public class Tools {

    private static GifLoadingView mGifLoadingView;
    private static Toast mToast;

    static {
        mGifLoadingView = new GifLoadingView();
        mGifLoadingView.setImageResource(R.drawable.num15);
    }

    public static void isShowDialog(boolean flag, FragmentManager fragmentManager) {
        if (flag) {
            if (mGifLoadingView == null) {
                mGifLoadingView = new GifLoadingView();
                mGifLoadingView.setImageResource(R.drawable.num15);
                mGifLoadingView.show(fragmentManager, "");
            } else {
                mGifLoadingView.show(fragmentManager, "");
            }
        } else {
            mGifLoadingView.dismiss();
        }
    }

    public static void showToast(Context context, String msg) {
        if (null == context) {
            return;
        }
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.toast_custom_layout, null);
        if (mToast == null) {
            mToast = new Toast(context);
        }
        TextView textView = (TextView) layout.findViewById(R.id.custom_toast);
        textView.setText(msg);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.setView(layout);
        mToast.show();
    }
}
