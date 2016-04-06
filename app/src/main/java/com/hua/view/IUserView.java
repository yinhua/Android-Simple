package com.hua.view;

import com.hua.data.User;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/10 下午3:34
 */
public interface IUserView extends IProgressView {
    void bindUserView(User user);
}
