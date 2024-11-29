package br.unifor.ead.conversor.util;

import java.util.ArrayList;

import br.unifor.ead.conversor.modelos.Categoria;
import br.unifor.ead.conversor.modelos.UnidadeDeMedida;

public class Factory {

    private Categoria comprimento = new Categoria("Comprimento");
    private Categoria tempo = new Categoria("Tempo");
    private Categoria velocidade = new Categoria("Velocidade");
    private Categoria massa = new Categoria("Massa");
    private Categoria armazenamentoDados = new Categoria("Armazenamento de Dados");

    private UnidadeDeMedida metro = new UnidadeDeMedida("Metro", 1, comprimento);
    private UnidadeDeMedida quilometro = new UnidadeDeMedida("Quilômetro", 1000, comprimento);
    private UnidadeDeMedida centimetro = new UnidadeDeMedida("Centimetro", 0.01, comprimento);
    private UnidadeDeMedida milimetro = new UnidadeDeMedida("Milímetro", 0.001, comprimento);
    private UnidadeDeMedida milha = new UnidadeDeMedida("Milha", 1609.34, comprimento);
    private UnidadeDeMedida jarda = new UnidadeDeMedida("Jarda", 0.9144, comprimento);
    private UnidadeDeMedida pe = new UnidadeDeMedida("Pé", 0.3048, comprimento);
    private UnidadeDeMedida polegada = new UnidadeDeMedida("Polegada", 0.0254, comprimento);
    private UnidadeDeMedida segundo = new UnidadeDeMedida("Segundo", 1, tempo);
    private UnidadeDeMedida milisegundo = new UnidadeDeMedida("Milisegundo", 0.001, tempo);
    private UnidadeDeMedida minuto = new UnidadeDeMedida("Minuto", 60, tempo);
    private UnidadeDeMedida hora = new UnidadeDeMedida("Hora", 3600, tempo);
    private UnidadeDeMedida dia = new UnidadeDeMedida("Dia", 86400, tempo);
    private UnidadeDeMedida semana = new UnidadeDeMedida("Semana", 604800, tempo);
    private UnidadeDeMedida quilometroPorHora = new UnidadeDeMedida("Quilômetro/Hora", 1, velocidade);
    private UnidadeDeMedida metroPorSegundo = new UnidadeDeMedida("Metro/Segundo", 3.6, velocidade);
    private UnidadeDeMedida milhaPorHora = new UnidadeDeMedida("Milha/Hora", 1.60934, velocidade);
    private UnidadeDeMedida no = new UnidadeDeMedida("Nó", 1.852, velocidade);
    private UnidadeDeMedida pesPorSegundo = new UnidadeDeMedida("Pés/Segundo", 1.09728, velocidade);
    private UnidadeDeMedida grama = new UnidadeDeMedida("Grama", 1, massa);
    private UnidadeDeMedida quilograma = new UnidadeDeMedida("Quilograma", 1000, massa);
    private UnidadeDeMedida miligrama = new UnidadeDeMedida("Miligrama", 1, massa);
    private UnidadeDeMedida libra = new UnidadeDeMedida("Libra", 453.592, massa);
    private UnidadeDeMedida stone = new UnidadeDeMedida("Stone", 6350.29, massa);
    private UnidadeDeMedida onca = new UnidadeDeMedida("Onça", 28.3495, massa);
    private UnidadeDeMedida kilobyte = new UnidadeDeMedida("Kilobyte", 1, armazenamentoDados);
    private UnidadeDeMedida bit = new UnidadeDeMedida("Bit", 0.000125, armazenamentoDados);
    private UnidadeDeMedida kilobit = new UnidadeDeMedida("Kilobit", 0.125, armazenamentoDados);
    private UnidadeDeMedida megabit = new UnidadeDeMedida("Megabit", 125, armazenamentoDados);
    private UnidadeDeMedida gigabit = new UnidadeDeMedida("Gigabit", 125000, armazenamentoDados);
    private UnidadeDeMedida terabit = new UnidadeDeMedida("Terabit", 125000000, armazenamentoDados);
    private UnidadeDeMedida _byte = new UnidadeDeMedida("Byte", 0.001, armazenamentoDados);
    private UnidadeDeMedida megabyte = new UnidadeDeMedida("Megabyte", 1000, armazenamentoDados);
    private UnidadeDeMedida gigabyte = new UnidadeDeMedida("Gigabyte", 1000000, armazenamentoDados);
    private UnidadeDeMedida terabyte = new UnidadeDeMedida("Terabyte", 1000000000, armazenamentoDados);


    private UnidadeDeMedida[] unidadesDeMedida = UnidadeDeMedida.getUnidades();
    private Categoria[] categorias = Categoria.getCategorias();


    public UnidadeDeMedida[] getUnidades() {
        return unidadesDeMedida;
    }

    public UnidadeDeMedida[] getUnidades(Categoria categoria) {
        ArrayList<UnidadeDeMedida> arrayListUnidades = new ArrayList<UnidadeDeMedida>();
        for (UnidadeDeMedida unidadeDeMedida : unidadesDeMedida) {
            if (unidadeDeMedida.getCategoria() == categoria) {
                arrayListUnidades.add(unidadeDeMedida);
            }
        }
        UnidadeDeMedida[] unidadesDaCategoria = arrayListUnidades.toArray(new UnidadeDeMedida[0]);
        return unidadesDaCategoria;
    }

    public UnidadeDeMedida getUnidadePorId(int id) {
        UnidadeDeMedida unidade = unidadesDeMedida[0];
        for (int i = 0; i < unidadesDeMedida.length; i++) {
            if (unidadesDeMedida[i].getId() == id) {
                unidade = unidadesDeMedida[i];
                break;
            }
        }
        return unidade;
    }

    public Categoria[] getCategorias() {
        return categorias;
    }

}
