package atoz.tc.codeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import atoz.tc.codeservice.dao.CodeRuleRepository;
import atoz.tc.codeservice.model.CodeRule;

@Service
public class CodeRuleService {
	@Autowired
	private CodeRuleRepository codeRuleRepository;
	public List<CodeRule> getRule(String partTypeId){
		return this.codeRuleRepository.getRule(partTypeId);
	}
	public String addRule(String ruleJson){
		String result="FAILURE";
		List<CodeRule> list = JSONObject.parseArray(ruleJson,CodeRule.class);
		String partTypeId = list.get(0).getPartTypeId();
		this.codeRuleRepository.delByPartTypeId(partTypeId);
		result = this.codeRuleRepository.addRuleBatch(list);
		return result;
	}
}
