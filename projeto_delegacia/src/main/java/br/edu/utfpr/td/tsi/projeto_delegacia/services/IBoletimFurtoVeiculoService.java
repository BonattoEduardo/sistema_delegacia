package br.edu.utfpr.td.tsi.projeto_delegacia.services;

import java.util.List;

import br.edu.utfpr.td.tsi.projeto_delegacia.filters.IBoletimFilter;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.BoletimFurtoVeiculo;

public interface IBoletimFurtoVeiculoService {

    public BoletimFurtoVeiculo createBoletim(BoletimFurtoVeiculo boletimFurtoVeiculo);
    
    public BoletimFurtoVeiculo readBoletim(String idBoletimFurtoVeiculo);
    
    public BoletimFurtoVeiculo updateBoletim(String idBoletimFurtoVeiculo, BoletimFurtoVeiculo boletimFurtoVeiculo);
    
    public void deleteBoletim(String idBoletimFurtoVeiculo);
    
    public List<BoletimFurtoVeiculo> listBoletins();

    public List<BoletimFurtoVeiculo> listBoletins(IBoletimFilter filter);

}
