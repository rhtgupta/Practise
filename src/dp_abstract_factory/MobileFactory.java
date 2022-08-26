package dp_abstract_factory;

public class MobileFactory extends AbstractDeviceFactory {
    @Override
    public Device getDevice(DeviceType type) {
        Device device = null;
        switch (type) {
            case I_PHONE -> device = new Iphone();
            case ONE_PLUS -> device = new OnePlus();
        }
        return device;
    }
}
