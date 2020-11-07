package com.niit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.StudentSkill;

@Repository(value = "sdao")
@Transactional
public class StudentDaolmpl implements StudentDao {
	
    @Autowired
    SessionFactory sessionFactory;
    
	@Override
	public List<StudentSkill> getAllStudents() {
		
		Session sess=sessionFactory.getCurrentSession();
		List<StudentSkill> data= new ArrayList<StudentSkill>();
		data= sess.createQuery("from StudentSkill").list();
		return data;
	
	}
	@Override
	public void create(StudentSkill ob) {
		Session sess = sessionFactory.getCurrentSession();
		sess.beginTransaction();
		sess.save(ob);
		sess.getTransaction().commit();
	}

	@Override
	public void Update(StudentSkill ob) {
		try {
		Session sess=sessionFactory.getCurrentSession();
		sess.beginTransaction();
		sess.update(ob);	
		sess.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}

	@Override
	public StudentSkill getStudentById(int id) {
		Session sess=sessionFactory.getCurrentSession();
		StudentSkill ob= sess.get(StudentSkill.class, id);
		return ob;
	}

	@Override
	public void delete(int id) 
	{
		try {

		Session sess=sessionFactory.getCurrentSession();
		StudentSkill ob= sess.get(StudentSkill.class, id);
		sess.beginTransaction();
		sess.delete(ob);
		sess.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
  
}
