package com.example.seondday_project.Controller;

import com.example.seondday_project.Pojo.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tasks")
public class Controller {
    ArrayList<Task> tasks=new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Task>getTasks(){
        return tasks;

    }

    @PostMapping("/add")
    public String addTasks(@RequestBody Task task){
        tasks.add(task);
        return "tasks added";
    }

    @PutMapping("/update/{index}")
    public String UpdateTasks(@PathVariable int index,@RequestBody Task task){
        tasks.set(index,task);

        return"tasks updated";

    }

    @GetMapping("/delete/{index}")
    public String daletTask(@PathVariable int index){
        tasks.remove(index);
        return "tasks deleted";
    }
    @GetMapping("/changeStatue/{index}")
    public String changeStatue(@PathVariable int index,@RequestBody Task task){
        if(task.getStatus()=="not don")
            task.setStatus("done");
        tasks.set(index,task);
        return "status updated";
    }
    @GetMapping("/search/{title}")
    public ArrayList<Task> search(@PathVariable String title){
        return tasks;
    }

}
