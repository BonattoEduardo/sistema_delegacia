package br.edu.utfpr.td.tsi.projeto_delegacia.controle.persistencia;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opencsv.exceptions.CsvException;

@Repository
public class BoletimFurtoVeiculoDAOEmMemoria implements IBoletimFurtoVeiculoDAO {

    private ArrayList<BoletimFurtoVeiculo> dataBase = new ArrayList<>();

    private final ICsvToObjectReader csv;
    
    @Autowired
    public BoletimFurtoVeiculoDAOEmMemoria(ICsvToObjectReader csv) {
        this.csv = csv;

        try {
            dataBase.addAll(csv.CsvBoletinsToObject("projeto_delegacia/furtos.csv"));
        } catch (IOException | ParseException | CsvException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void adicionarBoletim(BoletimFurtoVeiculo boletimFurtoVeiculo) {
        dataBase.add(boletimFurtoVeiculo);
    }

    @Override
    public void alterarBoletim(Long idBoletimFurtoVeiculo, BoletimFurtoVeiculo boletimFurtoVeiculo) {
        BoletimFurtoVeiculo boletim = buscarBoletimPorId(idBoletimFurtoVeiculo);
        int index = dataBase.indexOf(boletim);

        dataBase.set(index, boletimFurtoVeiculo);
    }

    @Override
    public void removerBoletim(Long idBoletimFurtoVeiculo) {
        BoletimFurtoVeiculo boletim = buscarBoletimPorId(idBoletimFurtoVeiculo);
        dataBase.remove(boletim);
    }

    @Override
    public BoletimFurtoVeiculo buscarBoletimPorId(Long idBoletimFurtoVeiculo) {

        return dataBase.stream()
            .filter(boletim -> boletim.getIdBoletimFurtoVeiculo() == idBoletimFurtoVeiculo)
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<BoletimFurtoVeiculo> listarTodosBoletins() {
        return dataBase;
    }

    @Override
    public List<Veiculo> listarTodosVeiculos() {
        return dataBase.stream().map(BoletimFurtoVeiculo::getVeiculoFurtado).toList();
    }

    @Override
    public List<BoletimFurtoVeiculo> buscarBoletins(IFiltroBoletim filtroBoletim) {
        return dataBase.stream()
                .filter(boletim -> boletim.getLocalOcorrencia().getCidade().equals(filtroBoletim.getCidade()) ||
                        boletim.getDataOcorrencia().equals(filtroBoletim.getDataOcorrencia()))
                .toList();
    }

    @Override
    public List<Veiculo> buscarVeiculos(IFiltroVeiculo filtroVeiculo) {
        return dataBase.stream()
                .map(BoletimFurtoVeiculo::getVeiculoFurtado)
                .filter(veiculo -> veiculo.getMarca().equals(filtroVeiculo.getMarca()) ||
                        veiculo.getEmplacamento().getPlaca().equals(filtroVeiculo.getPlaca()))
                .toList();
    }

}
