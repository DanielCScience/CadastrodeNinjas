package dev.java10x.CadastrodeNinjas.Missoes;

import dev.java10x.CadastrodeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastrodeNinjas.Ninjas.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missao = missoesService.listarMissoes();
        return ResponseEntity.ok(missao);
    }

    //POST -- Mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissoes(@RequestBody MissoesModel missao){
        MissoesDTO novaMissao = missoesService.criarMissao(missao);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criado com sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId() );
    }

    //Mostrar Missao por id(READ)
    @GetMapping("/listar/{id}" )
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id){
        MissoesDTO MissaoPorId = missoesService.listarMissaoPorId(id);

        if (MissaoPorId != null){
            return ResponseEntity.ok(MissaoPorId);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com o id: " + id + " não existe nos nossos registros");
        }
    }

    //PUT -- Mandar uma requisição para alterar as missoes
    @PutMapping("/alterar")
    public ResponseEntity<?> alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO alterar = missoesService.atualizarMissao(id, missaoAtualizada);

        if (alterar !=null){
            return ResponseEntity.ok(alterar);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Misssao com o id :" + id + " não existe nos nossos registros");
        }
    }

    //DELETE -- Mandar uma requisição para deletar as missoes
    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if(missoesService.listarMissaoPorId(id) != null){
            missoesService.deletarMissao(id);
            return  ResponseEntity.ok("Missao deletada com sucesso, (ID)" + id);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com o Id" + id + "nao encontrada");
        }
    }




}
