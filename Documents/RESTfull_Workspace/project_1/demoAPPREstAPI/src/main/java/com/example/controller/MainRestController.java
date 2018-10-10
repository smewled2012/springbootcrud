package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

@RestController 
public class MainRestController {
	
// request the first mapping 
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example";  
	}
	
	//URL 
	
	@RequestMapping(value = "/employee", method= RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
	@ResponseBody
	public List<Employee> getEmployees(){
		List<Employee> list = employeeDAO.getAllEmployees();
		return list;
		
	}
	
	// access the employee by empNo
	 @RequestMapping(value = "/employee/{empNo}", //
	            method = RequestMethod.GET, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, //
	                    MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public Employee getEmployee(@PathVariable("empNo") String empNo) {
	        return employeeDAO.getEmployee(empNo);
	    }
	
	// POST or adding an employee 
	 
	  @RequestMapping(value = "/employee", //
	            method = RequestMethod.POST, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, //
	                    MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody	    
	    public Employee addEmployee(@RequestBody Employee emp) {
		  System.out.println("(Service Side ) Creating Employee: "+ emp.getEmpNo());
		  return employeeDAO.addEmployee(emp);
		  
	  }
	  
	  // updating a specific employyee with emp id 
	   @RequestMapping(value = "/employee", //
	            method = RequestMethod.PUT, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, //
	                    MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    
	    public Employee updateEmployee(@RequestBody Employee emp) {
		   System.out.println("(Service side) editing Employee: "+ emp.getEmpNo());
		   return employeeDAO.updateEmployee(emp);
	   }
	   
	   // Deleting a specific employee 
	   
	   @RequestMapping(value ="/employee/{empNo}", method = RequestMethod.DELETE,
			   produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
	   @ResponseBody   
	   public void deleteEmployee(@PathVariable("empNo") String empNo) {
		   System.out.println("(Service Side) Deleting employee: "+ empNo);
		   employeeDAO.deleteEmployee(empNo);
		   
	   }
	   
	  
	  
	  
	  

}
