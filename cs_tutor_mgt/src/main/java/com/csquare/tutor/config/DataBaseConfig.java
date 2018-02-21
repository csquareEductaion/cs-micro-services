package com.csquare.tutor.config;

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

import com.csquare.framework.constant.DataBase;
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

    /**
     * DataSource - the class
     *
     * @return dataSource- the DataSource
     */
    @Bean
    public DataSource dataSource() {

        PropertyUtil TUTOR_MGT = PropertyUtil.TUTOR_MGT;
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(TUTOR_MGT.getString(DataBase.DATABASE_DRIVER));
        dataSource.setUrl(TUTOR_MGT.getString(DataBase.DATABASE_URL));
        dataSource.setUsername(TUTOR_MGT.getString(DataBase.DATABASE_USERNAME));
        dataSource.setPassword(TUTOR_MGT.getString(DataBase.DATABASE_PASSWORD));
        dataSource.setInitialSize(TUTOR_MGT.getInteger(DataBase.DATABASE_INITIALSIZE));
        dataSource.setMaxIdle(TUTOR_MGT.getInteger(DataBase.DATABASE_MAXIDLE));
        dataSource.setMaxActive(TUTOR_MGT.getInteger(DataBase.DATABASE_MAXACTIVE));
        dataSource.setMaxWait(TUTOR_MGT.getInteger(DataBase.DATABASE_MAXWAIT));
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
        entityManager.setPackagesToScan("com.csquare.tutor.model");
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

        PropertyUtil TUTOR_MGT = PropertyUtil.TUTOR_MGT;
        Properties properties = new Properties();
        properties.put("hibernate.dialect", TUTOR_MGT.getString(DataBase.HIBERNATE_DIALECT));
        properties.put("hibernate.show_sql", TUTOR_MGT.getString(DataBase.HIBERNATE_SHOW_SQL));
        properties.put("hibernate.jdbc.batch_size", "25");
        properties.put("hibernate.order_inserts", "true");
        properties.put("hibernate.order_updates", "true");
        return properties;
    }
}