package com.qzy.laobiao.common.net;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**

 * Description:MyObserver
 */

public abstract class MyObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
