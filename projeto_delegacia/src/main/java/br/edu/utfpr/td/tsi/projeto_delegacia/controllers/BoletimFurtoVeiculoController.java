package br.edu.utfpr.td.tsi.projeto_delegacia.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.td.tsi.projeto_delegacia.dtos.BoletimFurtoVeiculoDTO;
import br.edu.utfpr.td.tsi.projeto_delegacia.dtos.BoletimFurtoVeiculoReadDTO;
import br.edu.utfpr.td.tsi.projeto_delegacia.filters.BoletimFilterImpl;
import br.edu.utfpr.td.tsi.projeto_delegacia.filters.IBoletimFilter;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.PeriodoOcorrencia;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.services.IBoletimFurtoVeiculoService;
import br.edu.utfpr.td.tsi.projeto_delegacia.services.IVeiculoService;

@RestController
@RequestMapping("/boletins")
public class BoletimFurtoVeiculoController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IBoletimFurtoVeiculoService boletimFurtoVeiculoService;
    @Autowired
    private IVeiculoService veiculoService;

    @GetMapping
    public List<BoletimFurtoVeiculoReadDTO> listBoletins(
        @RequestParam(name = "cidade", required = false) String cidade,
        @RequestParam(name = "periodo", required = false) PeriodoOcorrencia periodo 
    ) {
        if (cidade == null && periodo == null) {
            return boletimFurtoVeiculoService.listBoletins().stream()
                .map(this::convertToReadDTO)
                .toList();
        }

        IBoletimFilter filter = new BoletimFilterImpl(cidade, periodo);
        return boletimFurtoVeiculoService.listBoletins(filter).stream()
            .map(this::convertToReadDTO)
            .toList();
    }

    @GetMapping("/{id}")
    public BoletimFurtoVeiculoReadDTO buscarBoletimPorId(@PathVariable("id") String idBoletimFurtoVeiculo) {
        return convertToReadDTO(boletimFurtoVeiculoService.readBoletim(idBoletimFurtoVeiculo));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public BoletimFurtoVeiculoDTO cadastrarBoletim(@RequestBody BoletimFurtoVeiculoDTO boletimDTO) {
        Veiculo veiculo = veiculoService.createVeiculo(boletimDTO.getVeiculoFurtado());

        BoletimFurtoVeiculo boletim = modelMapper.map(boletimDTO, BoletimFurtoVeiculo.class);
        boletim.setIdVeiculoFurtado(veiculo.getIdVeiculo());

        boletim = boletimFurtoVeiculoService.createBoletim(boletim);

        boletimDTO = modelMapper.map(boletim, BoletimFurtoVeiculoDTO.class);
        boletimDTO.setVeiculoFurtado(veiculo);

        return boletimDTO;
    }

    @PutMapping("/{id}")
    public BoletimFurtoVeiculoDTO updateBoletimById(
        @PathVariable("id") String idBoletimFurtoVeiculo,
        @RequestBody BoletimFurtoVeiculoDTO boletimDTO
    ) {
        Veiculo veiculo = veiculoService.updateVeiculo(boletimDTO.getVeiculoFurtado());

        BoletimFurtoVeiculo boletim = modelMapper.map(boletimDTO, BoletimFurtoVeiculo.class);
        boletim.setIdVeiculoFurtado(veiculo.getIdVeiculo());

        boletim = boletimFurtoVeiculoService.updateBoletim(idBoletimFurtoVeiculo, boletim);

        boletimDTO = modelMapper.map(boletim, BoletimFurtoVeiculoDTO.class);
        boletimDTO.setVeiculoFurtado(veiculo);

        return boletimDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteBoletimById(@PathVariable("id") String idBoletimFurtoVeiculo) {
        boletimFurtoVeiculoService.deleteBoletim(idBoletimFurtoVeiculo);
    }

    private BoletimFurtoVeiculoReadDTO convertToReadDTO(BoletimFurtoVeiculo boletim) {
        BoletimFurtoVeiculoReadDTO boletimListDTO = modelMapper.map(boletim, BoletimFurtoVeiculoReadDTO.class);

        Veiculo veiculo = veiculoService.readVeiculo(boletim.getIdVeiculoFurtado());
        boletimListDTO.setVeiculoFurtado(veiculo);

        return boletimListDTO;
    }
}
