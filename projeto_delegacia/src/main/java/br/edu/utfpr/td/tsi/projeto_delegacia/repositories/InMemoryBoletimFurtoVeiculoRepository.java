package br.edu.utfpr.td.tsi.projeto_delegacia.repositories;

import br.edu.utfpr.td.tsi.projeto_delegacia.filters.IBoletimFilter;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.utils.FilterUtils;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBoletimFurtoVeiculoRepository
        extends InMemoryRepository<BoletimFurtoVeiculo, String>
        implements IBoletimFurtoVeiculoRepository {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getId(BoletimFurtoVeiculo entity) {
        return entity.getIdBoletimFurtoVeiculo();
    }

    @Override
    public void setId(BoletimFurtoVeiculo entity, String id) {
        entity.setIdBoletimFurtoVeiculo(id);
    }

    @Override
    public List<BoletimFurtoVeiculo> findAll(IBoletimFilter filter) {
        return getDataBase().stream()
            .filter(boletim -> this.matchesFilter(boletim, filter))
            .toList();
    }

    private boolean matchesCidade(BoletimFurtoVeiculo boletim, IBoletimFilter filter) {
        return (
            filter.getCidade() == null ||
            boletim.getLocalOcorrencia() != null &&
            FilterUtils.compare(boletim.getLocalOcorrencia().getCidade(), filter.getCidade())
        );
    }

    private boolean matchesPeriodoOcorrencia(BoletimFurtoVeiculo boletim, IBoletimFilter filter) {
        return (
            filter.getPeriodoOcorrencia() == null ||
            boletim.getPeriodoOcorrencia() != null &&
            FilterUtils.compare(
                boletim.getPeriodoOcorrencia().getDescription(),
                filter.getPeriodoOcorrencia().getDescription())
        );
    }

    private boolean matchesFilter(BoletimFurtoVeiculo boletim, IBoletimFilter filter) {
        return matchesCidade(boletim, filter) && matchesPeriodoOcorrencia(boletim, filter);
    }
}
