package com.DaoImpl;

import org.springframework.stereotype.Repository;

import com.Dao.*;
import com.model.User;

@Repository 
public class  UserDoaImpl implements UserDao
{

	@Autowired 
	SessionFactory sessionFac;
	public void insertUser(User user)
	{
		
	}
	
		
	
}
