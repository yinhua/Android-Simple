package com.hua.domian;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/14 下午5:49
 */
public interface ModuleListener<T, D> {
    void onSuccess(T t);

    void onFailure(D d);
}
