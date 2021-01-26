package creational.abstract_factory;

public class WindowsCheckBox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckBox.");
    }
}
