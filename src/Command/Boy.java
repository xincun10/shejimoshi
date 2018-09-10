package Command;
import java.util.*;

public class Boy {
	private List<Command> commands = new ArrayList<Command>();
	private List<Command> undoCommands = new ArrayList<Command>();
	
	public void addCommand(Command c) {
		// TODO Auto-generated method stub
		this.commands.add(c);
	}

	public void executeCommands() {
		// TODO Auto-generated method stub
		for(Command c:commands)
		{
			c.execute();
		}
	}
	
	public void undoCommands() {
		// TODO Auto-generated method stub
		for(Command c:undoCommands)
		{
			c.unDo();
		}
	}
}
