package dp_abstract_factory;

public class FactoryGenerator {
    public static AbstractDeviceFactory getDeviceFactory(FactoryType type) {
        AbstractDeviceFactory factory = null;
        switch (type) {
            case LAPTOP_FACTORY -> factory = new LaptopFactory();
            case MOBILE_FACTORY -> factory = new MobileFactory();
        }
        return factory;
    }
}
