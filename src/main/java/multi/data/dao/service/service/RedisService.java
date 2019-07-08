package multi.data.dao.service.service;

/**
 * 在包里创建RedisService接口，在这个接口定义了一些redis的基本操作。在这里我把所有存取操作都封装成了基于json字符串完成，
 * 就没有对于list或者对于object等单独定义方法。所有的数据类型的存储都由代码转换成json字符串方式进行。所以这里就只有四个方法。
 */
public interface RedisService {

    /**
     * set存数据
     *
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, String value);

    /**
     * get获取数据
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置有效天数
     *
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 移除数据
     *
     * @param key
     * @return
     */
    boolean remove(String key);


}
