package multi.data.dao.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 2 创建一个Spring配置类，其中spring.primary.datasource的路径参考yml文件的配置
 */

@Configuration
public class DataSourceConfig {
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.primary.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 数据库 : activity
     * @return
     */
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    //@Primary
    @ConfigurationProperties(prefix="spring.secondary.datasource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 数据库: quzhuanxiang_account
     * @return
     */
    @Bean(name = "tertiaryDataSource")
    @Qualifier("tertiaryDataSource")
    @ConfigurationProperties(prefix="spring.tertiary.datasource")
    public DataSource tertiaryDataSource() {
        return DataSourceBuilder.create().build();
    }

}
