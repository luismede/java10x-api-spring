package dev.java10x.cadastroDeNinjas.Ninjas.Service;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.cadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar Ninjas
    public List<NinjaModel> getAll() {
        return ninjaRepository.findAll();
    }

    // Cadastrar Ninjas
    public NinjaModel save(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Deletar Ninja pelo Id
    public void delete(Long id) {
        ninjaRepository.deleteById(id);
    }
}
