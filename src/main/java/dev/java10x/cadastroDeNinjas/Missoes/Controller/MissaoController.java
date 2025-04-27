package dev.java10x.cadastroDeNinjas.Missoes.Controller;

import dev.java10x.cadastroDeNinjas.Missoes.Model.Missao;
import dev.java10x.cadastroDeNinjas.Missoes.Service.MissaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missao")
public class MissaoController {
    // Injeção de Dependencia
    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping("/cadastrar")
    public Missao create(@RequestBody Missao missao) {
        return missaoService.save(missao);
    }

    @DeleteMapping("/excluir/{id}")
    public void deleteById(@PathVariable Long id) {
        missaoService.deleteById(id);
    }

    @DeleteMapping("/excluir")
    public void deleteAll() {
        missaoService.delete();
    }

    @GetMapping()
    public List<Missao> getAll() {
        return missaoService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Missao> getById(@PathVariable Long id) {
        return missaoService.getById(id);
    }

    @PutMapping("/atualizar/{id}")
    public Missao rank(@PathVariable Long id, @RequestBody Missao missaoAtualizada) {
        return missaoService.updateRank(id, missaoAtualizada);
    }


}
