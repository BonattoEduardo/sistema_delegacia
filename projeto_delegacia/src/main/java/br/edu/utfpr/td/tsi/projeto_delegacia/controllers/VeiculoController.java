package br.edu.utfpr.td.tsi.projeto_delegacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.td.tsi.projeto_delegacia.filters.IVeiculoFilter;
import br.edu.utfpr.td.tsi.projeto_delegacia.filters.VeiculoFilterImpl;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.TipoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.services.IVeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    private IVeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> listVeiculos(
        @RequestParam(name = "placa", required = false) String placa,
        @RequestParam(name = "cor", required = false) String cor,
        @RequestParam(name = "tipo", required = false) TipoVeiculo tipo
    ){
        if (placa == null && cor == null && tipo == null) {
            return veiculoService.listVeiculos();
        }

        IVeiculoFilter filter = new VeiculoFilterImpl(placa, cor, tipo);
        return veiculoService.listVeiculos(filter);
    }
    
}
