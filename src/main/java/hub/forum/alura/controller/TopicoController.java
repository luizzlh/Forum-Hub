package hub.forum.alura.controller;

import hub.forum.alura.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<Page<TopicoResponseDTO>> listarTopicos(@PageableDefault(size = 10,
            sort = {"dataCriacao"}) Pageable pagina){
        var listTopics = topicoRepository.findAllByAtivoTrue(pagina).map(TopicoResponseDTO::new);
        return ResponseEntity.ok(listTopics);
    }

}