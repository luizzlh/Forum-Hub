package hub.forum.alura.controller;

import hub.forum.alura.domain.topico.TopicoRepository;
import hub.forum.alura.domain.topico.TopicoRequestDTO;
import hub.forum.alura.domain.topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid TopicoRequestDTO dados){
        var dto = topicoService.salvarTopico(dados);
        return ResponseEntity.ok(dto);
    }

}