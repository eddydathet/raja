
/**
 * Interface of the database adaptors.
 */
interface IAdapter {
  /**
   * Distributes the query to correspondant databases and execute it.
   */
  RDF execute(IQuery query) throws DataBaseNotAccessibleException ;

  /**
   * Return true if query match to database
   */
  boolean isQueryMatching(IQuery query) ;

  /**
   * Return the local RDF schema of the adaptater.
   */
  RDF getLocalSchema() ;

}
