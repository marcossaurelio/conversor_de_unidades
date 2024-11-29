package br.unifor.ead.conversor.modelos;

import java.util.ArrayList;

public class Categoria {

    private static int contadorId = 0;
    private int id;
    private String nome;
    private static ArrayList<Categoria> categoriasInstanciadas = new ArrayList<Categoria>();

    public Categoria(String nome) {
        this.id = ++contadorId;
        this.nome = nome;
        categoriasInstanciadas.add(this);
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

    public static Categoria[] getCategorias() {
        return categoriasInstanciadas.toArray(new Categoria[0]);
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
