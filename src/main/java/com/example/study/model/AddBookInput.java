package com.example.study.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddBookInput {
    @NotBlank
    @Size(min = 2, max = 20,
            message = "책제목은 최소 2자, 최대 20자로 작성해주세요")
    private String bookName;
    @Range(min = 100, max = 100000,
            message = "책가격은 최소 100원, 최대 100,000로 기입해주세요")
    private long bookPrice;
}