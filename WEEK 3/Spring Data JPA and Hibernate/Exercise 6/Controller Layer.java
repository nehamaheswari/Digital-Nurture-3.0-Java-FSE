@GetMapping("/searchByName")
public Page<Employee> searchByName(
        @RequestParam String name, 
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size, 
        @RequestParam(defaultValue = "name") String sortBy, 
        @RequestParam(defaultValue = "asc") String sortDirection) {
    return employeeService.getEmployeesByName(name, page, size, sortBy, sortDirection);
}
