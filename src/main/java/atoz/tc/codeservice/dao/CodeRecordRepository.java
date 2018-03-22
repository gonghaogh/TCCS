package atoz.tc.codeservice.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import atoz.tc.codeservice.model.CodeRecord;
@Repository
public class CodeRecordRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public CodeRecord queryByPk(String recordPK) {
		String sql = "select * from CODE_RECORD where RECORD_PK = ?";
		List<CodeRecord> resultList = this.jdbcTemplate.query(sql, (rs, rowNum) -> new CodeRecord(rs.getString("RECORD_PK"),
				rs.getString("NEXT_NUMBER")),recordPK);
		if(resultList.size()!=1) return null;
		return resultList.get(0);
	}
	public String insert(CodeRecord record) {
		Date now = new Date(System.currentTimeMillis());
		String sql = "insert into CODE_RECORD values(?,?,?,?)";
		int i = this.jdbcTemplate.update(sql, record.getNextNumber(),record.getRecordPk(),now,now);
		if(i==1) {
			return "SUCCESS";
		}else {
			return "FAILURE";
		}
	}
	public String update(CodeRecord record) {
		Date now = new Date(System.currentTimeMillis());
		String sql = "update CODE_RECORD set NEXT_NUMBER=?,MODIFIED_ON=? where RECORD_PK=?";
		int i = this.jdbcTemplate.update(sql, record.getNextNumber(),now,record.getRecordPk());
		if(i==1) {
			return "SUCCESS";
		}else {
			return "FAILURE";
		}
	}
}
