package forscene.core.ui.layout;

import forscene.core.entities.AbstractSceneObject;
import forscene.exceptions.NoNameException;

public class GridLayout extends AbstractLayout{
	private int columns;
	private int rows;
	private int currCols=0,currRows=0;
	
	public void layout(AbstractSceneObject<?> object) {
		try {
			layout(object,currRows,currCols);
		} catch (NoNameException e) {
			e.printStackTrace();
		}
	}
	
	public void layout(AbstractSceneObject<?> object, int row, int column) throws NoNameException
	{
		object.getRoot().setTranslation(row*getHeight()/rows, column*getWidth()/columns);
	}
	
	
	public void addSceneObject(AbstractSceneObject<?> object,int row, int column)
			throws NoNameException 
	{
		layout(object,row,column);
		super.addSceneObject(object);
	}

	@Override
	public void build() {
		
	}

	
	public void updateState() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the column
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumns(int column) {
		this.columns = column;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
}