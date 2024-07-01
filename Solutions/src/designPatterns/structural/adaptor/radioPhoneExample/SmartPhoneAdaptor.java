package designPatterns.structural.adaptor.radioPhoneExample;

public class SmartPhoneAdaptor implements OldRadio {

    private final SmartPhone smartPhone;

    public SmartPhoneAdaptor(SmartPhone smartPhone) {
        this.smartPhone = smartPhone;
    }

    @Override
    public void playCassette() {
        smartPhone.playMusicFromSmartPhone();
    }
}
