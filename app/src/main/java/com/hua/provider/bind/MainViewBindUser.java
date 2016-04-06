package com.hua.provider.bind;

import com.hua.data.User;
import com.hua.provider.MainDataProvider;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/18 上午9:32
 */
public class MainViewBindUser extends MainDataProvider {
    private User mUser = new User();

    public void bindUser(User user) {
        mUser = user;
        notifyChange();
    }

    @Override
    public String getTitle() {
        return mUser.getUserName();
    }

    @Override
    public void setTitle(String title) {
        mUser.setUserName(title);
    }
}
