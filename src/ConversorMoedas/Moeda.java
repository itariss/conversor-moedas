package ConversorMoedas;

import java.text.DecimalFormat;

public enum Moeda {
    BRL, USD, EUR;
    private double quantidade;
    private String simbolo;
    public void setQuantidade(String quantidade) {

        this.quantidade = Double.parseDouble(quantidade);
    }

    public double getQuantidade() {
        return quantidade;
    }

    public String getSimboloMoeda() {
        switch (Moeda.this) {
            case BRL -> {
                this.simbolo = "R$";
            }
            case USD -> {
                this.simbolo = "$";
            }
            case EUR -> this.simbolo = "€";
        }

        return this.simbolo;
    }

}
