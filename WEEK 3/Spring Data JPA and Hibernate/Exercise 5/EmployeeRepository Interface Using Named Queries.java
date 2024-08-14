import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.NamedQuery;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    @Query(name = "Employee.findByName")
    List<Employee> findByName(String name);
    
    @Query(name = "Employee.findByDepartment")
    List<Employee> findByDepartment(String department);
}
