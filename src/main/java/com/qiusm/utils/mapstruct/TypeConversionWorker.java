package com.qiusm.utils.mapstruct;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

/**
 * @author qiushengming
 */
@Slf4j
@Component
@Named("TypeConversionWorker")
public class TypeConversionWorker {

    @Named("dataToStr")
    public String dataToStr(Date time) {
        return DateUtil.formatDate(time);
    }
}
