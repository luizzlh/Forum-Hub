package hub.forum.alura.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    @NotBlank
    private String titulo;
    @NotBlank
    private String mensagem;
    @CreationTimestamp
    @Column(name = "dataCriacao")
    private LocalDateTime dataCriacao;
    private Boolean ativo;
    private String autor;
    private String curso;

    public Topico(TopicoRequestDTO topicoRequestDTO){
        this.titulo = topicoRequestDTO.titulo();
        this.mensagem = topicoRequestDTO.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.ativo = true;
        this.autor = topicoRequestDTO.autor();
        this.curso = topicoRequestDTO.nomeCurso();
    }

    public void updateTopico(@Valid TopicoRequestDTO dados){
        if(dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if(dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if(dados.autor() != null){
            this.autor = dados.autor();
        }
        if(dados.nomeCurso() != null){
            this.curso = dados.nomeCurso();
        }
    }

    public void excluir(){
        this.ativo = false;
    }
}
