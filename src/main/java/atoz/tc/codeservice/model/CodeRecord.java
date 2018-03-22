package atoz.tc.codeservice.model;

public class CodeRecord {
	private String recordPk;
	private String nextNumber;
	public CodeRecord(String recordPk, String nextNumber) {
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
	public String getNextNumber() {
		return nextNumber;
	}
	public void setNextNumber(String nextNumber) {
		this.nextNumber = nextNumber;
	}
	
	
}
