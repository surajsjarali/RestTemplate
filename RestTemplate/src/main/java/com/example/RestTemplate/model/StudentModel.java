package com.example.RestTemplate.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;


@Getter
@Setter
@Component
public class StudentModel {

    @PositiveOrZero
    int roll_no;
    @Min(value = 0)
    @Max(value = 100)
    int m1;
    @Min(value = 0)
    @Max(value = 100)
    int m2;
    @NotNull
    @Size(min=2, message="Name should have atleast 2 characters")
    String name;

    @Override
    public String toString() {
        return "StudentModel [roll_no=" + roll_no + ", m1=" + m1 + ", m2=" + m2 + ", name=" + name + "]";
    }

}

