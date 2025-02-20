package com.example.demo.entities;

public class Lanche {
    private int codigo;
    private String nome;
    private double preco;
    private String imagem;

    public Lanche(String nome, String imagem, double preco, int codigo) {
        this.nome = nome;
        this.imagem = imagem;
        this.preco = preco;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Lanche{" +
                "imagem='" + imagem + '\'' +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
