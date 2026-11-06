package br.com.example.controller;

import br.com.example.model.Rodovia;
import br.com.example.repository.RodoviaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rodovias")
public class RodoviaController {

    private final RodoviaRepository repository;

    public RodoviaController(RodoviaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Rodovia> listarTodas() {
        return repository.findAll();
    }

    // Endpoint Consulta 1
    @GetMapping("/proximas-aeroporto/{aeroportoId}")
    public List<Rodovia> rodoviasProximasAoAeroporto(@PathVariable Long aeroportoId, 
                                                    @RequestParam(defaultValue = "10000") Double distanciaMetros) {
        return repository.findRodoviasProximasAoAeroporto(aeroportoId, distanciaMetros);
    }

    // Endpoint Consulta 3
    @GetMapping("/cruzam-ferrovias")
    public List<Rodovia> rodoviasQueCruzamFerrovias() {
        return repository.findRodoviasQueCruzamFerrovias();
    }

    // Endpoint Consulta 5
    @GetMapping("/mais-proxima-aeroporto/{aeroportoId}")
    public Rodovia rodoviaMaisProximaAoAeroporto(@PathVariable Long aeroportoId) {
        return repository.findRodoviaMaisProximaAoAeroporto(aeroportoId);
    }
}