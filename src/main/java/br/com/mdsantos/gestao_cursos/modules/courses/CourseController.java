package br.com.mdsantos.gestao_cursos.modules.courses;

import br.com.mdsantos.gestao_cursos.exceptions.ValidationException;
import br.com.mdsantos.gestao_cursos.modules.courses.dto.CreateCourseRequestDto;
import br.com.mdsantos.gestao_cursos.modules.courses.useCases.CreateCourseUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CreateCourseUseCase createCourseUseCase;

    public CourseController(CreateCourseUseCase createCourseUseCase) {
        this.createCourseUseCase = createCourseUseCase;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCourseRequestDto createCourseRequestDto) {
        try {
            UUID uuid = createCourseUseCase.execute(createCourseRequestDto);
            return ResponseEntity.ok(uuid);
        } catch (ValidationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }
}
