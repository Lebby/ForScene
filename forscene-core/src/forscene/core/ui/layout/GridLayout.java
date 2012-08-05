/*
 * 
 */
package forscene.core.ui.layout;

import forscene.core.entities.AbstractSceneObject;
import forscene.exceptions.NoNameException;

// TODO: Auto-generated Javadoc
/**
 * The Class GridLayout.
 */
public class GridLayout extends AbstractLayout {

  /** The columns. */
  private int columns;

  /** The rows. */
  private int rows;

  /** The curr rows. */
  private int currCols = 0, currRows = 0;

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.ui.layout.ILayout#layout(forscene.core.entities.
   * AbstractSceneObject)
   */
  public void layout(AbstractSceneObject<?> object) {
    try {
      layout(object, currRows, currCols);
    } catch (NoNameException e) {
      e.printStackTrace();
    }
  }

  /**
   * Layout.
   * 
   * @param object
   *          the object
   * @param row
   *          the row
   * @param column
   *          the column
   * @throws NoNameException
   *           the no name exception
   */
  public void layout(AbstractSceneObject<?> object, int row, int column)
      throws NoNameException {
    object.getRoot().setTranslation((row * getHeight()) / rows,
        (column * getWidth()) / columns);
  }

  /**
   * Adds the scene object.
   * 
   * @param object
   *          the object
   * @param row
   *          the row
   * @param column
   *          the column
   * @throws NoNameException
   *           the no name exception
   */
  public void addSceneObject(AbstractSceneObject<?> object, int row, int column)
      throws NoNameException {
    layout(object, row, column);
    super.addSceneObject(object);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractSceneObject#build()
   */
  @Override
  public void build() {

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.ISceneObject#updateState()
   */
  public void updateState() {
    // TODO Auto-generated method stub

  }

  /**
   * Gets the columns.
   * 
   * @return the column
   */
  public int getColumns() {
    return columns;
  }

  /**
   * Sets the columns.
   * 
   * @param column
   *          the column to set
   */
  public void setColumns(int column) {
    columns = column;
  }

  /**
   * Gets the rows.
   * 
   * @return the rows
   */
  public int getRows() {
    return rows;
  }

  /**
   * Sets the rows.
   * 
   * @param rows
   *          the rows to set
   */
  public void setRows(int rows) {
    this.rows = rows;
  }
}