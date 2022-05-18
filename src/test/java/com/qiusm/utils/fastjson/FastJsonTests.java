package com.qiusm.utils.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author qiushengming
 */
@Slf4j
public class FastJsonTests {
    public static void main(String[] args) {
        deserialize(serialization());
    }

    /**
     * 测试序列化
     */
    static String serialization() {
        OrgAccountModel orgAccountModel = new OrgAccountModel();
        orgAccountModel.setOrgCode("Test-Code");
        orgAccountModel.setOrgName("Test-Name");
        String s = JSON.toJSONString(orgAccountModel);
        log.info("{}", s);
        return s;
    }

    /**
     * 测试反序列化. <br>
     * 1. {@link JSONField#alternateNames()} , 反序列化时字段的替代名称。有效性验证 <br>
     */
    static void deserialize(String s) {
        // String s = "{\"orgName\":\"Test-Name\",\"orgCode\":\"Test-Code\"}";
        OrgAccountModel o = JSON.parseObject(s, OrgAccountModel.class);
        log.info("{}", o);
    }
}
