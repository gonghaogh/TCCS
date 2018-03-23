package atoz.tc.codeservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import atoz.tc.codeservice.model.CodeFlow;

@Repository
public class CodeFlowRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public CodeFlow queryByFieldValue(CodeFlow codeFlow) {
		String sql = "select part_type_id, flow_field,code_field,code_field_value,min_number,max_number"
				+ "from CODE_FLOW where part_type_id=? and code_field=? and code_field_value=?";
		List<CodeFlow> list = this.jdbcTemplate.query(sql,
				(rs, rowNum) -> new CodeFlow(rs.getString("partTypeId"), rs.getString("flowField"),
						rs.getString("codeField"), rs.getString("codeFieldValue"), rs.getInt("minNumber"),
						rs.getInt("maxNumber")),
				codeFlow.getPartTypeId(), codeFlow.getCodeField(), codeFlow.getCodeFieldValue());
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public CodeFlow queryByField(CodeFlow codeFlow) {
		String sql = "select part_type_id, flow_field,code_field,code_field_value,min_number,max_number"
				+ "from CODE_FLOW where part_type_id=? and code_field=?";
		List<CodeFlow> list = this.jdbcTemplate.query(sql,
				(rs, rowNum) -> new CodeFlow(rs.getString("partTypeId"), rs.getString("flowField"),
						rs.getString("codeField"), rs.getString("codeFieldValue"), rs.getInt("minNumber"),
						rs.getInt("maxNumber")),
				codeFlow.getPartTypeId(), codeFlow.getCodeField());
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public String insert(CodeFlow codeFlow) {
		String sql = "insert into  CODE_SORT(PART_TYPE_ID,FLOW_FIELD,CODE_FIELD,CODE_FIELD_VALUE,MIN_NUMBER,MAX_NUMBER,CREATED_ON,MODIFIED_ON) values(?,?,?,?,?,?,?)";
		int  i =this.jdbcTemplate.update(sql, codeFlow.getPartTypeId(),codeFlow.getFlowField(),codeFlow.getCodeField(),codeFlow.getCodeFieldValue(),codeFlow.getMinNumber(),codeFlow.getMaxNumber());

		if (i == 1) {
			return "SUCCESS";
		} else {
			return "FAILURE";
		}
	}

	public String deleteByField(String partTypeId) {
		if(partTypeId==null||partTypeId=="") return "FAILURE";
		String sql = "delete from CODE_FLOW where part_type_id=?";
		int i = this.jdbcTemplate.update(sql, partTypeId);
		if(i>=1) {
			return "SUCCESS";
		}else {
			return "FAILURE";
		}
	}
}

