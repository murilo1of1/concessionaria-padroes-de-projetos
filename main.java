import model.*;
import factory.FabricaVeiculos;
import strategy.*;
import context.ContextoVendaVeiculo;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Demonstração do Factory Method
        Map<String, Object> extrasNovo = new HashMap<>();
        extrasNovo.put("cor", "Vermelho");
        extrasNovo.put("opcionais", Arrays.asList("Ar Condicionado", "Direção Hidráulica"));
        Veiculo carroNovo = FabricaVeiculos.criarVeiculo("carronovo", "Civic", 2024, 120000, extrasNovo);

        Map<String, Object> extrasUsado = new HashMap<>();
        extrasUsado.put("quilometragem", 50000);
        extrasUsado.put("historicoRevisoes", "Completo");
        extrasUsado.put("estadoConservacao", "Ótimo");
        Veiculo carroUsado = FabricaVeiculos.criarVeiculo("carrousado", "Corolla", 2018, 80000, extrasUsado);

        Map<String, Object> extrasMoto = new HashMap<>();
        extrasMoto.put("cilindrada", 300);
        extrasMoto.put("tipoMotor", "2 tempos");
        Veiculo moto = FabricaVeiculos.criarVeiculo("moto", "CB300", 2023, 25000, extrasMoto);

        System.out.println("--- Veículos Criados (Factory Method) ---");
        System.out.println(carroNovo);
        System.out.println(carroUsado);
        System.out.println(moto);

        // Demonstração do Strategy
        IPoliticaComercialStrategy desconto10 = new DescontoPercentualStrategy(0.10);
        IPoliticaComercialStrategy bonusTroca = new BonusPorTrocaStrategy(5000);
        IPoliticaComercialStrategy descontoVIP = new DescontoVIPStrategy();

        ContextoVendaVeiculo contexto = new ContextoVendaVeiculo(carroNovo, desconto10);
        System.out.println("\n--- Preço com Desconto Percentual (10%) ---");
        System.out.printf("%s: R$ %.2f\n", contexto.getVeiculo().getModelo(), contexto.calcularPrecoComDesconto());

        contexto.setPolitica(bonusTroca);
        System.out.println("\n--- Preço com Bônus por Troca (R$5000) ---");
        System.out.printf("%s: R$ %.2f\n", contexto.getVeiculo().getModelo(), contexto.calcularPrecoComDesconto());

        contexto.setPolitica(descontoVIP);
        System.out.println("\n--- Preço com Desconto VIP (7%) ---");
        System.out.printf("%s: R$ %.2f\n", contexto.getVeiculo().getModelo(), contexto.calcularPrecoComDesconto());
    }
}
