package com.hua.view;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/14 下午6:06
 */
public interface IModifyUserNameView extends IProgressView
        , IToastView {
    void bindUserName(String name);
}
