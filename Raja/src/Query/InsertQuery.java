package Query;
import java.util.Vector;

import Exception.MalformedQueryException;


/**
 * Represent a INSERT query
 */
public class InsertQuery extends Query {
  /**
   * List of values to insert.
   */
  protected Vector<String> value;

  /**
   * Parse the INSERT query.
   */
  public void parseQuery(String query) throws MalformedQueryException {
	  throw new MalformedQueryException("", "");
  }

  public String getQuery() {
	  return "";
  }

}