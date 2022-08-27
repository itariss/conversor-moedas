package ConversorMoedas;

import java.text.DecimalFormat;

public enum Moeda {
    BRL, USD, EUR, ARS, CLP, GPD;
    private double quantidade;
    private String simbolo;

    private String nome;
    public void setQuantidade(String quantidade) {

        this.quantidade = Double.parseDouble(quantidade);
    }

    public String getNome() {
        switch (Moeda.this) {
            case BRL ->
                this.nome = "Real";
            case USD ->
                this.nome = "Dólar";
            case EUR ->
                this.nome = "Euro";
            case ARS ->
                this.nome = "Peso Argentino";
            case CLP ->
                this.nome = "Peso Chileno";
            case GPD ->
                this.nome = "Libra Esterlina";
        }

        return this.nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public String getSimboloMoeda() {
        switch (Moeda.this) {
            case BRL ->
                this.simbolo = "R$";
            case USD, ARS, CLP ->
                this.simbolo = "$";
            case EUR ->
                    this.simbolo = "€";
            case GPD ->
                this.simbolo = "£";
        }

        return this.simbolo;
    }

}
