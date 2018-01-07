package Entity;

public class ToolType {
	private int ToolTypeID; //工具类别ID,（数据库自增的，这个属性不要自己插入）
	private String ToolTypeName; //工具类别名称
	public int getToolTypeID() {
		return ToolTypeID;
	}
	public void setToolTypeID(int toolTypeID) {
		ToolTypeID = toolTypeID;
	}
	public String getToolTypeName() {
		return ToolTypeName;
	}
	public void setToolTypeName(String toolTypeName) {
		ToolTypeName = toolTypeName;
	}

}
