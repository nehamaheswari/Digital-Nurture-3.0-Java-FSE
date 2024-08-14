import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Find employees by name
    List<Employee> findByName(String name);
    
    // Find employees by department
    List<Employee> findByDepartment(String department);
    
    // Find employees with names containing a specific substring
    List<Employee> findByNameContaining(String substring);
    
    // Find employees with names starting with a specific prefix
    List<Employee> findByNameStartingWith(String prefix);
}
