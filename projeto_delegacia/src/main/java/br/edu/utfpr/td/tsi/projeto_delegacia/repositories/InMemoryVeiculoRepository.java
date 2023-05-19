package br.edu.utfpr.td.tsi.projeto_delegacia.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.utfpr.td.tsi.projeto_delegacia.filters.IVeiculoFilter;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.utils.FilterUtils;

@Repository
public class InMemoryVeiculoRepository
        extends InMemoryRepository<Veiculo, String>
        implements IVeiculoRepository {

    @Override
    public String getId(Veiculo entity) {
        return entity.getIdVeiculo();
    }

    @Override
    public void setId(Veiculo entity, String id) {
        entity.setIdVeiculo(id);
    }

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public List<Veiculo> findAll(IVeiculoFilter veiculoFilter) {
        return getDataBase().stream()
            .filter(veiculo -> matchesFilter(veiculo, veiculoFilter))
            .toList();
    }

    private boolean matchesCor(Veiculo veiculo, IVeiculoFilter filter) {
        return (
            filter.getCor() == null ||
            FilterUtils.compare(veiculo.getCor(), filter.getCor())
        );
    }

    private boolean matchesPlaca(Veiculo veiculo, IVeiculoFilter filter) {
        return (
            filter.getPlaca() == null ||
            veiculo.getEmplacamento() != null &&
            FilterUtils.compare(veiculo.getEmplacamento().getPlaca(), filter.getPlaca())
        );
    }

    private boolean matchesTipo(Veiculo veiculo, IVeiculoFilter filter) {
        return (
            filter.getTipo() == null ||
            veiculo.getTipoVeiculo() != null &&
            FilterUtils.compare(veiculo.getTipoVeiculo().getDescription(), filter.getTipo().getDescription())
        );
    }

    private boolean matchesFilter(Veiculo veiculo, IVeiculoFilter filter) {

        return (
            matchesCor(veiculo, filter) &&
            matchesPlaca(veiculo, filter) &&
            matchesTipo(veiculo, filter)
        );
    }
    
}
