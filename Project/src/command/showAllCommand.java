package command;

public class showAllCommand<E extends DBtranslation> extends command<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public showAllCommand(E table1) {
		super(table1);
	}
	public showAllCommand() {
		super();
	}

}
