package com.sfu.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    private static Logger log = LoggerFactory.getLogger(LogTest.class);
    @Test
    public void testLog(){
        Logger log = LoggerFactory.getLogger(this.getClass());
        log.trace("这是trace日志。。。");
        log.debug("这是debug日志。。。");
        log.info("这是info日志。。。");
        log.warn("这是warn日志。。。");
        log.error("这是error日志。。。");
    }

}
