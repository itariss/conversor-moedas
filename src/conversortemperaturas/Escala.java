package conversortemperaturas;

public enum Escala {

    C, F, K;

    private String simbolo;

    private double valor;

    public String getSimbolo() {
        return  Escala.this.toString().split("\\(")[0].substring(0, 1);
    }

    public void setValor(String valor) {
        this.valor = Double.parseDouble(valor);
    }
    public double getValor() {
        return valor;
    }

    public double converte(String escala2) {

        String escala1 = Escala.this.toString().split("\\(")[0].substring(0, 1);
        System.out.println(escala1);
        double resultado = 0;

        if (escala1.equals("C")) { // Converte de (C) para (F) ou (K)
            resultado = escala2.equals("F") ? (Escala.valueOf(escala1).getValor() * 1.8) + 32 :
                    Escala.valueOf(escala1).getValor() + 273.15;
        }

        if(escala1.equals("F")) {
            resultado = escala2.equals("C") ? (Escala.valueOf(escala1).getValor() - 32) / 1.8:
                    ((Escala.valueOf(escala1).getValor() - 32)  / 1.8) + 273.15;
        }

        if(escala1.equals("K")) {
            resultado = escala2.equals("C") ? Escala.valueOf(escala1).getValor() - 273.15:
                    ((Escala.valueOf(escala1).getValor() - 273.15)  * 1.8) + 32;
        }

        System.out.println(resultado);

        return resultado;
    }
}


