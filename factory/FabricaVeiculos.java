package factory;

import model.*;
import java.util.*;

public class FabricaVeiculos {
    // Factory Method para criar veículos
    public static Veiculo criarVeiculo(TipoVeiculo tipo, String modelo, int ano, double precoBase, Map<String, Object> extras) {
        // Validações dos parâmetros essenciais
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("O modelo do veículo não pode ser nulo ou vazio.");
        }
        if (ano <= 0) {
            throw new IllegalArgumentException("O ano do veículo deve ser um valor positivo.");
        }
        if (precoBase <= 0) {
            throw new IllegalArgumentException("O preço base do veículo deve ser um valor positivo.");
        }
        switch (tipo) {
            case CARRO_NOVO:
                String cor = (String) extras.getOrDefault("cor", "Branco");
                List<String> opcionais = (List<String>) extras.getOrDefault("opcionais", new ArrayList<String>());
                return new CarroNovo(modelo, ano, precoBase, cor, opcionais);
            case CARRO_USADO:
                int km = (int) extras.getOrDefault("quilometragem", 0);
                String revisoes = (String) extras.getOrDefault("historicoRevisoes", "Sem histórico");
                String estado = (String) extras.getOrDefault("estadoConservacao", "Bom");
                return new CarroUsado(modelo, ano, precoBase, km, revisoes, estado);
            case MOTO:
                int cilindrada = (int) extras.getOrDefault("cilindrada", 125);
                String tipoMotor = (String) extras.getOrDefault("tipoMotor", "4 tempos");
                return new Moto(modelo, ano, precoBase, cilindrada, tipoMotor);
        }
        // Nunca será alcançado devido ao uso do enum
        throw new IllegalArgumentException("Tipo de veículo inválido.");
    }
}
