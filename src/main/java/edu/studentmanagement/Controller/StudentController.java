package edu.studentmanagement.controller;

import edu.studentmanagement.dto.request.StudentRequestDto;
import edu.studentmanagement.dto.response.ApiResponseDto;
import edu.studentmanagement.dto.response.PageResponse;
import edu.studentmanagement.dto.response.StudentResponseDto;
import edu.studentmanagement.Service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<StudentResponseDto>> saveStudent(
            @Valid @RequestBody StudentRequestDto studentRequestDto,
            HttpServletRequest request) {

        StudentResponseDto student =
                studentService.saveStudent(studentRequestDto);

        return ResponseEntity.ok(
                ApiResponseDto.success(
                        "Student created successfully",
                        200,
                        student,
                        request.getRequestURI()
                )
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<PageResponse<StudentResponseDto>>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest request) {

        PageResponse<StudentResponseDto> students =
                studentService.getAllStudents(page, size);

        return ResponseEntity.ok(
                ApiResponseDto.success(
                        "Students fetched successfully",
                        200,
                        students,
                        request.getRequestURI()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<StudentResponseDto>> getStudentById(
            @PathVariable Long id,
            HttpServletRequest request) {

        StudentResponseDto student =
                studentService.getStudentById(id);

        return ResponseEntity.ok(
                ApiResponseDto.success(
                        "Student fetched successfully",
                        200,
                        student,
                        request.getRequestURI()
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<StudentResponseDto>> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDto studentRequestDto,
            HttpServletRequest request) {

        StudentResponseDto student =
                studentService.updateStudent(id, studentRequestDto);

        return ResponseEntity.ok(
                ApiResponseDto.success(
                        "Student updated successfully",
                        200,
                        student,
                        request.getRequestURI()
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> deleteStudent(
            @PathVariable Long id,
            HttpServletRequest request) {

        studentService.deleteStudent(id);

        return ResponseEntity.ok(
                ApiResponseDto.success(
                        "Student deleted successfully",
                        200,
                        null,
                        request.getRequestURI()
                )
        );
    }
}