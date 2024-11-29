package br.unifor.ead.conversor.modelos;

import java.util.ArrayList;

public class UnidadeDeMedida {

    private static int contadorId = 0;
    private int id;
    private String nome;
    private double fatorConversao;
    private Categoria categoria;
    private static ArrayList<UnidadeDeMedida> unidadesInstanciadas = new ArrayList<UnidadeDeMedida>();

    public UnidadeDeMedida(String nome, double fatorConversao, Categoria categoria) {
        this.id = ++contadorId;
        this.nome = nome;
        this.fatorConversao = fatorConversao;
        this.categoria = categoria;
        unidadesInstanciadas.add(this);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getFatorConversao() {
        return fatorConversao;
    }

    public void setFatorConversao(double fatorConversao) {
        this.fatorConversao = fatorConversao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public static UnidadeDeMedida[] getUnidades() {
        return unidadesInstanciadas.toArray(new UnidadeDeMedida[0]);
    }

    @Override
    public String toString() {
        return nome;
    }
}
