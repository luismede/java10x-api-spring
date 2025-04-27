package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    // Injeção de Dependencia:
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping()
    public List<Ninja> getAll() {
        return ninjaService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Ninja> getById(@PathVariable Long id) {
        return ninjaService.getById(id);
    }

    @PostMapping("/cadastrar")
    // @RequestBody - Vai pedir para mandar no corpo da requisição os atributos necessários
    public Ninja create(@RequestBody Ninja ninja) {
        return ninjaService.save(ninja);
    }

    @DeleteMapping("/excluir/{id}")
    public void delete(@PathVariable Long id) {
        ninjaService.delete(id);
    }

    @PutMapping("/missao/{id}")
    public Ninja missao(@PathVariable Long id, @RequestBody Ninja ninjaAtualizado) {
        return ninjaService.updateMission(id, ninjaAtualizado);
    }

    @PutMapping("/email/{id}")
    public Ninja email(@PathVariable Long id, @RequestBody Ninja ninjaAtualizado) {
        return ninjaService.updateEmail(id, ninjaAtualizado);
    }

}
