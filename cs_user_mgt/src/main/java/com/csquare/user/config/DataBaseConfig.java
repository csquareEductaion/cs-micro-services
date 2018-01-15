package com.csquare.user.config;

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

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://csquaredbmumbai.c6vepbb3vtpo.ap-south-1.rds.amazonaws.com:5432/csquareDBMumbai");
        dataSource.setUsername("csquare");
        dataSource.setPassword("Csquare123");
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
        entityManager.setPackagesToScan("com.csquare.user.model");
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
        // properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
        return properties;
    }

    /**
     * Method to provide region on which application is hosted.
     * Every system must set CodeXRegion as parameter with value like eu-west-1.amazonaws.com
     *
     * @param key - The String
     * @return value - The String
     */
    // public String getProperty(String key) {
    //
    // if (!propertyInitialized) {
    // loadProperty();
    // }
    //
    // String value = prop.getProperty(key);
    // return value;
    // }

    // /**
    // * loadProperty - the method
    // *
    // * @throws RuntimeException - the RuntimeException
    // */
    // private void loadProperty() throws RuntimeException {
    //
    // propertyInitialized = true;
    // InputStream input = null;
    // try {
    // String env = SystemUtil.getDeploymentEnv();
    // String appConfigContainer = SystemUtil.getEnv(SystemKey.CODEX_APPCONFIG_CONTAINER);
    // if (StringUtil.equals("PROD", env) || StringUtil.equals("UAT", env)) {
    // input = AzureStorageUtil.INSTANCE.getObject(appConfigContainer, "codex-projectmgt-app.properties");
    // } else {
    // input = new FileInputStream("/codex-app-config/codex-projectmgt-app.properties");
    // }
    // prop.load(input);
    // } catch (IOException e) {
    // throw new RuntimeException(e);
    // } finally {
    // CommonUtil.close(input);
    // }
    // }
}