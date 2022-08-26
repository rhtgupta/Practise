package dp_abstract_factory;

public class LaptopFactory extends AbstractDeviceFactory {
    @Override
    public Device getDevice(DeviceType type) {
        Device device = null;
        switch (type) {
            case HP -> device = new Hp();
            case DELL -> device = new Dell();
        }
        return device;
    }
}
