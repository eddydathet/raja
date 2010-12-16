package Server.Translator;
import Query.DeleteQuery;
import Query.InsertQuery;
import Query.UpdateQuery;
import Server.DataBase.DataBase;


/**
 * This is our oracle translator.
 */
public class OracleTranslator extends Translator {
  public OracleTranslator(DataBase dataBase, String n3File) {
		super(dataBase, n3File);
		// TODO Auto-generated constructor stub
	}

/**
   * Execute a insert query.
   */
  public boolean insert(InsertQuery query) {
	return false;
  }

  /**
   * Execute a delete query.
   */
  public boolean delete(DeleteQuery query) {
	return false;
  }

  /**
   * Execute a update query.
   */
  public boolean update(UpdateQuery query) {
	return false;
  }

}