package edu.studentmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String course;
    private Integer age;
    private String city;
    private Instant createdAt;
}
