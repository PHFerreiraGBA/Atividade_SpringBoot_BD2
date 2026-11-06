package br.com.example.controller;

import br.com.example.model.Ferrovia;
import br.com.example.repository.FerroviaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ferrovias")
public class FerroviaController {

    private final FerroviaRepository repository;

    public FerroviaController(FerroviaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Ferrovia> listarTodas() {
        return repository.findAll();
    }

    // Endpoint Consulta 2
    @GetMapping("/proximas-aeroporto/{aeroportoId}")
    public List<Ferrovia> ferroviasProximasAoAeroporto(@PathVariable Long aeroportoId, 
                                                      @RequestParam(defaultValue = "20000") Double distanciaMetros) {
        return repository.findFerroviasProximasAoAeroporto(aeroportoId, distanciaMetros);
    }

    // Endpoint Consulta 4
    @GetMapping("/proximas-rodovias")
    public List<Ferrovia> ferroviasProximasRodovias(@RequestParam(defaultValue = "1000") Double distanciaMetros) {
        return repository.findFerroviasProximasRodovias(distanciaMetros);
    }
}