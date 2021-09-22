package model;

public enum TipoImovel {
    LOTE('l'), CASA('c'), APARTAMENTO('a'), RURAL('r');

    private char valor;

    TipoImovel(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return valor;
    }
}
