package pradooguilherme.springboot_coffee_api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pradooguilherme.springboot_coffee_api.model.Employee;
import pradooguilherme.springboot_coffee_api.model.EmployeeRepository;
import pradooguilherme.springboot_coffee_api.service.EmployeeService;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public void insert(Employee employee) {
        employeeRepository.save(employee);
    }


    @Override
    public void update(Long id, Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isPresent()) {
            employeeRepository.save(employee);
        }
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
