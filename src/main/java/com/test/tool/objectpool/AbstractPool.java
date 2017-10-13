package com.test.tool.objectpool;

/**
 * Created by Administrator on 2017/9/5.
 */
abstract class AbstractPool<T> implements Pool<T> {

    @Override
    public void release(T t) {
        if(isValid(t)){
            returnToPool(t);
        }else{
            handleInvalidReturn(t);
        }

    }

    protected abstract void handleInvalidReturn(T t);

    protected abstract void returnToPool(T t);

    protected  abstract boolean isValid(T t);

}
