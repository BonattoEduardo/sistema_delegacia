package br.edu.utfpr.td.tsi.projeto_delegacia.repositories;

import br.edu.utfpr.td.tsi.projeto_delegacia.filters.IBoletimFilter;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.BoletimFurtoVeiculo;

import java.util.List;

public interface IBoletimFurtoVeiculoRepository extends IBaseRepository<BoletimFurtoVeiculo, String> {

    public List<BoletimFurtoVeiculo> findAll(IBoletimFilter boletimFilter);

}