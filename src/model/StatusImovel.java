package model;

public enum StatusImovel {
    PLANTA(-1), CONSTRUCAO(0), PRONTO(1);
    private int valor;

    StatusImovel(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
