package br.com.example.controller;

import br.com.example.model.Aeroporto;
import br.com.example.repository.AeroportoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/aeroportos")
public class AeroportoController {

    private final AeroportoRepository repository;

    public AeroportoController(AeroportoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Aeroporto> listarTodos() {
        return repository.findAll();
    }
}