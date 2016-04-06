package com.hua.presenter;

import com.hua.domian.user.UserModule;
import com.hua.view.IUserLoginView;

import rx.Subscriber;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/10 下午3:09
 */
public class UserLoginPresenter {
    private UserModule mUserModule;
    private IUserLoginView mIUserLoginView;

    public UserLoginPresenter(IUserLoginView iUserLoginView) {
        mUserModule = new UserModule();
        mIUserLoginView = iUserLoginView;
    }

    public void login(String userName, String password) {
        mIUserLoginView.showProgressView();
        mUserModule.login(userName, password, mLoginSubscriber);
    }

    private void loginFailure() {
        if (mIUserLoginView != null) {
            mIUserLoginView.showToast("失败");
        }
    }

    private void loginSuccess() {
        if (mIUserLoginView != null) {
            mIUserLoginView.startMain();
        }
    }

    private Subscriber<Boolean> mLoginSubscriber = new Subscriber<Boolean>() {
        @Override
        public void onCompleted() {
            mIUserLoginView.dismissProgressView();
        }

        @Override
        public void onError(Throwable e) {
            mIUserLoginView.showToast("出错");
        }

        @Override
        public void onNext(Boolean aBoolean) {
            if (aBoolean) {
                loginSuccess();
            } else {
                loginFailure();

            }
        }

    };
}
