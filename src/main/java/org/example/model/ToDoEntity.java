package org.example.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "mytodotable")
//sql에 해당 테이블로 저장한다. DB는 application.properties확인할것
//카멜캐이스로 쓰면, 스네이크로 바꿔주는 듯. 그냥 전체 소문자하자.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 1식 증가
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, name="toDoOrder")
    private Long order;

    @Column(nullable = false)
    private Boolean completed;
}

// 클래스랑 디비랑 매핑해줘야함.