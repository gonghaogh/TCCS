package atoz.tc.codeservice.model;

public class CodeFlow {

	private String partTypeId;
	private String flowField;
	private String codeField;
	private String codeFieldValue;
	private int minNumber;
	private int maxNumber;
	private int flowLength;
	public CodeFlow(String partTypeId, String flowField, String codeField, String codeFieldValue, int minNumber,
			int maxNumber, int flowLength) {
		super();
		this.partTypeId = partTypeId;
		this.flowField = flowField;
		this.codeField = codeField;
		this.codeFieldValue = codeFieldValue;
		this.minNumber = minNumber;
		this.maxNumber = maxNumber;
		this.flowLength = flowLength;
	}
	public String getPartTypeId() {
		return partTypeId;
	}
	public void setPartTypeId(String partTypeId) {
		this.partTypeId = partTypeId;
	}
	public String getFlowField() {
		return flowField;
	}
	public void setFlowField(String flowField) {
		this.flowField = flowField;
	}
	public String getCodeField() {
		return codeField;
	}
	public void setCodeField(String codeField) {
		this.codeField = codeField;
	}
	public String getCodeFieldValue() {
		return codeFieldValue;
	}
	public void setCodeFieldValue(String codeFieldValue) {
		this.codeFieldValue = codeFieldValue;
	}
	public int getMinNumber() {
		return minNumber;
	}
	public void setMinNumber(int minNumber) {
		this.minNumber = minNumber;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	public int getFlowLength() {
		return flowLength;
	}
	public void setFlowLength(int flowLength) {
		this.flowLength = flowLength;
	}
}
