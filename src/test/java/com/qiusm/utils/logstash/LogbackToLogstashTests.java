package com.qiusm.utils.logstash;

import com.qiusm.utils.UtilsApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 将日志通过logback 输入到 logstash 上
 *
 * @author qiushengming
 */
@Slf4j
public class LogbackToLogstashTests extends UtilsApplicationTests {
    @Test
    void toLogstash() {
        for (int i = 0; i < 10; i++) {
            log.info("测试日志输出：{}", i);
        }
    }
}
