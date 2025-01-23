package com.booleanuk.api.employee;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private EmployeeRepository employees;

    public EmployeeController() throws SQLException {
        this.employees = new EmployeeRepository();
    }

    @PostMapping
    public Employee createOne(@RequestBody Employee employee) throws SQLException {
        return this.employees.add(employee);
    }

    @GetMapping
    public List<Employee> getAll() throws SQLException {
        return employees.getAll();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable(name="id") int id) throws SQLException {
        return employees.getOne(id);
    }

    @PutMapping("/{id}")
    public Employee getOne(@PathVariable(name="id") int id, @RequestBody Employee employee) throws SQLException {
        return employees.updateOne(id, employee);
    }

    @DeleteMapping("/{id}")
    public Employee deleteOne(@PathVariable(name="id") int id) throws SQLException {
        return employees.deleteOne(id);
    }
}
