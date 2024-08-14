import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.name AS name, e.department AS department FROM Employee e WHERE e.id = :id")
    EmployeeProjection findEmployeeById(Long id);
}
