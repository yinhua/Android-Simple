package com.hua.view.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;


/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/17 下午12:51
 */
public class BaseActivity extends AppCompatActivity {

    public <T extends ViewDataBinding> T bindingContentView(int layoutResID) {
        return DataBindingUtil.setContentView(this, layoutResID);
    }
}
