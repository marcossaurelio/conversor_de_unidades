package br.unifor.ead.conversor.util;

import br.unifor.ead.conversor.modelos.UnidadeDeMedida;

public class Conversor {

    private double converterParaUnidadeBasica(UnidadeDeMedida unidadeOrigem, double valorOrigem) {
        return valorOrigem * unidadeOrigem.getFatorConversao();
    }

    private double converterDeUnidadeBasica(UnidadeDeMedida unidadeDestino, double valorDestino) {
        return valorDestino / unidadeDestino.getFatorConversao();
    }

    public double converter(UnidadeDeMedida unidadeOrigem, UnidadeDeMedida unidadeDestino, double valorOrigem) {
        double valorUnidadeBasica = converterParaUnidadeBasica(unidadeOrigem, valorOrigem);
        double valorConvertido = converterDeUnidadeBasica(unidadeDestino, valorUnidadeBasica);
        return valorConvertido;
    }

}
