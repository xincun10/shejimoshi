package Command;

public class ShoppingCommand extends Command{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("zoo");
	}

	@Override
	public void unDo() {
		// TODO Auto-generated method stub
		System.out.println("undo zoo");
	}

}
