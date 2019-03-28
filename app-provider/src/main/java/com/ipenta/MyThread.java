package com.ipenta;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyThread {

    private final Integer indez;
    private final Map<Integer,String> map;

    public MyThread(final Integer indez){
        this.indez = indez;
        this.map = new ConcurrentHashMap<>();
    }

    public Integer getIndez() {
        return indez;
    }
}
