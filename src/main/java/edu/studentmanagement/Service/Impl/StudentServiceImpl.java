package edu.studentmanagement.Service.Impl;

import edu.studentmanagement.dto.request.StudentRequestDto;
import edu.studentmanagement.dto.response.PageResponse;
import edu.studentmanagement.dto.response.StudentResponseDto;
import edu.studentmanagement.entity.Student;
import edu.studentmanagement.exception.NotFoundException;
import edu.studentmanagement.mapper.StudentMapper;
import edu.studentmanagement.repository.StudentRepository;
import edu.studentmanagement.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponseDto saveStudent(StudentRequestDto studentRequestDto) {

        Student student = studentMapper.toEntity(studentRequestDto);

        Student savedStudent = studentRepository.save(student);

        return studentMapper.toResponseDto(savedStudent);
    }

    @Override
    public PageResponse<StudentResponseDto> getAllStudents(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Student> studentPage = studentRepository.findAll(pageable);

        Page<StudentResponseDto> responsePage = studentPage.map(
                studentMapper::toResponseDto
        );

        return PageResponse.of(responsePage);
    }

    @Override
    public StudentResponseDto getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(
                                "Student not found with id: " + id
                        )
                );

        return studentMapper.toResponseDto(student);
    }

    @Override
    public StudentResponseDto updateStudent(
            Long id,
            StudentRequestDto studentRequestDto) {

        Student existingStudent = studentRepository.findById(id)
                .orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(studentRequestDto.getName());
        existingStudent.setEmail(studentRequestDto.getEmail());
        existingStudent.setPhone(studentRequestDto.getPhone());
        existingStudent.setCourse(studentRequestDto.getCourse());
        existingStudent.setAge(studentRequestDto.getAge());
        existingStudent.setCity(studentRequestDto.getCity());

        Student updatedStudent = studentRepository.save(existingStudent);

        return studentMapper.toResponseDto(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new NotFoundException(
                    "Student not found with id: " + id
            );
        }

        studentRepository.deleteById(id);
    }
}