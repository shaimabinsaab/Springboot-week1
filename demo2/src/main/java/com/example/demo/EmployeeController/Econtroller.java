package com.example.demo.EmployeeController;

import com.example.demo.Api;
import com.example.demo.Pojo.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")
public class Econtroller {

    ArrayList<Employee> employees=new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    @PostMapping("/add")
    public ResponseEntity addemployee(@Valid @RequestBody Employee employee, Errors errors) {
        if (errors.hasErrors()) {
            String msg = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(msg));
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new Api("employee added"));
    }
    @PutMapping("/update/{index}")
    public Api updateemplyee(@Valid @RequestBody Employee employee,@PathVariable int index){
        employees.set(index,employee);
        return new Api("emplyee updated");
    }

    @DeleteMapping("/delete/{index}")
    public Api deleteemployee(@PathVariable int index){
        employees.remove(index);
        return new Api("employee deleted");
    }

    @PutMapping("/checkleave/{index}")
    public ResponseEntity check(@Valid @PathVariable int index,Employee employee,Errors errors) {
        if (employee.isOnleave() == true) {
            if (errors.hasErrors()) {
                String msg = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new Api(msg));
            }

            } else if (employee.getAnnualLeave() == 0) {
                if (errors.hasErrors()) {
                    String msg = errors.getFieldError().getDefaultMessage();
                    return ResponseEntity.status(400).body(new Api(msg));
                }
        }
                employee.setOnleave(true);
                employee.setAnnualLeave(employee.getAnnualLeave() - 1);

                employees.set(index, employee);
                return ResponseEntity.status(200).body(new Api("check completed"));


            }


        }



