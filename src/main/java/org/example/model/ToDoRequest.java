package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoRequest {
    private String title;
    private Long order;
    private Boolean completed;
}

// update나 create할 때 온다.
// 요청하는 클라입장에서는, id나 url는 모르니 요청할 수 없다