package br.edu.utfpr.td.tsi.projeto_delegacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoNotFoundException;
import br.edu.utfpr.td.tsi.projeto_delegacia.filters.IVeiculoFilter;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.repositories.IVeiculoRepository;
import br.edu.utfpr.td.tsi.projeto_delegacia.validators.IValidator;

@Service
public class VeiculoServiceImpl implements IVeiculoService {

    @Autowired
    private IVeiculoRepository veiculoRepository;

    @Autowired
    private IValidator<Veiculo> validator;

    @Override
    public Veiculo readVeiculo(String idVeiculo) {
        return veiculoRepository.findById(idVeiculo)
            .orElseThrow(VeiculoNotFoundException::new);
    }

    @Override
    public List<Veiculo> listVeiculos() {
        return veiculoRepository.findAll();
    }

    @Override
    public List<Veiculo> listVeiculos(IVeiculoFilter filter) {
        return veiculoRepository.findAll(filter);
    }

    @Override
    public Veiculo createVeiculo(Veiculo veiculo) {;
        validator.validate(veiculo);
        return veiculoRepository.save(veiculo);
    }

    @Override
    public Veiculo updateVeiculo(Veiculo veiculo) {
        if (!veiculoRepository.existsById(veiculo.getIdVeiculo()))
            throw new VeiculoNotFoundException();

        validator.validate(veiculo);

        return veiculoRepository.save(veiculo);
    }
    
}
