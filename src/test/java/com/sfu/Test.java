package com.sfu;

import java.net.URL;
import java.util.logging.Filter;

public class Test {

    @org.junit.Test
    public void get(){
        URL url = Filter.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println("path:"+url.getPath()+"  name:"+url.getFile());
    }
}

