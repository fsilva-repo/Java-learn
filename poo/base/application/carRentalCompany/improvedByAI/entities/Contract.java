package poo.base.application.carRentalCompany.improvedByAI.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Contract {
    private final LocalDateTime locationDate;
    private final double rentalPerHour;
    private final double rentalPerDay;
    private final Client client;
    private final Vehicle vehicle;

    // Resultados do cálculo
    private String durationTime;
    private String durationDays;
    private String warning;
    private String amountToPay;
    private String total;

    private Contract(Builder builder) {
        this.locationDate = builder.locationDate;
        this.rentalPerHour = builder.rentalPerHour;
        this.rentalPerDay = builder.rentalPerDay;
        this.client = builder.client;
        this.vehicle = builder.vehicle;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private double rentalPerDay;
        private double rentalPerHour;
        private LocalDateTime locationDate;
        private Client client;
        private Vehicle vehicle;

        public Builder rentalPerDay(double rentalPerDay) {this.rentalPerDay = rentalPerDay;return this;}
        public Builder rentalPerHour(double rentalPerHour) {this.rentalPerHour = rentalPerHour;return this;}
        public Builder client(Client client) {this.client = client;return this;}
        public Builder vehicle(Vehicle vehicle) {this.vehicle = vehicle;return this;}
        public Builder locationDate(String locationDate) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            this.locationDate = LocalDateTime.parse(locationDate, formatter);
            return this;
        }
        public Contract build() {return new Contract(this);}
    }

    // Getters
    public LocalDateTime getLocationDate() { return locationDate; }
    public double getRentalPerHour() { return rentalPerHour; }
    public double getRentalPerDay() { return rentalPerDay; }
    public Client getClient() { return client; }
    public Vehicle getVehicle() { return vehicle; }
    public String getDurationTime() { return durationTime; }
    public String getDurationDays() { return durationDays; }
    public String getWarning() { return warning; }
    public String getAmountToPay() { return amountToPay; }
    public String getTotal() { return total; }

    // Cálculo principal
    public void calculator() {
        LocalDateTime rentalCompleted = LocalDateTime.now();
        long days = ChronoUnit.DAYS.between(locationDate, rentalCompleted);
        Duration duration = Duration.between(locationDate, rentalCompleted);
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();

        double valuePerHour = 0;
        double valuePerDay = 0;

        if (days > 0) {
            valuePerDay = days * rentalPerDay;
        }

        if (hours < 12) {
            valuePerHour = hours * rentalPerHour;
            if (minutes > 10) {
                valuePerHour += rentalPerHour;
                warning = "Ultrapassou a tolerância de 10min";
            }
        } else {
            valuePerDay += rentalPerDay; // Acima de 12h = cobrar 1 dia extra
            if (minutes > 10) {
                warning = "Ultrapassou a tolerância de 10min";
            }
        }

        durationTime = String.format("Tempo de duração %d:%02d", hours, minutes);
        durationDays = String.format("Dias de duração: %d", days);
        amountToPay = String.format("Valor por hora R$ %.2f", valuePerHour);
        total = String.format("Total R$ %.2f", valuePerHour + valuePerDay);
    }
}