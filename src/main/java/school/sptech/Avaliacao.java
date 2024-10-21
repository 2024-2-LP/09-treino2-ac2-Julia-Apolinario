package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

public class Avaliacao {
    private String descricao;
    private Double qtdEstrelas;


    public Avaliacao() {}

    // Construtor com parâmetros
    public Avaliacao(String descricao, Double qtdEstrelas) {
        if (descricao == null || descricao.isBlank()) {
            throw new ArgumentoInvalidoException("Descrição inválida: não pode ser nula ou vazia.");
        }
        if (qtdEstrelas == null || qtdEstrelas < 0 || qtdEstrelas > 5) {
            throw new ArgumentoInvalidoException("Quantidade de estrelas inválida: deve estar entre 0 e 5.");
        }
        this.descricao = descricao;
        this.qtdEstrelas = qtdEstrelas;
    }



    @Override
    public String toString() {
        return "Avaliação: " + descricao + ", Estrelas: " + qtdEstrelas;
    }

    public String getDescricao() {
        return descricao;
    }

    // Setter para descricao
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new ArgumentoInvalidoException("Descrição inválida: não pode ser nula ou vazia.");
        }
        this.descricao = descricao;
    }

    // Getter para qtdEstrelas
    public Double getQtdEstrelas() {
        return qtdEstrelas;
    }

    // Setter para qtdEstrelas
    public void setQtdEstrelas(Double qtdEstrelas) {
        if (qtdEstrelas == null || qtdEstrelas < 0 || qtdEstrelas > 5) {
            throw new ArgumentoInvalidoException("Quantidade de estrelas inválida: deve estar entre 0 e 5.");
        }
        this.qtdEstrelas = qtdEstrelas;
    }
}
