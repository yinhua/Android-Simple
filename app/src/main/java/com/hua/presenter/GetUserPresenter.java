package com.hua.presenter;

import com.hua.data.User;
import com.hua.domian.user.UserModule;
import com.hua.view.IUserView;

import rx.Subscriber;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/10 下午3:09
 */
public class GetUserPresenter {
    private UserModule mUserModule;
    private IUserView mIUserView;

    public GetUserPresenter(IUserView iUserView) {
        mUserModule = new UserModule();
        mIUserView = iUserView;
    }

    public void getUser(int userId) {
        mIUserView.showProgressView();
        mUserModule.getUser(userId, mUserSubscriber);
    }

    private Subscriber<User> mUserSubscriber = new Subscriber<User>() {
        @Override
        public void onCompleted() {
            mIUserView.dismissProgressView();
        }

        @Override
        public void onError(Throwable e) {
            mIUserView.dismissProgressView();
            mIUserView.showToast(e.getMessage());
        }

        @Override
        public void onNext(User user) {
            mIUserView.bindUserView(user);
        }
    };
}
