package Command;

public class MM {
	public void order(Boy b)
	{
		Command c1 = new ShoppingCommand();
		b.addCommand(c1);
		Command c2 = new HugCommand();
		b.addCommand(c2);
		b.executeCommands();
	}
}
