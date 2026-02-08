package hub.forum.alura.service;

import hub.forum.alura.dto.UsuarioRequestDTO;
import hub.forum.alura.model.Usuario;
import hub.forum.alura.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastrar(@RequestBody @Valid UsuarioRequestDTO usuario){
        Usuario user = new Usuario(usuario);
        usuarioRepository.save(user);
    }

}
