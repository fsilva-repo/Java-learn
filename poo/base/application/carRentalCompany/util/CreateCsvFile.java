package poo.base.application.carRentalCompany.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import poo.base.application.carRentalCompany.entities.Contract;

public class CreateCsvFile {

    private String file;
    private String path;
    private boolean overwrite;
    private Contract contract;

    private CreateCsvFile(Builder builder) {
    		this.file = builder.file;
        this.path = builder.path;
        this.overwrite = builder.overwrite;
        this.contract = builder.contract;
    }
    
    public String getFile() {return file;}
    public String getPath() {return path;}
    public boolean isOverwrite() {return overwrite;}
		public Contract getContract() {return contract;}

		public static class Builder {
	    public String file;
	    public String path;
	    public boolean overwrite;
	    public Contract contract;
	    
	    public Builder file(String file) {this.file = file;return this;}
	    public Builder path(String path) {this.path = path;return this;}
	    public Builder contract(Contract contract) {this.contract = contract;return this;}
	    public Builder overwrite(boolean overwrite) {this.overwrite = overwrite;return this;}
	    
	    public CreateCsvFile build() {
	    	return new CreateCsvFile(this);
	    }
		}
		
		public void write() {
    	if (path.length() != path.lastIndexOf("/")) path = path + "/";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + file, overwrite))) {
            bw.write("");
        		bw.write("cliente_nome;cnh;endereço;");
        		bw.newLine();
        		bw.write(contract.getClient().getName() + ";");
        		bw.write(contract.getClient().getCnh() + ";");
        		bw.write(contract.getClient().getAddress() + ";");
        		bw.newLine();
        		bw.write("veiculo_modelo;ano;cor;chassi");
        		bw.newLine();
        		bw.write(contract.getVehicle().getModel() + ";");
        		bw.write(contract.getVehicle().getAge() + ";");
        		bw.write(contract.getVehicle().getColor() + ";");
        		bw.write(contract.getVehicle().getChassis() + ";");
        		bw.newLine();
        		bw.write("data_locação;valor_por_hora;valor_por_dia;horas_decorridas;dias_decorridos;tempo_estourado;total_a_pagar");
        		bw.newLine();
        	  bw.write(contract.getLocationDate() + ";");
        	  bw.write(contract.getRentalPerHour() + ";");
        	  bw.write(contract.getRentalPerDay() + ";");
        	  bw.write(contract.getDurationTime() + ";");
        	  bw.write(contract.getDurationDays() + ";");
        	  bw.write(contract.getWarning() + ";");
        	  bw.write(contract.getTotal() + ";");
        		
        	  System.out.println(
        	  				contract.getLocationDate() + ";" +
        	  				contract.getRentalPerHour() + ";" +
        	  				contract.getRentalPerDay() + ";" +
        	  				contract.getDurationTime() + ";" +
        	  				contract.getDurationDays() + ";" +
        	  				contract.getWarning() + ";" +
        	  				contract.getTotal() + ";"
        	  		);
        	  
        } catch (IOException e) {
            System.out.println("Falha ao tentar escrever o arquivo: " + e.getMessage());
        }
    }
}


















