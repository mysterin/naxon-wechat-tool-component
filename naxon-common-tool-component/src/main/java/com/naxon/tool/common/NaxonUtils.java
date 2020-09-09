package com.naxon.tool.common;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author naxon
 * 通用工具类
 */
public class NaxonUtils {

    public static Boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return StringUtils.isEmpty((String) obj);
        }
        return false;
    }

    public static Boolean hasEmpty(Object... objs) {
        for (Object obj : objs) {
            if (isEmpty(obj)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static String randomNumber() {
        return randomNumber(6);
    }

    public static String randomNumber(Integer count) {
        if (count == null) {
            count = 6;
        }
        if (count < 1 || count > 18) {
            throw new IllegalArgumentException("期待参数取值：1-18，实际取值：" + count);
        }

        Double start = Math.pow(10, count);
        Double end = Math.pow(10, count + 1);

        long random = ThreadLocalRandom.current().nextLong(start.longValue(), end.longValue());
        return StringUtils.getString(random);
    }

}
