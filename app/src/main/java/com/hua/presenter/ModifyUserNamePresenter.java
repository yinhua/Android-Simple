package com.hua.presenter;

import com.hua.domian.ModuleListener;
import com.hua.domian.user.UserModule;
import com.hua.view.IModifyUserNameView;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/10 下午3:09
 */
public class ModifyUserNamePresenter implements ModuleListener<String, String> {
    private UserModule mUserModule;
    private IModifyUserNameView mIModifyUserNameView;

    public ModifyUserNamePresenter(IModifyUserNameView iModifyUserNameView) {
        mUserModule = new UserModule();
        mIModifyUserNameView = iModifyUserNameView;
    }

    public void modifyUserName(String userName) {
        mIModifyUserNameView.showProgressView();
        mUserModule.modifyUserName(userName, ModifyUserNamePresenter.this);
    }

    @Override
    public void onSuccess(String name) {
        mIModifyUserNameView.dismissProgressView();
        mIModifyUserNameView.bindUserName(name);
    }

    @Override
    public void onFailure(String s) {
        mIModifyUserNameView.dismissProgressView();
        mIModifyUserNameView.showToast(s);
    }
}
