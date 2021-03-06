package Role;
/**
 * This interface sets final integer parameters to be with meaningful name
 * @author Sagi Entenberg
 * @author Almog Yamin
 */
public interface UserStatus {

	public static final int USER=1;
	public static final int READER=2;
	public static final int LIBARYWORKER=3;
	public static final int QUALIFIEDEDITOR=4;
	public static final int LIBRRIAN=5;
	public static final int MANAGER=6;
	
	public static final int DISCONNECTED=0;
	public static final int CONNECTED=1;
	public static final int LOCK=2;

	public static final int NONE=0; //for new user without subscription (user but not reader)
	public static final int SINGLE=1;
	public static final int MONTHLY=2;
	public static final int YEARLY=3;
	
	public static final int FNAMESIZE=15;
	public static final int LNAMESIZE=25;
}
