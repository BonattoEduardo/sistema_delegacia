package br.edu.utfpr.td.tsi.projeto_delegacia.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

import com.opencsv.exceptions.CsvException;

public interface ICSVConverter<T> {

    public List<T> convertFileStream(InputStream csvFileStream)
        throws IOException, ParseException, CsvException;

}
