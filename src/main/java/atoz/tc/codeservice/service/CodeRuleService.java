package atoz.tc.codeservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atoz.tc.codeservice.dao.CodeRuleRepository;
import atoz.tc.codeservice.model.CodeRule;

@Service
public class CodeRuleService {
	@Autowired
	private CodeRuleRepository codeRuleRepository;
	public Map<String,List<CodeRule>> getRule(String partTypeId){
		Map<String,List<CodeRule>> result = new HashMap<String,List<CodeRule>>();
		result.put("codeRule", codeRuleRepository.getRule(partTypeId));
		return result;
	}
}
