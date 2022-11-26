package com.validationAndException.validationAndException.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "please enter your name")
    private String name;

    @Email(message = "please enter correct email format")
    private String email;

    @Pattern(message = "please enter valid mobile number", regexp = "^\\d{10}$")
    private String mobile;

    @NotBlank(message = "please enter your gender")
    private String gender;

    @NotNull(message = "please enter your age")
    @Min(18)
    private int age;

    @NotBlank(message = "please enter your nationality")
    private String nationality;
}
