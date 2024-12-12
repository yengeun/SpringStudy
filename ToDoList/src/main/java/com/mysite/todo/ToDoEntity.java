package com.mysite.todo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@Entity

public class ToDoEntity {
    @Id // 기본키로 설정한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 데이터를 저장할 때 해당 속성에 따로 값을
    // 셋팅하지 않아도 1씩 자동으로 증가
    // strategy는 고유 번호를 생성하는 옵션
    // GenerationType.IDENTITY는 해당 컬럼만의
    // 독립적인 시퀀스를 생성하여 번호를 증가시킬 때
    // 사용한다.
    private Integer id;

    @Column(length=200)
    // Column의 세부 설정을 위해 사용
    private String content;

    @Column(nullable = false)
    private Boolean completed;
}
