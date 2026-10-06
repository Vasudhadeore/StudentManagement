package edu.studentmanagement.mapper;

import edu.studentmanagement.entity.Student;
import org.springframework.stereotype.Component;
import edu.studentmanagement.dto.request.StudentRequestDto;
import edu.studentmanagement.dto.response.StudentResponseDto;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequestDto dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());
        student.setCourse(dto.getCourse());
        student.setAge(dto.getAge());
        student.setCity(dto.getCity());

        return student;
    }

    public StudentResponseDto toResponseDto(Student student) {

        StudentResponseDto dto = new StudentResponseDto();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setPhone(student.getPhone());
        dto.setCourse(student.getCourse());
        dto.setAge(student.getAge());
        dto.setCity(student.getCity());
        dto.setCreatedAt(student.getCreatedAt());

        return dto;
    }
}