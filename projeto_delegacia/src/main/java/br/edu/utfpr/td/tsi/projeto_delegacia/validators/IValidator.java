package br.edu.utfpr.td.tsi.projeto_delegacia.validators;

public interface IValidator<T> {
    
    public void validate(T entity);

}
