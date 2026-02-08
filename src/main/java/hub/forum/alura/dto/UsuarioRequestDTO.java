package hub.forum.alura.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(
        @NotBlank
        String login,
        @NotBlank
        String senha) {
}
