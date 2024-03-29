
/**
 * Adaptor of several Adaptor. Needed to merge RDF informations from under Adaptor.
 */
class CompositeAdapter extends Adapter {
  /**
   * Composite pattern.
   * These are the sub-adapters managed by this adapter.
   */
  protected IAdapter subAdapters;

  /**
   * Return true if query match to database
   */
  public boolean isQueryMatching(IQuery query) {
  }

  /**
   * Give the query to all sub adaptor which execute it and check if no errors occurs.
   */
  public RDF execute(IQuery query) throws DataBaseNotAccessibleException {
  }

  /**
   * Return the global RDF schema of sub adapters.
   */
  public RDF getLocalSchema() {
  }

}
