package command;

public class searchCommand<E extends DBtranslation> extends deleteCommand<E> {

	private static final long serialVersionUID = 1L;
	private String filedsToSearch; // filedsTosearch is need to look like "a,c,v,d..."

	public searchCommand(String selectSentence,E table1,String whereSentence) {
		super(table1, whereSentence);
		filedsToSearch=selectSentence;
	}
	public searchCommand(String selectSentence,String whereSentence) {
		super(whereSentence);
		filedsToSearch=selectSentence;
	}
	public String getfiledsToSearch()
	{
		return filedsToSearch;
	}
}
