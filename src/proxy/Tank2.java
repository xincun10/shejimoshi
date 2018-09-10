package proxy;

public class Tank2 extends Tank {

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		// TODO Auto-generated method stub
		super.move();
		long end = System.currentTimeMillis();
		System.out.println("time:"+(end-start));
	}
	
}
