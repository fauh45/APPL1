package Soal3;

public class FuelPump {
    public void reFuel(final Vehicle vehicle) {
        // NOTE : Dianggap isi full tank terus
        vehicle.setRemainingFuel(vehicle.getMaxFuel());
    }
}
