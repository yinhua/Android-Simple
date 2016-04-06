package com.hua.provider;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.hua.app.BR;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/18 上午9:31
 */
public abstract class MainDataProvider
        extends BaseObservable {
    @Bindable
    public abstract String getTitle();

    public abstract void setTitle(String title);

    public void bindTitle(String title) {
        setTitle(title);
        notifyPropertyChanged(BR.title);
    }

}
