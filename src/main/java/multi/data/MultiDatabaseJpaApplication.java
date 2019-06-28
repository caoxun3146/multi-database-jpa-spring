package multi.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MultiDatabaseJpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(MultiDatabaseJpaApplication.class, args);

    }

}
