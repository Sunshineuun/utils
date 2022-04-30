package com.qiusm.utils.mapstruct;

import lombok.Data;

import java.util.Date;

/**
 * @author qiushengming
 */
@Data
public class Domain {
    private int intValue;
    private String str;
    private Date date;
    private boolean booleanValue;
    /**
     * 被忽略的属性
     */
    private String ignore;
}
