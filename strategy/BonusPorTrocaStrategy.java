package strategy;

public class BonusPorTrocaStrategy implements IPoliticaComercialStrategy {
    private double valorBonus;

    public BonusPorTrocaStrategy(double valorBonus) {
        this.valorBonus = valorBonus;
    }

    @Override
    public double aplicar(double valorOriginal) {
        double resultado = valorOriginal - valorBonus;
        return resultado > 0 ? resultado : 0;
    }
}
