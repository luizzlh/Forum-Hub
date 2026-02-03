package hub.forum.alura.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT T FROM Topico T WHERE T.titulo = :titulo AND T.mensagem = :mensagem")
    Topico verificarExistenciaDeTopico(@NotBlank @NotNull String titulo, @NotBlank @NotNull String mensagem);

}