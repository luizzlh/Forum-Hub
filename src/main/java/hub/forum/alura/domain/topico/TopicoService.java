package hub.forum.alura.domain.topico;

import hub.forum.alura.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public TopicoResponseDTO salvarTopico(TopicoRequestDTO dadosTopico){
        var checaTopico = topicoRepository.verificaExistenciaDeTopico(dadosTopico.titulo(), dadosTopico.mensagem());
        if(checaTopico != null){
            throw new ValidacaoException("Tópico já existente!");
        }
        if(checaTopico == null){
            Topico topico = new Topico(dadosTopico);
            topicoRepository.save(topico);
            return new TopicoResponseDTO(topico);
        }
        throw new ValidacaoException("Não foi possível criar o tópico!");
    }

    public TopicoDetailsDTO recuperarTopico(Long id){
        var topico = topicoRepository.getReferenceById(id);

        if(topico == null){
            throw new ValidacaoException("Tópico não existe!");
        }
        return new TopicoDetailsDTO(topico);
    }



}
