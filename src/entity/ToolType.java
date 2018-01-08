package entity;

public class ToolType {
	private int toolTypeID; //工具类别ID,（数据库自增的，这个属性不要自己插入）
	private String toolTypeName; //工具类别名称
	public int getToolTypeID() {
		return toolTypeID;
	}
	public void setToolTypeID(int toolTypeID) {
		this.toolTypeID = toolTypeID;
	}
	public String getToolTypeName() {
		return toolTypeName;
	}
	public void setToolTypeName(String toolTypeName) {
		this.toolTypeName = toolTypeName;
	}
	

}
