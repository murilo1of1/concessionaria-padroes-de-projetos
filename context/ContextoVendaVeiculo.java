package context;

import model.Veiculo;
import strategy.IPoliticaComercialStrategy;

public class ContextoVendaVeiculo {
    private Veiculo veiculo;    
    private IPoliticaComercialStrategy politica;

    public ContextoVendaVeiculo(Veiculo veiculo, IPoliticaComercialStrategy politica) {
        this.veiculo = veiculo;
        this.politica = politica;
    }

    public void setPolitica(IPoliticaComercialStrategy politica) {
        this.politica = politica;
    }

    public double calcularPrecoComDesconto() {
        double precoBase = veiculo.calcularPrecoFinal();
        return politica.aplicar(precoBase);
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
}
