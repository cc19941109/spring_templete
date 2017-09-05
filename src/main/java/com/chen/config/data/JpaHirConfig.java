package com.chen.config.data;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories("com.chen.repository")
public class JpaHirConfig {

	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jpadb";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PASSWORD = "admin";
	// private static final String PACKAGES_TO_SCAN = "com.chen";
	// private static final String HIBERNATE_DIALECT =
	// "org.hibernate.dialect.MySQL5Dialect";
	// private static final String HIBERNATE_SHOW_SQL = "true";

	

	@Bean
	public JpaTransactionManager transactionManager() {
		return new JpaTransactionManager(); // does this need an emf???
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
