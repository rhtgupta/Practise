package dp_builder;

public class Vehicle {
    private String engine;
    private int wheels;
    private int airbags;

    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.airbags = builder.airbags;
    }

    public String getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public int getAirbags() {
        return airbags;
    }

    public static class VehicleBuilder {
        private String engine;
        private int wheels;
        private int airbags;

        public VehicleBuilder(String engine, int wheels) {
            this.engine = engine;
            this.wheels = wheels;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }

    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle.VehicleBuilder("car", 4).setAirbags(2).build();
        System.out.println(vehicle.getEngine());
        System.out.println(vehicle.getWheels());
        System.out.println(vehicle.getAirbags());
    }
}
