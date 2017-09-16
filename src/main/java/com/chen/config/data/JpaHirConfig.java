package com.chen.config.data;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.chen.repository")
// @EnableTransactionManagement
public class JpaHirConfig {

	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jpadb";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PASSWORD = "123456";
	// private static final String PACKAGES_TO_SCAN = "com.chen";
	// private static final String HIBERNATE_DIALECT =
	// "org.hibernate.dialect.MySQL5Dialect";
	// private static final String HIBERNATE_SHOW_SQL = "true";

	@Bean
	public PlatformTransactionManager transactionManager() {

		final PlatformTransactionManager transactionManager;

		final JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory(dataSource(),jpaVendorAdapter()).getObject());
		jpaTransactionManager.setDataSource(dataSource());
		transactionManager = jpaTransactionManager;
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(DATABASE_DRIVER);
		source.setUrl(DATABASE_URL);
		source.setUsername(DATABASE_USER);
		source.setPassword(DATABASE_PASSWORD);
		return source;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");

		return adapter;

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("com.chen.entity");
		return emfb;

	}

}
