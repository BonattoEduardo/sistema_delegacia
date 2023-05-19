package br.edu.utfpr.td.tsi.projeto_delegacia.filters;

import br.edu.utfpr.td.tsi.projeto_delegacia.models.TipoVeiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoFilterImpl implements IVeiculoFilter {
    private String placa;
    private String cor;
    private TipoVeiculo tipo;
}
