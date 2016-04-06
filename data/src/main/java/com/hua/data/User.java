package com.hua.data;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/17 下午3:46
 */
public class User {
    private long mId;
    private String mNickName;
    private String mUserName;
    private int age;

    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }

    public String getNickName() {
        return mNickName;
    }

    public String getUserName() {
        return mUserName;
    }

    public int getAge() {
        return age;
    }

    public void setNickName(String nickName) {
        mNickName = nickName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
