package com.hua.view;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/14 下午4:22
 */
public interface IUserLoginView extends IProgressView {
    void startMain();

    void showToast(String failure);
}
