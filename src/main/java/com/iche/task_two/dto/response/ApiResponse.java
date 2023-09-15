package com.iche.task_two.dto.response;


import com.iche.task_two.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T>{
    private  String message;
    private String time;
    private T data;

    public ApiResponse(T data){
        this.message = getMessage();
        this.data =data;
        this.time = DateUtils.saveDate(LocalDateTime.now());
    }
}
