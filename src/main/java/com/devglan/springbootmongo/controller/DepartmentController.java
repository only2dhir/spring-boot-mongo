package com.devglan.springbootmongo.controller;

import com.devglan.springbootmongo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/")
    public String get(){
        mongoTemplate.getDb();
        Department department = new Department();
        department.setName("ABC");
        mongoTemplate.save(department);
        mongoTemplate.getCollection("Department");
        return "gg";
    }
}
