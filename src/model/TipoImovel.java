package model;

/**
 * Enum do tipo do imóvel
 * @author Carlos Daniel Nascimento
 *
 */
public enum TipoImovel {
    LOTE('l'), CASA('c'), APARTAMENTO('a'), RURAL('r');

    private char valor;
    
    /**
     * Construtor do tipo do imóvel
     * @param valor Valor do tipo do imóvel
     */
    TipoImovel(char valor) {
        this.valor = valor;
    }
    
    /**
     * Obter tipo do imóvel
     * @return valor
     */
    public char getValor() {
        return valor;
    }
}
