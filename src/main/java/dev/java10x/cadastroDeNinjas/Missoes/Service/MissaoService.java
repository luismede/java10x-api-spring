package dev.java10x.cadastroDeNinjas.Missoes.Service;

import dev.java10x.cadastroDeNinjas.Missoes.Model.Missao;
import dev.java10x.cadastroDeNinjas.Missoes.Repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {
    private final MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    // Cadastrar missao
    public Missao save(Missao missao) {
        return missaoRepository.save(missao);
    }

    // Listar missões
    public List<Missao> getAll() {
        return missaoRepository.findAll();
    }

    // Listar por ID
    public Optional<Missao> getById(Long id) {
        return missaoRepository.findById(id);
    }

    // Atualizar dificuldade
    public Missao updateRank(Long id, Missao missaoAtualizada) {
        Missao missao = missaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Missão não encontrada"));

        missao.setDificuldade(missaoAtualizada.getDificuldade());

        return missaoRepository.save(missao);
    }

    // Deletar missão pelo Id
    public void deleteById(Long id) {
        missaoRepository.deleteById(id);
    }

    // Deletar todas as missões
    public void delete() {
        missaoRepository.deleteAll();
    }

}
