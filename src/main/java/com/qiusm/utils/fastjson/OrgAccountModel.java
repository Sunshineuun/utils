package com.qiusm.utils.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 1. 解决反序列化和序列化时的key不一样的情况 20220518<br>
 */
@Data
public class OrgAccountModel {
    /**
     * 1. {@link JSONField#alternateNames()} , 反序列化时字段的替代名称 <br>
     */
    private String orgCode;
    @JSONField(name = "name", alternateNames = {"orgName"})
    private String orgName;
}