package br.edu.utfpr.td.tsi.projeto_delegacia.filters;

import br.edu.utfpr.td.tsi.projeto_delegacia.models.PeriodoOcorrencia;

public interface IBoletimFilter {
    public String getCidade();
    public PeriodoOcorrencia getPeriodoOcorrencia();
}
