package com.example.lastdaythirdweek.Controller;

import com.example.lastdaythirdweek.Pojo.Blog;
import com.example.lastdaythirdweek.Service.Blogservice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {

    private final Blogservice blogservice;

//another form of dependency injection
//    public BlogController(Blogservice blogservice) {
//        this.blogservice=blogservice;
//
//    }

    @GetMapping("/get")
    public ResponseEntity getBlog(){
        ArrayList<Blog> blogs=blogservice.getBlogs();

        return ResponseEntity.status(200).body(blogs);
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        blogservice.addblog(blog);
        return ResponseEntity.status(200).body("Blog added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateblog(@PathVariable int id,@Valid @RequestBody Blog blog,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated=blogservice.updateblog(id,blog);

        if(isupdated){
            return ResponseEntity.status(200).body("Blog updated");
        }

        return ResponseEntity.status(400).body("wrong id ");
    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deleteblog(@PathVariable int id){
        boolean isdeleted=blogservice.deletblog(id);

        if(isdeleted){
            return ResponseEntity.status(200).body("blog deleted");
        }
        return ResponseEntity.status(400).body("wrong id");

    }

}
