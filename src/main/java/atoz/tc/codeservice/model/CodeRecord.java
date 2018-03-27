package atoz.tc.codeservice.model;

public class CodeRecord {
	private String recordPk;
	private int nextNumber;
	public CodeRecord() {
		super();
	}
	public CodeRecord(String recordPk, int nextNumber) {
		super();
		this.recordPk = recordPk;
		this.nextNumber = nextNumber;
	}
	public String getRecordPk() {
		return recordPk;
	}
	public void setRecordPk(String recordPk) {
		this.recordPk = recordPk;
	}
	public int getNextNumber() {
		return nextNumber;
	}
	public void setNextNumber(int nextNumber) {
		this.nextNumber = nextNumber;
	}
	
	
}
