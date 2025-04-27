package dev.java10x.cadastroDeNinjas.Ninjas.Service;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import dev.java10x.cadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar Ninjas
    public List<Ninja> getAll() {
        return ninjaRepository.findAll();
    }

    // Lista Ninja pelo Id
    public Optional<Ninja> getById(Long id) {
        return ninjaRepository.findById(id);
    }

    // Cadastrar Ninjas
    public Ninja save(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    // Deletar Ninja pelo Id
    public void delete(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Atualizar Missão
    public Ninja updateMission(Long id, Ninja ninjaAtualizado) {
        Ninja ninja = ninjaRepository.findById(id).orElseThrow(() -> new RuntimeException("Ninja não encontrado"));

        ninja.setMissoes(ninjaAtualizado.getMissoes());

        return ninjaRepository.save(ninja);
    }

    // Atualizar E-mail
    public Ninja updateEmail(Long id, Ninja ninjaAtualizado) {
        Ninja ninja = ninjaRepository.findById(id).orElseThrow(() -> new RuntimeException("Ninja não encontrado"));

        ninja.setEmail(ninjaAtualizado.getEmail());

        return ninjaRepository.save(ninja);
    }
}

