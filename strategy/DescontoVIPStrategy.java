package strategy;

public class DescontoVIPStrategy implements IPoliticaComercialStrategy {
    private static final double PERCENTUAL_VIP = 0.07; // 7%

    @Override
    public double aplicar(double valorOriginal) {
        return valorOriginal * (1 - PERCENTUAL_VIP);
    }
}
