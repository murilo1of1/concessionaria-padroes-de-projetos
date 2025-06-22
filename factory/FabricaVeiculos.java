package factory;

import model.*;
import java.util.*;

public class FabricaVeiculos {
    // Factory Method para criar veículos
    public static Veiculo criarVeiculo(String tipo, String modelo, int ano, double precoBase, Map<String, Object> extras) {
        switch (tipo.toLowerCase()) {
            case "carronovo":
                String cor = (String) extras.getOrDefault("cor", "Branco");
                List<String> opcionais = (List<String>) extras.getOrDefault("opcionais", new ArrayList<String>());
                return new CarroNovo(modelo, ano, precoBase, cor, opcionais);
            case "carrousado":
                int km = (int) extras.getOrDefault("quilometragem", 0);
                String revisoes = (String) extras.getOrDefault("historicoRevisoes", "Sem histórico");
                String estado = (String) extras.getOrDefault("estadoConservacao", "Bom");
                return new CarroUsado(modelo, ano, precoBase, km, revisoes, estado);
            case "moto":
                int cilindrada = (int) extras.getOrDefault("cilindrada", 125);
                String tipoMotor = (String) extras.getOrDefault("tipoMotor", "4 tempos");
                return new Moto(modelo, ano, precoBase, cilindrada, tipoMotor);
            default:
                throw new IllegalArgumentException("Tipo de veículo desconhecido: " + tipo);
        }
    }
}
