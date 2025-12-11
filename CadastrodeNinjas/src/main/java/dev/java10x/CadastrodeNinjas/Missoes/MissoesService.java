package dev.java10x.CadastrodeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Criar missão
    public  MissoesDTO criarMissao(MissoesModel missoesDTO){
        MissoesModel missao = missoesMapper.map(missoesDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    //Listar missões
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }


    //Listar missoes por (ID)
    public MissoesDTO listarMissaoPorId(long id){
        Optional<MissoesModel> missaoPorID = missoesRepository.findById(id);
        return missaoPorID.map(missoesMapper::map).orElse(null);
    }

    //Atualizar missao
    //primeiro parametro verifica a existencia e o segundo atualiza
    public MissoesDTO atualizarMissao(Long id, MissoesDTO novosDadosDTO){
        Optional<MissoesModel> missaoExistenteOpt = missoesRepository.findById(id);

        if (missaoExistenteOpt.isPresent()){
            MissoesModel missaoParaAtualizar = missaoExistenteOpt.get();
            MissoesModel missaoComNovosDados = missoesMapper.map(novosDadosDTO);

            missaoParaAtualizar.setNome(missaoComNovosDados.getNome());
            missaoParaAtualizar.setDificuldade(missaoComNovosDados.getDificuldade());
            missaoParaAtualizar.setNinjas(missaoComNovosDados.getNinjas());

            MissoesModel missaoSalva = missoesRepository.save(missaoParaAtualizar);
            return missoesMapper.map(missaoSalva);
        }

        return null;
    }

    //Deletar o missao - tem que ser um metodo VOID
    //nao necessita retorna nada, pois apenas deleta
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }


}
