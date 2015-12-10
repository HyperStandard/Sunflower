package com.example.andrew.sunflower.groovy

import com.squareup.otto.Bus
import com.squareup.otto.ThreadEnforcer
import groovy.transform.CompileStatic;

@Singleton
@CompileStatic
public class BusProvider {
    private static final AndroidBus BUS = new AndroidBus(ThreadEnforcer.ANY);

    public static Bus getInstance() {
        return BUS
    }


    /*public startCount() {
        int i = 0;
        while (true) {
            Thread.start {
                Thread.sleep 1000
                BUS?.post("Count: " + i + "\n")
                i++
            }
            if (i > 100) {
                break
            }
        }
    }*/
}