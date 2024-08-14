import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findByName(String name, Pageable pageable);

    Page<Employee> findByDepartment(String department, Pageable pageable);

    Page<Employee> findByNameContaining(String substring, Pageable pageable);

    Page<Employee> findByNameStartingWith(String prefix, Pageable pageable);
}
