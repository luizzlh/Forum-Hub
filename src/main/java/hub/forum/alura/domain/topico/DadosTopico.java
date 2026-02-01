package hub.forum.alura.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosTopico(
        @NotBlank
        @NotNull
        String titulo,
        @NotBlank
        @NotNull
        String mensagem,
        @NotBlank
        @NotNull
        String autor,
        @NotBlank
        @NotNull
        String curso
) {
}
