package dev.java10x.CadastrodeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //Listar todos os ninjas por (ID)
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Deletar o ninja - tem que ser um metodo VOID
    //nao necessita retorna nada, por apenas deleta
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);

    }

    //Atualizar ninja
    //primeiro parametro verifica a existencia e o segundo atualiza
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);

        }
        return null;
    }





}