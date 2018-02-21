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

        PropertyUtil LEAD_MGT = PropertyUtil.LEAD_MGT;

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(LEAD_MGT.getString(DataBase.DATABASE_DRIVER));
        dataSource.setUrl(LEAD_MGT.getString(DataBase.DATABASE_URL));
        dataSource.setUsername(LEAD_MGT.getString(DataBase.DATABASE_USERNAME));
        dataSource.setPassword(LEAD_MGT.getString(DataBase.DATABASE_PASSWORD));
        dataSource.setInitialSize(LEAD_MGT.getInteger(DataBase.DATABASE_INITIALSIZE));
        dataSource.setMaxIdle(LEAD_MGT.getInteger(DataBase.DATABASE_MAXIDLE));
        dataSource.setMaxActive(LEAD_MGT.getInteger(DataBase.DATABASE_MAXACTIVE));
        dataSource.setMaxWait(LEAD_MGT.getInteger(DataBase.DATABASE_MAXWAIT));
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
        properties.put(DataBase.HIBERNATE_DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(DataBase.HIBERNATE_SHOW_SQL, "true");
        properties.put("hibernate.jdbc.batch_size", "25");
        properties.put("hibernate.order_inserts", "true");
        properties.put("hibernate.order_updates", "true");

        // properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
        return properties;
    }
}