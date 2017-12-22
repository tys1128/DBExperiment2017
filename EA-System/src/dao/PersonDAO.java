package dao;

public interface PersonDAO {

	boolean canLogin(String id,String password);
	String getName(String id);
	void close();
}
