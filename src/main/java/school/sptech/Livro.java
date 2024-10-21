package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes;

    // Construtor vazio
    public Livro() {
        this.avaliacoes = new ArrayList<>();
    }

    // Construtor com parâmetros
    public Livro(String titulo, String autor, LocalDate dataPublicacao) throws ArgumentoInvalidoException {
        if (titulo == null || titulo.isBlank()) {
            throw new ArgumentoInvalidoException("Título inválido.");
        }
        if (autor == null || autor.isBlank()) {
            throw new ArgumentoInvalidoException("Autor inválido.");
        }
        if (dataPublicacao == null) {
            throw new ArgumentoInvalidoException("Data de publicação inválida.");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.avaliacoes = new ArrayList<>();
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas) throws ArgumentoInvalidoException {
        Avaliacao avaliacao = new Avaliacao(descricao, qtdEstrelas);
        avaliacoes.add(avaliacao);
    }

    public Double calcularMediaAvaliacoes() {
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }
        double soma = 0.0;
        for (Avaliacao avaliacao : avaliacoes) {
            soma += avaliacao.getQtdEstrelas();
        }
        return soma / avaliacoes.size();
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        return "Livro: " + titulo + " por " + autor + ", Publicado em: " + dataPublicacao + ", Média Avaliações: " + calcularMediaAvaliacoes();
    }
}
