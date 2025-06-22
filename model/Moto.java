package model;

public class Moto extends Veiculo {
    private int cilindrada;
    private String tipoMotor;

    public Moto(String modelo, int ano, double precoBase, int cilindrada, String tipoMotor) {
        super(modelo, ano, precoBase);
        this.cilindrada = cilindrada;
        this.tipoMotor = tipoMotor;
    }

    @Override
    public double calcularPrecoFinal() {
        return precoBase;
    }

    public int getCilindrada() { return cilindrada; }
    public String getTipoMotor() { return tipoMotor; }

    @Override
    public String toString() {
        return super.toString() + String.format(", Cilindrada: %dcc, Motor: %s", cilindrada, tipoMotor);
    }
}
