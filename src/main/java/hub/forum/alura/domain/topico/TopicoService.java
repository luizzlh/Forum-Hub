package hub.forum.alura.domain.topico;

import hub.forum.alura.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public TopicoResponseDTO salvarTopico(TopicoRequestDTO dadosTopico){
        var existeTopico = topicoRepository.verificarExistenciaDeTopico(dadosTopico.titulo(), dadosTopico.mensagem());
        if(existeTopico != null){
            throw new ValidacaoException("Tópico já existente!");
        }
        if(existeTopico == null){
            Topico topico = new Topico(null, dadosTopico.titulo(), dadosTopico.mensagem(),
                    null, true, "Autor", dadosTopico.nomeCurso());
            topicoRepository.save(topico);
            return new TopicoResponseDTO(topico);
        }
        throw new ValidacaoException("Não foi possível criar o tópico!");
    }

}
