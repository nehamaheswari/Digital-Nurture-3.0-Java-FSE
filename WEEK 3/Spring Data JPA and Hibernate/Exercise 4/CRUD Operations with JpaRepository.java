//Create
public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
}

public Department createDepartment(Department department) {
    return departmentRepository.save(department);
}
//Read
public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id).orElse(null);
}

public Department getDepartmentById(Long id) {
    return departmentRepository.findById(id).orElse(null);
}

public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
}

public List<Department> getAllDepartments() {
    return departmentRepository.findAll();
}
//Update
public Employee updateEmployee(Long id, Employee employeeDetails) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    employee.setName(employeeDetails.getName());
    employee.setDepartment(employeeDetails.getDepartment());
    return employeeRepository.save(employee);
}

public Department updateDepartment(Long id, Department departmentDetails) {
    Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
    department.setName(departmentDetails.getName());
    return departmentRepository.save(department);
}
//Delete
public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
}

public void deleteDepartment(Long id) {
    departmentRepository.deleteById(id);
}
