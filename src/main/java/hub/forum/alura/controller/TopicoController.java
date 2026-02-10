package hub.forum.alura.controller;

import hub.forum.alura.dto.TopicoDetailsDTO;
import hub.forum.alura.dto.TopicoRequestDTO;
import hub.forum.alura.dto.TopicoResponseDTO;
import hub.forum.alura.repository.TopicoRepository;
import hub.forum.alura.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity salvarTopico(@RequestBody @Valid TopicoRequestDTO data){
        var dto = topicoService.salvarTopico(data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<TopicoResponseDTO>> listarTopicos(@PageableDefault(size = 10,
            sort = {"dataCriacao"}) Pageable page){
        var lista = topicoRepository.findAllByAtivoTrue(page).map(TopicoResponseDTO::new);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TopicoDetailsDTO>> buscarTopicoPorId(@PathVariable Long id){
         Optional<TopicoDetailsDTO> topico = topicoService.recuperarTopico(id);
         if(topico.isPresent()){
            return ResponseEntity.ok(topico);
         }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopicoPorId(@PathVariable Long id){
        topicoService.deletarTopico(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizaTopico(@PathVariable Long id, @RequestBody @Valid TopicoRequestDTO dados){
        var topico = topicoRepository.getReferenceById(id);
        topico.updateTopico(dados);
        return ResponseEntity.ok(new TopicoDetailsDTO(topico));
    }

}