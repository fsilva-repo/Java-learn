package poo.base.createCsvFile;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileInput = "/home/arcade/Workstation/JavaLearning/src/poo/base/createCsvFile/src/index.csv";
        String fileOutput = "/home/arcade/Workstation/JavaLearning/src/poo/base/createCsvFile/out/summary.csv";

        System.out.println("Iniciando análise de vendas...");

        // 1. Ler os dados
        List<Sales> sales = SalesAnalysis.readFile(fileInput);

        if (sales.isEmpty()) {
            System.out.println("Nenhum dado encontrado para processar.");
            return;
        }

        // 2. Exportar os dados processados
        Summary.saveFileCsv(sales, fileOutput);
        
        System.out.println("Processo concluído.");
    }
}
