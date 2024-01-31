package java12.Servise;

import java12.model.Employee;
import java12.model.Job;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeServise {
    boolean createEmployee();
    void addEmployee(Employee employee) throws SQLException;
    void dropTable();
    void cleanTable();
    void updateEmployee(Long id,Employee employee);
    List<Employee> getAllEmployees();
    Employee findByEmail(String email);
    Map<Employee, Job> getEmployeeById(Long employeeId);
    List<Employee> getEmployeeByPosition(String position);
}
