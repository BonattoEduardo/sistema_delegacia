package br.edu.utfpr.td.tsi.projeto_delegacia.filters;

import br.edu.utfpr.td.tsi.projeto_delegacia.models.TipoVeiculo;

public interface IVeiculoFilter {
    public String getPlaca();
    public String getCor();
    public TipoVeiculo getTipo();
}