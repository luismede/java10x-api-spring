package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.cadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    // Injeção de Dependencia:
    private final NinjaService ninjaService;
    private final NinjaRepository ninjaRepository;

    public NinjaController(NinjaService ninjaService, NinjaRepository ninjaRepository) {
        this.ninjaService = ninjaService;
        this.ninjaRepository = ninjaRepository;
    }

    @GetMapping("/ninjas")
    public List<NinjaModel> getAll() {
        return ninjaRepository.findAll();
    }

    @PostMapping("/cadastrar")
    // @RequestBody - Vai pedir para mandar no corpo da requisição os atributos necessários
    public NinjaModel create(@RequestBody NinjaModel ninjaModel) {
        return ninjaRepository.save(ninjaModel);
    }
}
