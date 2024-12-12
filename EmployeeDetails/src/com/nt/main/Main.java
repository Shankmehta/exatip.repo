package com.nt.main;
import java.util.ArrayList;

import java.util.*;
import java.util.stream.Collectors;
import com.nt.main.Employee;
public class Main {

	public static void main(String[] args)
	{
		List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000, 4));
        employees.add(new Employee(102, "Bob", "IT", 60000, 6));
        employees.add(new Employee(103, "Carol", "HR", 55000, 5));
        employees.add(new Employee(104, "David", "IT", 62000, 8));
        employees.add(new Employee(105, "Eva", "Finance", 70000, 7));

  
//    System.out.println(employees);
        
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.getName().startsWith("B"))
                .collect(Collectors.toList());
        filteredEmployees.forEach(System.out::println);
        
//        employees.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting())).entrySet().stream().forEach(System.out::println);
        
//        Map<String, List<Employee>> groupedByAge = 
//        		employees.stream().collect(Collectors.groupingBy(Employee::getDept)); 
//        System.out.println(groupedByAge);
        
//        Map<String, Long> countByDept = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
//        System.out.println(countByDept);
        
//        double average = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
//        System.out.println(average);
        
        
//        Optional<Employee> min = employees.stream().max(Comparator.comparing(Employee::getSalary));
//        System.out.println(min);
        
//        Optional<Double> secondLargestSalary = employees.stream()
//                .map(Employee::getSalary) 
//                .distinct()              
//                .sorted(Comparator.reverseOrder()) 
//                .skip(1)                 
//                .findFirst();  
//        secondLargestSalary.ifPresentOrElse(
//                salary -> System.out.println("Second largest salary: " + salary),
//                () -> System.out.println("No second largest salary found")
//                 );
        
	}
}
