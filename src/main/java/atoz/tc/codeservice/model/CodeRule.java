package atoz.tc.codeservice.model;

public class CodeRule {
	private String partTypeId;
	private String codeField;
	private String codeType;
	private int codeSort;
	private int flowLength;
	private String ifPk;
	
	public CodeRule(String partTypeId, String codeField, String codeType, int codeSort, int flowLength, String ifPk) {
		super();
		this.partTypeId = partTypeId;
		this.codeField = codeField;
		this.codeType = codeType;
		this.codeSort = codeSort;
		this.flowLength = flowLength;
		this.ifPk = ifPk;
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
	public int getFlowLength() {
		return flowLength;
	}
	public void setFlowLength(int flowLength) {
		this.flowLength = flowLength;
	}
	public String getIfPk() {
		return ifPk;
	}
	public void setIfPk(String ifPk) {
		this.ifPk = ifPk;
	}
	
}
