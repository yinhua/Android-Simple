package com.hua.domian.user;

import android.util.Log;

import com.hua.data.User;
import com.hua.domian.ModuleListener;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/10 下午3:06
 * 此类为用户模块业务,还需要完善
 */
public class UserModule {
    public void getUser(final int userId, Subscriber<User> subscriber) {
        Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {
                if (userId > 0) {
                    User user = new User();
                    user.setUserName("yinhua");
                    subscriber.onNext(user);
                    subscriber.onCompleted();
                } else {
                    subscriber.onError(new Exception("error"));
                }
            }
        }).delaySubscription(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void login(final String userName, final String password
            , Subscriber<Boolean> subscriber) {
        Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                Log.i("data", userName + "  " + password);
                if ("yinhua".equalsIgnoreCase(userName)
                        && "yinhua".equalsIgnoreCase(password)) {
                    subscriber.onNext(true);
                    subscriber.onCompleted();
                } else {
                    subscriber.onError(new Exception("error"));
                }
            }
        }).subscribe(subscriber);
    }

    public void modifyUserName(final String name, final ModuleListener<String, String> listener) {
        if (name == null) {
            listener.onFailure(name);
        } else {
            listener.onSuccess(name);
        }
    }
}
