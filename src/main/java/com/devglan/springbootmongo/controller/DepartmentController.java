package com.devglan.springbootmongo.controller;

import com.devglan.springbootmongo.model.Department;
import com.devglan.springbootmongo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> listDepts(){
        return departmentRepository.findAll();
    }

    @PostMapping
    public Department createDept(@RequestBody Department department) {
        departmentRepository.save(department);
        return department;
    }

    @PutMapping("/{deptId}")
    public Department updateDept(@RequestBody Department department, @PathVariable String deptId) {
        department.setId(deptId);
        departmentRepository.save(department);
        return department;
    }

    @DeleteMapping("/{deptId}")
    public String deleteDept(@PathVariable String deptId) {
        departmentRepository.deleteById(deptId);
        return deptId;
    }

    @GetMapping("/{deptName}")
    public List<Department> findDeptByName(@PathVariable String deptName) {
        return departmentRepository.findDepartmentByName(deptName);
    }

    @GetMapping("{name}/emp")
    public Department listDept(@PathVariable String name){
        return departmentRepository.findDepartmentByEmployeeName(name);
    }
}
