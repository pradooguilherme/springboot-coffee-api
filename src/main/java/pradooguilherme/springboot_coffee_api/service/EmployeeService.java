package pradooguilherme.springboot_coffee_api.service;

import pradooguilherme.springboot_coffee_api.model.Employee;

public interface EmployeeService {
    Iterable<Employee> findAll();
    Employee findById(Long id);
    void insert(Employee employee);
    void update(Long id, Employee employee);
    void delete(Long id);
}
