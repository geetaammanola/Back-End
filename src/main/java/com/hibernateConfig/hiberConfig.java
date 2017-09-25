package com.hibernateConfig;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate.HibernateTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.hibernate5.HibernateTransactionManager;
import com.Dao.UserDao;
import com.model.*;
import com.DaoImpl.*;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.bean.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;


@Configuration
@EnableTransactionManagement
ComponentScan("com")


public class hiberConfig {
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2()
	{
		System.out.println("Hibernate initiated......");
		DriverManagerDataSource dt=new DriverManagerDataSource();
		dt.setDriverClassName("org.h2.Driver");
		dt.setUrl("jdbc:h2:~/test");
		dt.setUsername("sa");
		dt.setPassword("");
   System.out.println("Connection Establish ....");
   return dt;
   
	}
	
	private Properties getHiberProps()
	{
		Properties p = new Properties();
		p.put(" hibernate.dialect", " org.hibernate.dialect.H2Dialect");
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.hbm2ddl.auto", "update");
		return p;
		
	}
	
	@Autowired
	@Bean(name="UserDao")
    public UserDao getUserData(sessionFactory sessionFac)
	{
		return new UserDaoImpl(sessionFac);
		
}
	@Autowired
	@Bean(name="sessionFactory")
    public sessionFactory getSession(DataSource datasource) {
		LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(datasource);
		lsfb.addProperties(getHiberProps());
		lsfb.addAnnotatedClass(User.class);
		return lsfb.buildSessionFactory();	
		
}

	@Autowired
	@Bean(name="transactionManager")
public HibernateTransactionManager getTransaction(SessionFactory sessionFac)
{
		HibernateTransactionManager tm = new HibernateTransactionManager(sessionFac);
       return tm;
}


	



	
}
