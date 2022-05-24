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
    /**
     * 注意：如果希望 logback 输入堆栈信息的话，请按<code>log.error("{}", e.getMessage(), e);</code>的形式输入ERROR日志，第三个参数是Exception对象
     */
    @Test
    void toLogstash() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i == 8) {
                    throw new NullPointerException("test null");
                } else {
                    log.info("测试日志输出：{}", i);
                }
            }
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
