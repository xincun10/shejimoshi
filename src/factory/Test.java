package factory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehicleFactory factory = new CarFactory();
		Moveable m = factory.create();
		m.run();
	}

}
