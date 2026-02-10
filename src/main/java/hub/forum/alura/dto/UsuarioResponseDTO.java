package hub.forum.alura.dto;

import hub.forum.alura.model.Usuario;

public record UsuarioResponseDTO(String login) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getLogin());
    }
}
