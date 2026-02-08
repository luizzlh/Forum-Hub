package hub.forum.alura.dto;

import hub.forum.alura.model.Topico;

import java.time.LocalDateTime;

public record TopicoResponseDTO(Long id, String titulo, String mensagem, LocalDateTime dataCriacao) {
    public TopicoResponseDTO(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao());
    }
}
