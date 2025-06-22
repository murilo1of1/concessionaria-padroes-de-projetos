package model;

public class CarroUsado extends Veiculo {
    private int quilometragem;
    private String historicoRevisoes;
    private String estadoConservacao;

    public CarroUsado(String modelo, int ano, double precoBase, int quilometragem, String historicoRevisoes, String estadoConservacao) {
        super(modelo, ano, precoBase);
        this.quilometragem = quilometragem;
        this.historicoRevisoes = historicoRevisoes;
        this.estadoConservacao = estadoConservacao;
    }

    @Override
    public double calcularPrecoFinal() {
        double depreciacao = quilometragem * 0.05;
        double precoFinal = precoBase - depreciacao;
        return precoFinal > 0 ? precoFinal : 0;
    }

    public int getQuilometragem() { return quilometragem; }
    public String getHistoricoRevisoes() { return historicoRevisoes; }
    public String getEstadoConservacao() { return estadoConservacao; }

    @Override
    public String toString() {
        return super.toString() + String.format(", Km: %d, Revisões: %s, Estado: %s", quilometragem, historicoRevisoes, estadoConservacao);
    }
}
