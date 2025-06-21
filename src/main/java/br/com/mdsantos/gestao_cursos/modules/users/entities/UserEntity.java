package br.com.mdsantos.gestao_cursos.modules.users.entities;

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
@Table(name = "users")
@Builder
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Embedded
    @Column(nullable = false, unique = true)
    private Email email;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleUser roleUser;
    @Embedded
    private Password password;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
