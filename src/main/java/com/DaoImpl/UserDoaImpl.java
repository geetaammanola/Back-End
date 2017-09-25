package com.DaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.Dao.*;
import com.model.User;

@Repository 
public class  UserDoaImpl implements UserDao
{

	@Autowired 
	SessionFactory sessionFac;
	public void insertUser(User user)
	{
		Session session=sessionFac.openSession();
		session.beginTransaction();
		session.persist(user);
        session.getTransaction().commit();
        
	}
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}	
}
