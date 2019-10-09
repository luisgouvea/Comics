package com.exame.luiseduardo.comics.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private Activity mActivity;
    private Context mContext;

    public void initialInterfaceActivity() {
        initialActivity();
    }

    public void setInterfacesFindView() {
    }

    public void setHandlerInterface() {
    }

    public void initialActivity() {
        mActivity = this;
        mContext = this;
    }

    public Activity getActivity() {
        return mActivity;
    }

    public Context getContext() {
        return mContext;
    }
}
