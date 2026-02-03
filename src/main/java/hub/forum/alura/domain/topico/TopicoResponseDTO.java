package hub.forum.alura.domain.topico;

import java.time.LocalDateTime;

public record TopicoResponseDTO(Long id, String titulo, String mensagem, LocalDateTime dataCriacao) {
    public TopicoResponseDTO(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao());
    }
}
