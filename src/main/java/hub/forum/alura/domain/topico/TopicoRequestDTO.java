package hub.forum.alura.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.aspectj.weaver.ast.Not;

import java.time.LocalDateTime;

public record TopicoRequestDTO(
        @NotBlank
        @NotNull
        String titulo,
        @NotBlank
        @NotNull
        String mensagem,
        @NotBlank
        @NotNull
        String nomeCurso
) {
}
