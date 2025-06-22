package strategy;

public class DescontoPercentualStrategy implements IPoliticaComercialStrategy {
    private double percentual;

    public DescontoPercentualStrategy(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double aplicar(double valorOriginal) {
        return valorOriginal * (1 - percentual);
    }
}
