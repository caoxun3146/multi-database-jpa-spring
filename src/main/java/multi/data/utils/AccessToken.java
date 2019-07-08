package multi.data.utils;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AccessToken {
    /**
     * 从缓存服务器中查询出淘宝ID对应的账号的最新的token
     *
     * @param userId
     * @return
     */
    public static String getAccessToken(long userId) {
        //链接趣专享测试缓存服务器
        Jedis jedis = new Jedis("139.196.82.192");
        jedis.auth("vipgiftQuzhuanxiang");
// access_token_list:662414
        // 获取存储的数据并输出 access_token_list:662211
        String tokenKey = "access_token_list:" + userId;
        Set<String> setCache = jedis.smembers(tokenKey);

        Map<String, String> map = new HashMap<String, String>();  // 创建map来存储token集

        String[] strArr;
        long max = 0; // 匹配出最新的token值
        for (String setStr : setCache) {
            strArr = setStr.split(":");
            map.put(strArr[1], strArr[0]); // 将token存储到map中
            if (Long.parseLong(strArr[1]) > max) {
                max = Long.parseLong(strArr[1]);
            }
        }
        return map.get(max + ""); // map参数, 必须传字符串类型

    }

}
