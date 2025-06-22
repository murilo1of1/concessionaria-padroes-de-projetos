package model;

import java.util.*;

// Classe abstrata base para veículos
public abstract class Veiculo {
    protected String modelo;
    protected int ano;
    protected double precoBase;

    public Veiculo(String modelo, int ano, double precoBase) {
        this.modelo = modelo;
        this.ano = ano;
        this.precoBase = precoBase;
    }

    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public double getPrecoBase() { return precoBase; }

    public abstract double calcularPrecoFinal();

    @Override
    public String toString() {
        return String.format("%s %d - Preço Base: %.2f", modelo, ano, precoBase);
    }
}
