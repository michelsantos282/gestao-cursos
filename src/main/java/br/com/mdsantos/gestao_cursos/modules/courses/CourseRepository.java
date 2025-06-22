package br.com.mdsantos.gestao_cursos.modules.courses;

import br.com.mdsantos.gestao_cursos.modules.courses.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

}
