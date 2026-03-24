package poo.base.application.carRentalCompany.improvedByAI.entities;

import java.time.LocalDate;
import java.util.Objects;

public record Vehicle(String model, LocalDate age, String color, String chassis) {
    public Vehicle {
        Objects.requireNonNull(model, "Modelo não pode ser nulo");
        Objects.requireNonNull(age, "Ano não pode ser nulo");
        Objects.requireNonNull(color, "Cor não pode ser nula");
        Objects.requireNonNull(chassis, "Chassi não pode ser nulo");
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String model;
        private LocalDate age;
        private String color;
        private String chassis;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder age(LocalDate age) {
            this.age = age;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder chassis(String chassis) {
            this.chassis = chassis;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(model, age, color, chassis);
        }
    }
}