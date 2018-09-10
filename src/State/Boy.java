package State;

public class Boy {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void pursue(MM mm)
	{
		//温暖的花
		Gift g = new WarmGift(new Flower());
		//狂野的戒指
		Gift g2 = new WildGift(new Ring());
		give(g, mm);
	}
	
	public void give(Gift g, MM m)
	{
		
	}
}
