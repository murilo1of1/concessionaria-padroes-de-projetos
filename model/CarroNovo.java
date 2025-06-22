package model;

import java.util.*;

public class CarroNovo extends Veiculo {
    private String cor;
    private List<String> opcionais;

    public CarroNovo(String modelo, int ano, double precoBase, String cor, List<String> opcionais) {
        super(modelo, ano, precoBase);
        this.cor = cor;
        this.opcionais = opcionais != null ? opcionais : new ArrayList<>();
    }

    @Override
    public double calcularPrecoFinal() {
        double precoOpcionais = 0;
        // Supondo que cada opcional custa 1000
        precoOpcionais = opcionais.size() * 1000.0;
        return precoBase + precoOpcionais;
    }

    public String getCor() { return cor; }
    public List<String> getOpcionais() { return opcionais; }

    @Override
    public String toString() {
        return super.toString() + String.format(", Cor: %s, Opcionais: %s", cor, opcionais);
    }
}
