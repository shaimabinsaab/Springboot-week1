package com.example.lastdaythirdweek.Pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Blog {
    @NotNull(message = "id must be not null")
    private int id;
    @NotEmpty(message = "title should be here")
    private String title;
    @NotEmpty(message = "boddy should be here")
    private String body;
}
