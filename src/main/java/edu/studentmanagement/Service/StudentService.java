package edu.studentmanagement.Service;

import java.util.List;
import edu.studentmanagement.dto.request.StudentRequestDto;
import edu.studentmanagement.dto.response.PageResponse;
import edu.studentmanagement.dto.response.StudentResponseDto;

public interface StudentService {

    StudentResponseDto saveStudent(StudentRequestDto studentRequestDto);

    PageResponse<StudentResponseDto> getAllStudents(int page, int size);

    StudentResponseDto getStudentById(Long id);

    StudentResponseDto updateStudent(Long id, StudentRequestDto studentRequestDto);

    void deleteStudent(Long id);
}