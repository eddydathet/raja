package Server.Adapter;
import Exception.DataBaseNotAccessibleException;
import Query.IQuery;
import com.hp.hpl.jena.query.ResultSet;

/**
 * Adaptor of several Adaptor. Needed to merge RDF informations from under Adaptor.
 */
public class CompositeAdapter extends Adapter {
  /**
   * Composite pattern.
   * These are the sub-adapters managed by this adapter.
   */
  protected IAdapter subAdapters;

  /**
   * Return true if query match to database
   */
  public boolean isQueryMatching(IQuery query) {
	return true;
  }

  /**
   * Give the query to all sub adaptor which execute it and check if no errors occurs.
   */
  public ResultSet execute(IQuery query) throws DataBaseNotAccessibleException {
	return null;
	  
  }

  /**
   * Return the global RDF schema of sub adapters.
   */
  public ResultSet getLocalSchema() {
	return null;
  }

}
