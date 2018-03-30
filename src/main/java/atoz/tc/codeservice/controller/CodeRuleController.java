package atoz.tc.codeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import atoz.tc.codeservice.model.CodeRule;
import atoz.tc.codeservice.service.CodeRuleService;

@RestController
@RequestMapping(value="/code")
public class CodeRuleController {
	@Autowired
	private CodeRuleService codeRuleService;
	@RequestMapping(value="/addRule")
    public String addRule(String ruleJson){
        return codeRuleService.addRule(ruleJson);
    }
	@RequestMapping(value="/getRule")
	public List<CodeRule> getRule(String partTypeId){
		return codeRuleService.getRule(partTypeId);
	}
}
