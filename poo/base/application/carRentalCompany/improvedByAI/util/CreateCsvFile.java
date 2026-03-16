package poo.base.application.carRentalCompany.improvedByAI.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import poo.base.application.carRentalCompany.improvedByAI.entities.Contract;

public class CreateCsvFile {
    private final String file;
    private final String path;
    private final boolean overwrite;
    private final Contract contract;

    private CreateCsvFile(Builder builder) {
        this.file = builder.file;
        this.path = builder.path;
        this.overwrite = builder.overwrite;
        this.contract = builder.contract;
    }

    public static class Builder {
        private String file = "contrato.csv";
        private String path = "./";
        private boolean overwrite = true;
        private Contract contract;

        public Builder file(String file) {this.file = file;return this;}
        public Builder path(String path) {this.path = path;return this;}
        public Builder contract(Contract contract) {this.contract = contract;return this;}
        public Builder overwrite(boolean overwrite) {this.overwrite = overwrite;return this;}
        public CreateCsvFile build() {return new CreateCsvFile(this);}
    }

    public void write() throws IOException {
        Path dirPath = Paths.get(path);
        if (!Files.exists(dirPath)) {
            try {
                Files.createDirectories(dirPath);
            } catch (IOException e) {
                System.err.println("Falha ao criar diretório: " + e.getMessage());
                return;
            }
        }

        Path filePath = dirPath.resolve(file);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.toFile(), overwrite))) {
            // Cabeçalho cliente
            bw.write("cliente_nome;cnh;endereço");
            bw.newLine();
            bw.write(String.format("%s;%d;%s", contract.getClient().name(), contract.getClient().cnh(), contract.getClient().address()));
            bw.newLine();

            // Cabeçalho veículo
            bw.write("veiculo_modelo;ano;cor;chassi");
            bw.newLine();
            bw.write(String.format("%s;%s;%s;%s", 
                contract.getVehicle().model(), 
                contract.getVehicle().age(), 
                contract.getVehicle().color(), 
                contract.getVehicle().chassis()));
            bw.newLine();

            // Cabeçalho contrato
            bw.write("data_locação;valor_por_hora;valor_por_dia;horas_decorrid");
    }

}


}








