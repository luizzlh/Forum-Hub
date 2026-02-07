package hub.forum.alura.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT T FROM Topico T WHERE T.titulo = :title AND T.mensagem = :message")
    Topico verificaExistenciaDeTopico(@NotBlank @NotNull String title, @NotBlank @NotNull String message);

    Page<Topico> findAllByAtivoTrue(Pageable pagina);

}