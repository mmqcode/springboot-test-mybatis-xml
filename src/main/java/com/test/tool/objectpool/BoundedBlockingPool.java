package com.test.tool.objectpool;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/9/6.
 */
public class BoundedBlockingPool<T> extends AbstractPool<T> implements BlockingPool<T> {


    private int size;
    private BlockingQueue<T> objects;
    private Validator validator;
    private ObjectFactory<T> objectFactory;
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private volatile boolean shutdownCalled;

    public BoundedBlockingPool(int size, Validator validator, ObjectFactory<T> objectFactory){

        super();
        this.objectFactory = objectFactory;
        this.validator = validator;
        this.size = size;
        objects = new LinkedBlockingDeque<T>(size);
        initialObjects();
        shutdownCalled = false;
    }

    @Override
    public T get() {
        if(!shutdownCalled){

            T t = null;
            try{

                t = objects.take();

            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            return t;
        }
        throw new IllegalStateException(
                "Object pool is already shutdown.");
    }


    @Override
    public void shutdown() {
        shutdownCalled = true;
        executorService.shutdownNow();
        clearResources();
    }

    @Override
    public void release(T t) {
        super.release(t);
    }

    @Override
    public T get(long time, TimeUnit unit) throws InterruptedException {
        if(!shutdownCalled){

            T t = null;
            try{
                t = objects.poll(time, unit);
                return t;
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            return t;
        }
        throw new IllegalStateException(
                "Object pool is already shutdown.");
    }

    @Override
    protected void handleInvalidReturn(T t) {

    }

    @Override
    protected void returnToPool(T t) {

        if(isValid(t)){
            executorService.submit(new ObjectReturner(objects, t));
        }
    }

    @Override
    protected boolean isValid(T t) {
        return validator.isValid(t);
    }
    public void initialObjects(){
        for(int i = 0; i < size; i++){
            objects.add(objectFactory.createNew());
        }
    }

    private void clearResources(){
        for(T t: objects){
            validator.inValidate(t);
        }

    }

    private class ObjectReturner<E> implements Callable<E> {
        private BlockingQueue queue;
        private E e;

        public ObjectReturner(BlockingQueue queue, E e){
            this.queue = queue;
            this.e = e;
        }
        @Override
        public E call() throws Exception {

            while(true){
                try{
                    queue.put(e);
                    break;
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();;
                }
            }
            return null;
        }
    }
}
