package br.edu.utfpr.td.tsi.projeto_delegacia.dtos;

import java.time.LocalDate;

import br.edu.utfpr.td.tsi.projeto_delegacia.models.Endereco;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.PeriodoOcorrencia;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoletimFurtoVeiculoReadDTO {
    private String idBoletimFurtoVeiculo;
    private LocalDate dataOcorrencia;
    private PeriodoOcorrencia periodoOcorrencia;
    private Endereco localOcorrencia;
    private Veiculo veiculoFurtado;
}
