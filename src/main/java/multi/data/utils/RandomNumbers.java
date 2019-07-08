package multi.data.utils;

import java.util.Random;

public class RandomNumbers {

    public static String getOrder() {
        String orderId = null;
        for (int mantissa = 1; mantissa <= 50; mantissa++) {
            StringBuilder str = new StringBuilder();//定义变长字符串
            Random random = new Random();
            //随机生成数字，并添加到字符串
            for (int i = 0; i < 17; i++) {
                str.append(random.nextInt(10));
            }
            orderId = 1 + str.toString();
        }
        return orderId;
    }

}
