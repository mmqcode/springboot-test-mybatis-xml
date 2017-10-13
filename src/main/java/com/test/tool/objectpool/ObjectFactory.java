package com.test.tool.objectpool;

/**
 * Created by Administrator on 2017/9/6.
 */
public interface ObjectFactory<T> {

    public abstract T createNew();

}
