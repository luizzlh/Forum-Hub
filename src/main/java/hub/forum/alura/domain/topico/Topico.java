package hub.forum.alura.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String titulo;
    @NotNull
    @NotBlank
    private String mensagem;
    @CreationTimestamp
    @Column(name = "dataCriacao")
    private LocalDateTime dataCriacao;
    private Boolean ativo;
    private String autor;
    private String curso;
}
