package atoz.tc.codeservice.model;

public class CodeRule {
	private String partTypeId;
	private String codeField;
	private String codeType;
	private int codeSort;
	
	public CodeRule(String partTypeId, String codeField, String codeType, int codeSort) {
		super();
		this.partTypeId = partTypeId;
		this.codeField = codeField;
		this.codeType = codeType;
		this.codeSort = codeSort;
	}
	public String getPartTypeId() {
		return partTypeId;
	}
	public void setPartTypeId(String partTypeId) {
		this.partTypeId = partTypeId;
	}
	public String getCodeField() {
		return codeField;
	}
	public void setCodeField(String codeField) {
		this.codeField = codeField;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public int getCodeSort() {
		return codeSort;
	}
	public void setCodeSort(int codeSort) {
		this.codeSort = codeSort;
	}
	
}
