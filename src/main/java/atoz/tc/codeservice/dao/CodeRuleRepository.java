package atoz.tc.codeservice.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import atoz.tc.codeservice.model.CodeRule;

@Repository
public class CodeRuleRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<CodeRule> getRule(String partTypeId) {
		String sql = "select t.part_type_id, t.code_field, t.code_type, t.code_sort ,t.flow_length,t.if_pk from CODE_RULE t where t.part_type_id = ?  order by t.code_sort";
		List<CodeRule> result = this.jdbcTemplate.query(sql, (rs, rowNum) -> new CodeRule(rs.getString("part_type_id"),
				rs.getString("code_field"), rs.getString("code_type"), rs.getInt("code_sort"),rs.getInt("flow_length"),rs.getString("if_pk")),partTypeId);
		return result;
	}
	//todo getitemType
	public String addRuleBatch(List<CodeRule> ruleList) {
		String sql = "INSERT INTO CODE_RULE VALUES (?,?,?,?,?,?,?,?)";
		Date now = new Date(System.currentTimeMillis());
		int[] result = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, ruleList.get(i).getPartTypeId());
				ps.setString(2, ruleList.get(i).getCodeField());
				ps.setString(3, ruleList.get(i).getCodeType());
				ps.setInt(4, ruleList.get(i).getCodeSort());
				ps.setDate(5, now);
				ps.setDate(6, now);
				ps.setInt(7, ruleList.get(i).getFlowLength());
				ps.setString(8,ruleList.get(i).getIfPk());
			}
			@Override
			public int getBatchSize() {
				return ruleList.size();
			}
		});
		if(result.length>0) {
			return "SUCCESS";
		}else {
			return "FAILURE";
		}

	}
	
	public String delByPartTypeId(String partTypeId) {
		if(partTypeId==null||partTypeId=="") return "FAILURE";
		String sql ="delete from CODE_RULE where PART_TYPE_ID = ?";
		int i = this.jdbcTemplate.update(sql,partTypeId);
		if(i>=1) {
			return "SUCCESS";
		}else {
			return "FAILURE";
		}
	}
}
