package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new ArgumentoInvalidoException("Nome da biblioteca inválido.");
        }
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro) {
        if (livro == null || livro.getTitulo() == null || livro.getTitulo().isBlank() ||
                livro.getAutor() == null || livro.getAutor().isBlank() || livro.getDataPublicacao() == null) {
            throw new ArgumentoInvalidoException("Livro inválido: um ou mais campos estão incorretos.");
        }
        livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new ArgumentoInvalidoException("Título inválido: não pode ser nulo ou vazio.");
        }
        Livro livro = buscarLivroPorTitulo(titulo);
        livros.remove(livro);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new ArgumentoInvalidoException("Título inválido: não pode ser nulo ou vazio.");
        }
        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElseThrow(() -> new LivroNaoEncontradoException("Livro não encontrado com o título: " + titulo));
    }

    public Integer contarLivros() {
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        if (ano == null) {
            throw new ArgumentoInvalidoException("Ano inválido: não pode ser nulo.");
        }
        return livros.stream()
                .filter(livro -> livro.getDataPublicacao().getYear() <= ano)
                .collect(Collectors.toList());
    }

    public List<Livro> retornarTopCincoLivros() {
        return livros.stream()
                .sorted((l1, l2) -> l2.calcularMediaAvaliacoes().compareTo(l1.calcularMediaAvaliacoes()))
                .limit(5)
                .collect(Collectors.toList());
    }




}
