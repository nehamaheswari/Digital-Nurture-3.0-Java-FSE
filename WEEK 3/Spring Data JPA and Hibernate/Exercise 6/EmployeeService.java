import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getEmployeesByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findByName(name, pageable);
    }

    public Page<Employee> getEmployeesByDepartment(String department, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findByDepartment(department, pageable);
    }

    public Page<Employee> getEmployeesByNameContaining(String substring, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findByNameContaining(substring, pageable);
    }

    public Page<Employee> getEmployeesByNameStartingWith(String prefix, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findByNameStartingWith(prefix, pageable);
    }
}
