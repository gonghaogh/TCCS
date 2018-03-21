package atoz.tc.codeservice.controller;

import java.util.List;
import java.util.Map;

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
	@RequestMapping
    public String index(){
        return "Hello World!";
    }
	@RequestMapping(value="/getRule")
	public Map<String,List<CodeRule>> getRule(String partTypeId){
		return codeRuleService.getRule(partTypeId);
	}
}
