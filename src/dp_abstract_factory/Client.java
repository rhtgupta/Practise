package dp_abstract_factory;

public class Client {
    public static void main(String[] args) {
        FactoryGenerator.getDeviceFactory(FactoryType.LAPTOP_FACTORY).getDevice(DeviceType.DELL).getDetails();
    }
}
