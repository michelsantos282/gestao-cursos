package br.com.mdsantos.gestao_cursos.modules.courses.entities;

import br.com.mdsantos.gestao_cursos.modules.users.entities.Email;
import br.com.mdsantos.gestao_cursos.modules.users.entities.Password;
import br.com.mdsantos.gestao_cursos.modules.users.entities.RoleUser;
import br.com.mdsantos.gestao_cursos.modules.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
@Builder
@Entity
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "instructor_id", updatable = false, insertable = false)
    private UserEntity instructor;
    @Column(name ="instructor_id", nullable = false)
    private UUID instructorId;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
