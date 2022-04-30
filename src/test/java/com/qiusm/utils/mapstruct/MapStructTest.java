package com.qiusm.utils.mapstruct;

import com.qiusm.utils.UtilsApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author qiushengming
 */
@Slf4j
public class MapStructTest extends UtilsApplicationTests {
    /**
     * 一个简单的测试
     */
    @Test
    public void test() {
        Domain domain = new Domain();
        domain.setDate(new Date());
        domain.setIgnore("忽略掉的属性");
        domain.setBooleanValue(Boolean.FALSE);
        domain.setIntValue(1);

        Dto dto = IDtoConverter.INSTANCE.toDto(domain);
        log.info("{}", dto);
    }
}
