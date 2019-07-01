package multi.data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryTertiary",
        transactionManagerRef = "transactionManagerTertiary",
        basePackages = {"multi.data.dao.repo.tertiary"}) //设置Repository所在位置
public class TertiaryConfig {
    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("tertiaryDataSource")
    private DataSource tertiaryDataSource;

    @Autowired
    HibernateProperties hibernateProperties;

    @Bean(name = "entityManagerTertiary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryTertiary(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryTertiary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryTertiary(EntityManagerFactoryBuilder builder) {

        Map<String,Object> properties = hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),new HibernateSettings());

        return builder
                .dataSource(tertiaryDataSource)
                .packages("multi.data.dao.model.tertiary") //设置实体类所在位置
                .persistenceUnit("primaryPersistenceUnit")
                .properties(properties)
                .build();
    }


    @Bean(name = "transactionManagerTertiary")
    public PlatformTransactionManager transactionManagerTertiary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryTertiary(builder).getObject());
    }
}

