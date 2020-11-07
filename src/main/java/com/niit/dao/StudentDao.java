package com.niit.dao;

import java.util.List;

import com.niit.model.StudentSkill;

public interface StudentDao {
	
	public List<StudentSkill>getAllStudents();
	public void create(StudentSkill ob);
	public void Update(StudentSkill ob);
	public StudentSkill getStudentById(int id);
	public void delete(int id);

}
