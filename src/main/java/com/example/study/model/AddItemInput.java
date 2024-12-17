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
public class AddItemInput {
    @NotBlank(message = "상품 이름은 비어있을 수 없습니다.")
    private String name;
    @NotBlank(message = "상품 설명은 비어있을 수 없습니다.")
    private String description;
    @Range(min = 100, max = 10000000,
            message = "시작 가격은 최소 100, 최대 10000000로 입력해주세요")
    private int startingPrice;
}