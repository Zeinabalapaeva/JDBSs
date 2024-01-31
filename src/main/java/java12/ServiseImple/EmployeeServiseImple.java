package java12.ServiseImple;

import java12.Servise.EmployeServise;
import java12.dao.EmployeDao;
import java12.imple.EmployeDaoImple;
import java12.model.Employee;
import java12.model.Job;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmployeeServiseImple implements EmployeServise {


    EmployeDao employeDao= new EmployeDaoImple();



    @Override
    public boolean createEmployee() {
      return    employeDao.createEmployee();

    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        employeDao.addEmployee(employee);

    }

    @Override
    public void dropTable() {
        employeDao.dropTable();

    }

    @Override
    public void cleanTable() {
        employeDao.cleanTable();

    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        employeDao.updateEmployee(id, employee);

    }

    @Override
    public List<Employee> getAllEmployees() {

        return employeDao.getAllEmployees();
    }

    @Override
    public Employee findByEmail(String email) {

        return employeDao.findByEmail(email);
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {

        return employeDao.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {

        return employeDao.getEmployeeByPosition(position);
    }
}
