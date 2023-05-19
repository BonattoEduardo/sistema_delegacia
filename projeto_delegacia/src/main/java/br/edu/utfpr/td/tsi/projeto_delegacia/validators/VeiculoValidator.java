package br.edu.utfpr.td.tsi.projeto_delegacia.validators;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoCorException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoMarcaException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoTipoVeiculoException;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;

@Component
public class VeiculoValidator implements IValidator<Veiculo> {

    @Override
    public void validate(Veiculo veiculo) {
        if (veiculo.getCor() == null)
            throw new VeiculoCorException();

        if (veiculo.getMarca() == null)
            throw new VeiculoMarcaException();

        if (veiculo.getTipoVeiculo() == null)
            throw new VeiculoTipoVeiculoException();
    }
    
}
