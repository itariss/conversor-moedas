package ConversorMoedas;

import java.text.DecimalFormat;

public enum Moeda {
    BRL, USD, EUR;

    private double cotacao;
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

    public double converte(Moeda moeda) {

        double quantidade = this.getQuantidade();


        if(Moeda.this.equals(Moeda.BRL)) {
            switch (moeda) {
                case USD, EUR -> {
                    return cotacao = quantidade * 0.20;
                }
            }

        }

        if (Moeda.this.equals(Moeda.USD)) {
            switch (moeda) {
                case USD, EUR -> {
                    return cotacao = quantidade;
                }
                case BRL -> {
                    return cotacao =  quantidade * 5.11;
                }
            }

        }

        if (Moeda.this.equals(Moeda.EUR)) {
            switch (moeda) {
                case USD, EUR -> {
                    return cotacao = quantidade;
                }
                case BRL -> {
                    return cotacao = quantidade * 5.90;
                }
            }
        }

        return cotacao;
    }
}
