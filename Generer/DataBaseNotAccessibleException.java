
/**
 * Exception throwed when a database is not accessible anymore.
 */
class DataBaseNotAccessibleException extends OurException {
  /**
   * Constructor. Bref ne nous attardons pas l� dessus je ne pense pas que �a vaille le coup...
   */
  public DataBaseNotAccessibleException(DataBase database, String reason) {
  }

  /**
   * The database which is not accessible.
   */
  protected DataBase database;

}
