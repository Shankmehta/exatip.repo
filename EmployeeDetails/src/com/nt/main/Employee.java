package com.nt.main;

public class Employee 
{
    private int id;
    private String name;
    private String department;
    private double salary;
    private int experience;
    
    public Employee(int id,String name,String department,double salary,int experience)
    {
    	this.id=id;
    	this.name=name;
    	this.department=department;
    	this.salary=salary;
    	this.experience=experience;
    }
    public int getId()
    {
    	return id;
    }
    public String getName()
    {
    	return name;
    }
    public String getDept()
    {
    	return department;
    }
    public double getSalary()
    {
    	return salary;
    }
    public int getExp()
    {
    	return experience;
    }
    @Override
    public  String toString()
    {
    	return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                '}';
    }
}
