package com.example.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

@Repository
public class EmployeeDAO {
	
//	@Autowired
//	EmployeeRepository employeeRepository;
	
	
	// save an Employee 	
	// get list of the employee 	
	// get an employee by id
	// delete an employee 
	
	
	private static final Map<String, Employee> empMap = new HashMap<String, Employee>();
	 
    static {
        initEmps();
    }
 // employees data is inserted which is POST HTTP method
    private static void initEmps() {
        Employee emp1 = new Employee("E01", "Smith", "Clerk");
        Employee emp2 = new Employee("E02", "Allen", "Salesman");
        Employee emp3 = new Employee("E03", "Jones", "Manager");
        Employee emp4 = new Employee("E04", "Semeneh", "Software Developer");
 
        empMap.put(emp1.getEmpNo(), emp1);
        empMap.put(emp2.getEmpNo(), emp2);
        empMap.put(emp3.getEmpNo(), emp3);
        empMap.put(emp4.getEmpNo(), emp4);
    }
    
 
    public Employee getEmployee(String empNo) {
        return empMap.get(empNo);
    }
 
    // add a single employee 
    public Employee addEmployee(Employee emp) {
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }
 
    // PUT or update an employee 
    public Employee updateEmployee(Employee emp) {
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }
 
    // delete an employee with specific id number 
    public void deleteEmployee(String empNo) {
        empMap.remove(empNo);
    }
 
    // to see the list of the employee 
    public List<Employee> getAllEmployees() {
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }

}
