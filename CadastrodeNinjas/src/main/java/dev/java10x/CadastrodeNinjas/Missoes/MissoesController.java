package dev.java10x.CadastrodeNinjas.Missoes;

import dev.java10x.CadastrodeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    //POST -- Mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    //Mostrar Missao por id(READ)
    @GetMapping("/listar/{id}" )
    public MissoesModel listarMissoesId(@PathVariable Long id){
        return missoesService.listarMissoesId(id);
    }

    //PUT -- Mandar uma requisição para alterar as missoes
    @PutMapping("/alterar")
    public MissoesModel alterarNinjaPorId(@PathVariable Long id, @RequestBody MissoesModel MissaosAtualizada) {
        return missoesService.atualizarMissao(id, MissaosAtualizada);
    }

    //DELETE -- Mandar uma requisição para deletar as missoes
    @DeleteMapping("/deletar")
    public void deletarMissaoaPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }




}
