package br.com.mdsantos.gestao_cursos.modules.courses.useCases;

import br.com.mdsantos.gestao_cursos.exceptions.ValidationException;
import br.com.mdsantos.gestao_cursos.modules.courses.CourseRepository;
import br.com.mdsantos.gestao_cursos.modules.courses.dto.CreateCourseRequestDto;
import br.com.mdsantos.gestao_cursos.modules.courses.entities.CourseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateCourseUseCase {

    private final CourseRepository courseRepository;

    public CreateCourseUseCase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public UUID execute(CreateCourseRequestDto courseRequestDto) throws ValidationException {
        if (courseRequestDto.title() == null || courseRequestDto.description() == null) {
            throw new ValidationException("Title and description required");
        }

        CourseEntity courseEntity = CourseEntity.builder()
                .title(courseRequestDto.title())
                .description(courseRequestDto.description())
                .instructorId(UUID.fromString("4f71908b-2a26-4a54-a7ec-11694b034d5c"))
                .build();

        return courseRepository.save(courseEntity).getId();
    }

}
