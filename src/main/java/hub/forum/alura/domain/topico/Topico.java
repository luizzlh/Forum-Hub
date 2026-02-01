package hub.forum.alura.domain.topico;

import hub.forum.alura.domain.Autor.Autor;
import hub.forum.alura.domain.Curso.Curso;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    private int id;
    @NotNull
    @NotBlank
    private String titulo;
    @NotNull
    @NotBlank
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Boolean ativo;
    private Autor autor;
    private Curso curso;
}
