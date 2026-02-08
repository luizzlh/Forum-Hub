package hub.forum.alura.controller;

import hub.forum.alura.dto.UsuarioRequestDTO;
import hub.forum.alura.repository.UsuarioRepository;
import hub.forum.alura.service.UsuarioService;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Response> criarUsuario(@RequestBody @Valid UsuarioRequestDTO usuarioRequest){
        usuarioService.cadastrar(usuarioRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<Response>> listarUsuarios(){
        return null;
    }

}