package Soal3;

public class Vehicle {

    private final int maxFuel;
    private int remainingFuel;

    public Vehicle(final int maxFuel) {
        this.maxFuel = maxFuel;
        this.remainingFuel = maxFuel;
    }

    public int getMaxFuel() {
        return this.maxFuel;
    }

    public int getRemainingFuel() {
        return this.remainingFuel;
    }

    public void setRemainingFuel(final int remainingFuel) {
        this.remainingFuel = remainingFuel;
    }

    public void accelerate() {
        this.remainingFuel--;
    }
}
