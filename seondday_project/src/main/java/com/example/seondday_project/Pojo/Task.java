package com.example.seondday_project.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    public String id;
    public String title;
    public String descreption;
    public String status;
}
