package com.test.tool.objectpool;

/**
 * Created by Administrator on 2017/9/5.
 */
public interface Pool<T> {

    T get();

    void release(T t);

    void shutdown();

    static interface Validator<T>{

        public boolean isValid(T t);

        public void inValidate(T t);
    }

}
