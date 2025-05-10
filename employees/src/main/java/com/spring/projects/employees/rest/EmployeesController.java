// package com.spring.projects.employees.rest;

// import java.util.List;
// import java.util.Map;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.node.ObjectNode;
// import com.spring.projects.employees.entity.Employees;
// import
// com.spring.projects.employees.exceptionhandling.EmployeeRecordNotFoundException;
// import
// com.spring.projects.employees.exceptionhandling.IdCannotChangeException;
// import com.spring.projects.employees.service.EmployeeService;

// @RestController
// @RequestMapping("/projects")
// public class EmployeesController {

// private EmployeeService employeesService;
// private ObjectMapper objectMapper;

// EmployeesController(EmployeeService theEs, ObjectMapper theOm) {
// employeesService = theEs;
// objectMapper = theOm;
// }

// @GetMapping("/employees")
// List<Employees> getAll() {
// return employeesService.findAll();
// }

// @GetMapping("/employees/{employeesId}")
// Employees findById(@PathVariable int employeesId) {
// Employees employees = employeesService.findById(employeesId);
// if (employees == null) {
// throw new EmployeeRecordNotFoundException(
// "Employee not found with id -" + employeesId + " . Contact Admin");
// } else {
// return employees;
// }
// }

// @PostMapping("/employees")
// public Employees addEmployees(@RequestBody Employees employees) {
// employees.setId(0);
// return employeesService.save(employees);
// }

// @PutMapping("/employees")
// Employees updateEmployees(@RequestBody Employees employees) {
// return employeesService.save(employees);

// }

// @PatchMapping("/employees/{employeesId}")
// Employees partialUpdate(@PathVariable int employeesId, @RequestBody
// Map<String, Object> patchPayload) {
// Employees tempEmployees = employeesService.findById(employeesId);
// if (tempEmployees == null) {
// throw new EmployeeRecordNotFoundException(
// "Employee Record not Found with Id - " + employeesId + " . Contact Admin");
// }
// if (patchPayload.containsKey("id")) {
// throw new IdCannotChangeException("Id change is forbidden. Contact Admin");
// }
// Employees patchedEmployee = apply(patchPayload, tempEmployees);
// return employeesService.save(patchedEmployee);
// }

// private Employees apply(Map<String, Object> patchPayload, Employees
// tempEmployees) {
// ObjectNode employeesNode = objectMapper.convertValue(tempEmployees,
// ObjectNode.class);
// ObjectNode patchNode = objectMapper.convertValue(patchPayload,
// ObjectNode.class);
// employeesNode.setAll(patchNode);
// return objectMapper.convertValue(employeesNode, Employees.class);
// }

// @DeleteMapping("/employees/{employeesId}")
// String deleteEmployees(@PathVariable int employeesId) {
// Employees employees = employeesService.findById(employeesId);
// if (employees == null) {
// throw new EmployeeRecordNotFoundException(
// "Employee not found with id -" + employeesId + " . Contact Admin");
// } else {
// return employeesService.deleteById(employeesId);
// }

// }
// }
