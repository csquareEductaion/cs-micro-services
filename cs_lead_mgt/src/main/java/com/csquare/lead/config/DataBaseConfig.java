package com.csquare.lead.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.csquare.framework.util.PropertyUtil;


/**
 * Custom class for DataBaseConfig
 *
 * @copyright Copyright (c) CodeX. All Right Reserved.
 * @author CodeX
 */

@Configuration
@EnableTransactionManagement
public class DataBaseConfig {

    private static final Logger LOGGER = Logger.getLogger(DataBaseConfig.class);
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_INITIALSIZE = "db.initialsize";
    private static final String PROPERTY_NAME_DATABASE_MAXIDLE = "db.maxidle";
    private static final String PROPERTY_NAME_DATABASE_MAXACTIVE = "db.maxactive";
    private static final String PROPERTY_NAME_DATABASE_MAXWAIT = "db.maxwait";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    private final Properties prop = new Properties();
    private boolean propertyInitialized = false;

    /**
     * DataSource - the class
     *
     * @return dataSource- the DataSource
     */
    @Bean
    public DataSource dataSource() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(PropertyUtil.LEAD_MGT.getProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(PropertyUtil.LEAD_MGT.getProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(PropertyUtil.LEAD_MGT.getProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(PropertyUtil.LEAD_MGT.getProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        dataSource.setInitialSize(5);
        dataSource.setMaxIdle(5);
        dataSource.setMaxActive(15);
        dataSource.setMaxWait(20000);
        dataSource.setDefaultTransactionIsolation(TransactionDefinition.ISOLATION_READ_COMMITTED);
        return dataSource;
    }

    /**
     * @return sessionFactoryBean - the LocalSessionFactoryBean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LOGGER.info("Starting DataBaseConfig.entityManagerFactory");
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPersistenceUnitName("PM");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(vendorAdapter);
        entityManager.setJpaProperties(hibProperties());
        entityManager.setPackagesToScan("com.csquare.lead.model");
        // EntityManagerFactory emf = theEntityManager.getNativeEntityManagerFactory();
        LOGGER.info("Finishing DataBaseConfig.entityManagerFactory");
        return entityManager;

    }

    /**
     * @return transactionManager - the HibernateTransactionManager
     */
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        // transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    // --------------------------------------------------------------------------------------------------------------------------------
    /**
     * @return properties - the Properties
     */
    private Properties hibProperties() {

        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, "true");
        properties.put("hibernate.jdbc.batch_size", "25");
        properties.put("hibernate.order_inserts", "true");
        properties.put("hibernate.order_updates", "true");

        // properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
        return properties;
    }
}