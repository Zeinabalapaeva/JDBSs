package java12;

import java12.Servise.EmployeServise;
import java12.Servise.JobServise;
import java12.ServiseImple.EmployeeServiseImple;
import java12.ServiseImple.JobSErviseImple;
import java12.dao.EmployeDao;
import java12.model.Employee;
import java12.model.Job;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        EmployeServise employeServise = new EmployeeServiseImple();
        JobServise jobServise = new JobSErviseImple();
       // jobServise.createJobTable();




       employeServise.createEmployee();



     employeServise.addEmployee(new Employee(  "Toi","toi",12,"@gmkg"));
       jobServise.addJob(new Job("Instructor", "IT", "backend", 5, 1));
        employeServise.dropTable();
     employeServise.cleanTable();
      System.out.println(employeServise.getEmployeeById(2L));
       System.out.println(employeServise.getAllEmployees());
       System.out.println(jobServise.getJobByEmployeeId(1L));
        System.out.println(jobServise.getJobById(1L));
        System.out.println(employeServise.getAllEmployees());
        System.out.println(employeServise.getEmployeeByPosition("mentor"));
       System.out.println(jobServise.getJobById(2L));
      System.out.println(jobServise.sortByExperience("asc"));
       System.out.println(jobServise.sortByExperience("desc"));

        employeServise.updateEmployee(5L, new Employee("Zepa", "ak",22,"@gma"));
//
//        System.out.println(employeServise.getAllEmployees());
//
//        System.out.println(employeServise.findByEmail("nur@gmail.com"));



    }
}
