package com.hua.view.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hua.app.R;
import com.hua.app.databinding.MainBinding;
import com.hua.data.User;
import com.hua.presenter.GetUserPresenter;
import com.hua.presenter.ModifyUserNamePresenter;
import com.hua.presenter.UserLoginPresenter;
import com.hua.provider.bind.MainViewBindUser;
import com.hua.view.IModifyUserNameView;
import com.hua.view.IUserLoginView;
import com.hua.view.IUserView;

public class MainActivity extends BaseActivity
        implements IUserView, IUserLoginView, IModifyUserNameView {
    private ProgressDialog mProgressDialog;
    private GetUserPresenter mGetUserPresenter;
    private UserLoginPresenter mUserLoginPresenter;
    private ModifyUserNamePresenter mModifyUserNamePresenter;
    private MainViewBindUser mMainViewBindUser = new MainViewBindUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainBinding mainBinding = bindingContentView(R.layout.activity_main);
        mainBinding.setProvider(mMainViewBindUser);

        mGetUserPresenter = new GetUserPresenter(this);
        mUserLoginPresenter = new UserLoginPresenter(this);
        mModifyUserNamePresenter = new ModifyUserNamePresenter(this);
    }

    public void onClickLogin(View view) {
        mUserLoginPresenter.login("yinhua", "yinhua");
    }

    public void onClickGetUser(View view) {
        mGetUserPresenter.getUser(1);
    }

    public void onClickModifyUserName(View view) {
        mModifyUserNamePresenter.modifyUserName("hua.yin");
    }

    @Override
    public void showProgressView() {
        mProgressDialog = ProgressDialog.show(this, "请等待", "正在加载...");
    }

    @Override
    public void dismissProgressView() {
        mProgressDialog.dismiss();
    }

    @Override
    public void bindUserView(User user) {
        mMainViewBindUser.bindUser(user);
    }

    @Override
    public void startMain() {
        Toast.makeText(this, "启动主页", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToast(String failure) {
        Toast.makeText(this, failure, Toast.LENGTH_LONG).show();
    }

    @Override
    public void bindUserName(String name) {
        mMainViewBindUser.bindTitle(name);
    }
}
