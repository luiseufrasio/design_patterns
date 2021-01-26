package structural.decorator;

public class DataSourceDecorator implements DataSource {
    private DataSource wrappee;
    
    public DataSourceDecorator(DataSource ds) {
        this.wrappee = ds;
    }
    
    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}