package poo.base.application.carRentalCompany.improvedByAI.entities;

import java.util.Objects;

public record Client(String name, int cnh, String address, Contract contract) {
    public Client {
        Objects.requireNonNull(name, "Nome não pode ser nulo");
        Objects.requireNonNull(address, "Endereço não pode ser nulo");
        Objects.requireNonNull(contract, "Contrato não pode ser nulo");
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int cnh;
        private String address;
        private Contract contract;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cnh(int cnh) {
            this.cnh = cnh;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder contract(Contract contract) {
            this.contract = contract;
            return this;
        }

        public Client build() {
            return new Client(name, cnh, address, contract);
        }
    }
}
