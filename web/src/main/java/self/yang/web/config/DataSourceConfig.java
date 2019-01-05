package self.yang.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import self.yang.web.enums.DataSourceEnum;

import javax.sql.DataSource;
import java.util.HashMap;

@Slf4j
@Data
@Configuration
@ConfigurationProperties
public class DataSourceConfig {

    @Bean("mainDataSource")
    public DataSource mainDataSource(
            @Value("${spring.datasource.main.url}") String url,
            @Value("${spring.datasource.main.username}") String username,
            @Value("${spring.datasource.main.password}") String password,
            @Value("${spring.datasource.main.driverClassName}") String driverClassName,
            @Value("${spring.datasource.main.initialSize}") Integer initialSize,
            @Value("${spring.datasource.main.maxActive}") Integer maxActive,
            @Value("${spring.datasource.main.minIdle}") Integer minIdle,
            @Value("${spring.datasource.main.poolPreparedStatements}") Boolean poolPreparedStatements
    ) {
        return getDataSource(url, username, password, driverClassName, initialSize, maxActive, minIdle, poolPreparedStatements);
    }

    @Bean("slaveDataSource")
    public DataSource slaveDataSource(
            @Value("${spring.datasource.slave.url}") String url,
            @Value("${spring.datasource.slave.username}") String username,
            @Value("${spring.datasource.slave.password}") String password,
            @Value("${spring.datasource.slave.driverClassName}") String driverClassName,
            @Value("${spring.datasource.slave.initialSize}") Integer initialSize,
            @Value("${spring.datasource.slave.maxActive}") Integer maxActive,
            @Value("${spring.datasource.slave.minIdle}") Integer minIdle,
            @Value("${spring.datasource.slave.poolPreparedStatements}") Boolean poolPreparedStatements
    ) {
        return getDataSource(url, username, password, driverClassName, initialSize, maxActive, minIdle, poolPreparedStatements);
    }

    @Bean("mainTransactionManager")
    public DataSourceTransactionManager mainTransactionManager(@Qualifier("mainDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource(
            @Qualifier("mainDataSource") DataSource mainDataSource,
            @Qualifier("slaveDataSource") DataSource slaveDataSource
    ) {
        DynamicDataSourceConfig dynamicDataSource = new DynamicDataSourceConfig();

        dynamicDataSource.setDefaultTargetDataSource(mainDataSource);

        HashMap<Object, Object> dataSourceHashMap = new HashMap<>();

        dataSourceHashMap.put(DataSourceEnum.MAIN.name(), mainDataSource);
        dataSourceHashMap.put(DataSourceEnum.SLAVE.name(), slaveDataSource);

        dynamicDataSource.setTargetDataSources(dataSourceHashMap);

        return dynamicDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dataSource) {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);

        try {
            return sessionFactory.getObject();
        } catch (Exception e) {
            log.error("create sql session factory happen exception, error message is ", e);

            return null;
        }
    }

    private DataSource getDataSource(
            String url,
            String username,
            String password,
            String driverClassName,
            Integer initialSize,
            Integer maxActive,
            Integer minIdle,
            Boolean poolPreparedStatements
    ) {
        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);

        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);

        return druidDataSource;
    }
}
