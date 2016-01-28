package com.intuit.training;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/employee")
@Singleton
public class EmployeeResource {

	private TreeMap<Integer, Employee> employeeList=new TreeMap<>();
	public EmployeeResource() {
		super();
		// TODO Auto-generated constructor stub
		employeeList.put(101, new Employee(101, "Rakesh","Developer"));
		employeeList.put(102, new Employee(102, "Arjun","Accountant"));
		employeeList.put(103, new Employee(103, "Vijayan","Architect"));
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Employee> getAllEmployees()
	{
		List<Employee> list=new ArrayList<>(employeeList.values());
		return list;
	}
	
	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Employee findEmployee(@PathParam("id")int empId)
	{
		return employeeList.get(empId);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public String addEmployee(Employee e)
	{
		int nextId=employeeList.lastKey()+1;
		e.setId(nextId);
		employeeList.put(nextId, e);
		return "Employee with Id "+nextId+" successfully  added";
	}

	@Path("/{id}")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public Response updateEmployee(Employee e,@PathParam("id")int id) throws FileNotFoundException
	{
		
		Employee emp=employeeList.get(id);
		if(emp==null){
			/*Response response=Response.status(Status.BAD_REQUEST).entity("No such employee").build();
			throw new WebApplicationException(response);*/
			throw new FileNotFoundException("No such employee");
		}
		emp.setName(e.getName());
		emp.setDesignation(e.getDesignation());
		return Response.ok().entity("Employee with "+id+" successfully updated").build();
	}
	
	@Path("/{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String removeEmployee(@PathParam("id")int id)
	{
		employeeList.remove(id);
		return "Employee with "+id+" successfully removed";
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/multiple")
	public String addEmployees(List<Employee> employees)
	{
		String resp="";
		for(Employee employee:employees){
			resp+="\n"+addEmployee(employee);
		}
		return resp;
	}
	
	@Path("/throughForm")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getEmployeeDetails(@QueryParam("emp_id")@DefaultValue("101")int id)
	{
		String resp="<html><body>";
		Employee employee=employeeList.get(id);
		resp+="<b>Name: "+employee.getName();
		resp+="<br>Designation: "+employee.getDesignation();
		resp+="</b></body></html>";
		return resp;
	}
	
	@Path("/throughForm")
	@Produces(MediaType.TEXT_HTML)
	@POST
	public String addEmployee(@FormParam("emp_name")String empName,
			@FormParam("designation")String desgination)
	{
		Employee e=new Employee();
		e.setName(empName);
		e.setDesignation(desgination);
		String resp=addEmployee(e);
		return "<html><body>"+resp+"</body></html>";
	}
	
	
	@Path("/throughFormMap")
	@Produces(MediaType.TEXT_HTML)
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addEmployee(MultivaluedMap<String, String> parameters)
	{
		Employee e=new Employee();
		e.setName(parameters.get("emp_name").get(0));
		e.setDesignation(parameters.get("designation").get(0));
		String resp=addEmployee(e);
		return "<html><body>"+resp+"</body></html>";
	}
	
}



