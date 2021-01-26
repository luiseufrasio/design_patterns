package creational.abstract_factory;

public class MacOSCheckBox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckBox.");
    }
}
