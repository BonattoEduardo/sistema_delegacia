package br.edu.utfpr.td.tsi.projeto_delegacia.repositories;

import java.util.List;

import br.edu.utfpr.td.tsi.projeto_delegacia.filters.IVeiculoFilter;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;

public interface IVeiculoRepository extends IBaseRepository<Veiculo, String> {

    public List<Veiculo> findAll(IVeiculoFilter veiculoFilter);

}
