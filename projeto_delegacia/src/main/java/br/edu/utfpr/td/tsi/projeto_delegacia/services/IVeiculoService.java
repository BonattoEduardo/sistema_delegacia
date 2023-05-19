package br.edu.utfpr.td.tsi.projeto_delegacia.services;

import java.util.List;

import br.edu.utfpr.td.tsi.projeto_delegacia.filters.IVeiculoFilter;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;

public interface IVeiculoService {

    public Veiculo readVeiculo(String idVeiculo);
    
    public List<Veiculo> listVeiculos();

    public List<Veiculo> listVeiculos(IVeiculoFilter filter);

    public Veiculo createVeiculo(Veiculo veiculo);

    public Veiculo updateVeiculo(Veiculo veiculo);

}
