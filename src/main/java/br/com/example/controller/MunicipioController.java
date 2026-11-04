package br.com.example.controller;

import java.util.List;

import br.com.example.repository.MunicipioRepository;
import br.com.example.model.MunicipioVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Municípios API", version = "1.0", description = "Dados de Municípios"))
public class MunicipioController {

    private final MunicipioRepository repository;

    MunicipioController(MunicipioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/municipiosPorUF/{uf}")
    public List<MunicipioVO> municipiosPorUF(@PathVariable String uf) {
        List<MunicipioVO> result = repository.listarMunicipiosPorUf(uf);
        return result;
    }

    @GetMapping("/municipiosVizinhos/{nome}")
    public List<MunicipioVO> municipiosVizinhos(@PathVariable String nome) {
        List<MunicipioVO> result = repository.listarMunicipiosVizinhos(nome);
        return result;
    }

    @GetMapping("/cidadesFronteiraPorRegiao/{regiao}")
    public List<MunicipioVO> cidadesFronteiraPorRegiao(@PathVariable String regiao) {
        List<MunicipioVO> result = repository.listarCidadesFronteiraPorRegiao(regiao);
        return result;
    }

    @GetMapping("/cidadesFronteiraPorEstado/{estado}")
    public List<MunicipioVO> cidadesFronteiraPorEstado(@PathVariable String estado) {
        List<MunicipioVO> result = repository.listarCidadesFronteiraPorEstado(estado);
        return result;
    }

    @GetMapping("/cidadesGemeasPorEstado/{estado}")
    public List<MunicipioVO> cidadesGemeasPorEstado(@PathVariable String estado) {
        List<MunicipioVO> result = repository.listarCidadesGemeasPorEstado(estado);
        return result;
    }

    @GetMapping("/distanciaEntreMunicipios/{municipioA}/{municipioB}")
    public Double distanciaEntreMunicipios(@PathVariable String municipioA, @PathVariable String municipioB) {
        double result = repository.distanciaEntreMunicipios(municipioA, municipioB);
        return result;
    }

    @GetMapping("/topKMaioresMunicipiosPorKM2/{k}")
    public List<MunicipioVO> topKMaioresMunicipiosPorKM2(@PathVariable int k) {
        List<MunicipioVO> result = repository.topKMaioresMunicipiosPorKM2(k);
        return result;
    }

}