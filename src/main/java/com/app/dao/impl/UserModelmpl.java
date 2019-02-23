package com.app.dao.impl;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserModelDao;
import com.app.model.UserModel;

@Repository
@Transactional
public class UserModelmpl implements IUserModelDao {

	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int addUserModel(UserModel usermodel) {
		return (int) ht.save(usermodel);
	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unused" })
	@Override
	public UserModel login(String name, String password) {
		Query query = ht.getSessionFactory().getCurrentSession().createQuery("from UserModel where userName= :userName and password= :password");
		query.setString("userName", name);
		query.setString("password",password);
		UserModel user = (UserModel) query.uniqueResult();
		return user;
	}

}
