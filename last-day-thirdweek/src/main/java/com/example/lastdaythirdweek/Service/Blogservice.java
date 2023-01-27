package com.example.lastdaythirdweek.Service;

import com.example.lastdaythirdweek.Pojo.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Blogservice {

    ArrayList<Blog> blogs=new ArrayList<>();

    public ArrayList<Blog> getBlogs(){
        return blogs;
    }

    public void addblog(Blog blog){
        blogs.add(blog);
    }


    public boolean updateblog(int id,Blog blog){
        for (int i = 0; i < blogs.size(); i++) {
            if(blogs.get(i).getId()==id){
                blogs.set(i,blog);
                return true;
            }

        }
        return false;
    }

    public boolean deletblog(int id){
        for (int i = 0; i < blogs.size(); i++) {
            if(blogs.get(i).getId()==id){
                blogs.remove(i);
                return true;
            }

        }
        return false;
    }
}
