package hub.forum.alura.dto;

import hub.forum.alura.model.Topico;

import java.time.LocalDateTime;

public record TopicoDetailsDTO(String titulo, String mensagem, LocalDateTime dataCriacao, Boolean ativo, String autor, String curso) {
    public TopicoDetailsDTO(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAtivo(), topico.getAutor(), topico.getCurso());
    }
}
