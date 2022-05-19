package com.qiusm.utils.java8.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * stream 日常操作
 *
 * @author qiushengming
 */
public class StreamOper {

    /**
     * List转Map
     */
    public void listToMap() {
        List<Object> objectList = new ArrayList<>();
        // mergeFunction： 当出现key重复的处理办法，默认是抛出异常
        Map<Integer, Object> oldVdListMap =
                objectList.stream().collect(Collectors.toMap(Object::hashCode, v -> v,
                        (u, v) -> u,
                        HashMap::new));
    }
}
