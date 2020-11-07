package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.StudentDao;
import com.niit.model.StudentSkill;

@RestController
public class StudentController {
	
	
	@Autowired
	StudentDao sdao;
	
	
	@GetMapping("/allstudent")
	public ResponseEntity<List<StudentSkill>> allStudents()
	{
		List<StudentSkill> allstu;
		allstu = sdao.getAllStudents();
		if(allstu==null)
			return new ResponseEntity<List<StudentSkill>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<StudentSkill>>(allstu,HttpStatus.OK);
	}
	//@PostMapping("/addStudent")
		@RequestMapping(value="/addStudent",method=RequestMethod.POST)
		public ResponseEntity<StudentSkill> saveStudent (@RequestBody StudentSkill ob)
		{
			if(ob!= null)
			{
			sdao.create(ob);
			return new ResponseEntity<StudentSkill>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<StudentSkill>(HttpStatus.NO_CONTENT);
		}
	
	@RequestMapping(value="/updateStudent",method=RequestMethod.PUT)
	public ResponseEntity<StudentSkill> Update(@RequestBody StudentSkill ob)
	{
		if(ob!= null)
		{
			sdao.Update(ob);
			return new ResponseEntity<StudentSkill>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<StudentSkill>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value="/getStudentById/{id}")
	public ResponseEntity<StudentSkill> getStudentById(@PathVariable int id)
	{
		StudentSkill ob=sdao.getStudentById(id);
		if(ob!= null)
		{
		return new ResponseEntity<StudentSkill>(ob,HttpStatus.OK);
		}
		else
			return new ResponseEntity<StudentSkill>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping (value="/deleteStudent/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<StudentSkill> deleteStudent(@PathVariable int id)
	{
		sdao.delete(id);
		return new ResponseEntity<StudentSkill>(HttpStatus.OK);
	}

}
