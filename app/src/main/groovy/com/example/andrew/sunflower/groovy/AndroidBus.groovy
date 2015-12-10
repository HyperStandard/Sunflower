package com.example.andrew.sunflower.groovy;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus
import com.squareup.otto.ThreadEnforcer
import groovy.transform.CompileStatic;

/**
 * Created by Andrew on 12/10/2015.
 */

@CompileStatic
public class AndroidBus extends Bus {
    private final Handler mainThread = new Handler(Looper.getMainLooper());

    AndroidBus(ThreadEnforcer enforcer) {
        super(enforcer)
    }

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post event
        } else {
            mainThread.post(Thread.start { post event })
        }
    }
}
