package com.disturbia.springlearning.controller;


import com.disturbia.springlearning.entity.Employee;
import com.disturbia.springlearning.service.EmployeeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/check")
    public ResponseEntity healthCheck(){
        return ResponseEntity.ok("employee is up");
    }

    @PostMapping("/")
    public ResponseEntity Create(@RequestBody Employee request){
        return ResponseEntity.ok(employeeService.create(request));
    }

    @GetMapping("/find")
    public ResponseEntity Find(@RequestBody Employee request){
        return ResponseEntity.ok(employeeService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity FindById(@PathVariable long id)throws NotFoundException {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping("/split/{id}")
    public ResponseEntity FindByIdSplit(@PathVariable long id)throws NotFoundException {
        return ResponseEntity.ok(employeeService.findByIdSplit(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable long id,@RequestBody Employee request)throws NotFoundException {
        return ResponseEntity.ok(employeeService.updateById(id,request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id)throws NotFoundException {
        employeeService.deleteId(id);
        return ResponseEntity.ok().build();
    }

}
