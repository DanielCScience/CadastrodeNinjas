package dev.java10x.CadastrodeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Criar missão
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Listar missões
   public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //Listar missoes por (ID)
    public MissoesModel listarMissoesId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    //Atualizar missao
    //primeiro parametro verifica a existencia e o segundo atualiza
    public MissoesModel atualizarMissao (Long id, MissoesModel missaoAtualizado){
        if (missoesRepository.existsById(id)){
            missaoAtualizado.setId(id);
            return missoesRepository.save(missaoAtualizado);
        }
        return null;
    }

    //Deletar o missao - tem que ser um metodo VOID
    //nao necessita retorna nada, pois apenas deleta
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }


}
