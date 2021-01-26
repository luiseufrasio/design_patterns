package structural.decorator;

public class Main {

	public static void main(String[] args) {
		var input = String.format("Name\t\tSalary\n%s\t%d\n%s\t%d\n", 
			"John Smith", 100000, "Steve Jobs", 912000);
		var filePath = "OutputFile.txt";
		
		DataSourceDecorator encodedDataSource = 
			new CompressionDecorator(
				new EncryptionDecorator(
					new FileDataSource(filePath)));
		
		encodedDataSource.writeData(input);
		DataSource plainDataSource = new FileDataSource(filePath);
		
		System.out.println("- Input --------------");
		System.out.println(input);
		
		System.out.println("- Encoded --------------------------------------------------------------------------------------");
		System.out.println(plainDataSource.readData());
		System.out.println();
		
		System.out.println("- Decoded ------------");
		System.out.println(encodedDataSource.readData());
	}

}