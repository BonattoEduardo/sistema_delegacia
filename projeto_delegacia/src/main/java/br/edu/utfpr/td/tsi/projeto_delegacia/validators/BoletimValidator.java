package br.edu.utfpr.td.tsi.projeto_delegacia.validators;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.DataOcorrenciaException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.EnderecoCidadeException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.EnderecoEstadoException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.LocalOcorrenciaException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.NomeDaParteException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.ParteEmailException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.ParteException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.ParteTelefoneException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.PeriodoOcorrenciaException;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.utils.ValidationUtils;

@Component
public class BoletimValidator implements IValidator<BoletimFurtoVeiculo> {

    @Override
    public void validate(BoletimFurtoVeiculo boletimFurtoVeiculo) {

        if (boletimFurtoVeiculo.getDataOcorrencia() == null ||
            boletimFurtoVeiculo.getDataOcorrencia().isAfter(LocalDate.now()))
            throw new DataOcorrenciaException();
            
        if (boletimFurtoVeiculo.getPeriodoOcorrencia() == null)
            throw new PeriodoOcorrenciaException();

        if (boletimFurtoVeiculo.getParte() == null)
            throw new ParteException();

        if (boletimFurtoVeiculo.getParte().getNome() == null)
            throw new NomeDaParteException();

        if (boletimFurtoVeiculo.getParte().getEmail() != null &&
            !ValidationUtils.isEmailValid(boletimFurtoVeiculo.getParte().getEmail()))
            throw new ParteEmailException();

        if (boletimFurtoVeiculo.getParte().getTelefone() != null &&
            !ValidationUtils.isPhoneValid(boletimFurtoVeiculo.getParte().getTelefone()))
            throw new ParteTelefoneException();

        if (boletimFurtoVeiculo.getLocalOcorrencia() == null)
            throw new LocalOcorrenciaException();

        if (boletimFurtoVeiculo.getLocalOcorrencia().getCidade() == null)
            throw new EnderecoCidadeException();

        if (boletimFurtoVeiculo.getLocalOcorrencia().getEstado() == null)
            throw new EnderecoEstadoException();

    }
    
}
