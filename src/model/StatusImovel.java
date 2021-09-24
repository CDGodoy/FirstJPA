package model;
/**
 * Enum do status de construção do imóvel
 * @author Carlos Daniel Nascimento
 *
 */
public enum StatusImovel {
    PLANTA(-1), CONSTRUCAO(0), PRONTO(1);
    private int valor;
    /**
     * Construtor do status do imóvel
     * @param valor Valor do status de construção do imóvel
     */
    StatusImovel(int valor) {
        this.valor = valor;
    }
    /**
     * Obter o valor do imóvel
     * @return valor
     */
    public int getValor() {
        return valor;
    }
}
