package com.test.tool.objectpool;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/9/6.
 */
public interface BlockingPool<T> extends Pool<T> {

    T get();

    T get(long time, TimeUnit unit) throws InterruptedException;

}
