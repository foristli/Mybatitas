package org.test.mybat.learnbatitas;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.test.mybat.learnbatitas.Employee;

public class DBOperation {
	private String resource;
	private Reader reader;
	public DBOperation() {
	  this.resource="configuration.xml";
	  try {
		this.reader=Resources.getResourceAsReader(resource);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void selectUser()
	{

		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		try
		{
			
			Employee emp=null;
			emp=(Employee)session.selectOne("selectUser", 1);
			System.out.println(emp.toString());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	
	}
	
	public void insertEmployee()
	{
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		try
		{
			
			Employee emp=new Employee();
			emp.setName("tomcat");
			emp.setAge(34);
			emp.setSalary(34000);
			session.insert("testinsert", emp);
			System.out.println(emp.toString());
			session.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
}
