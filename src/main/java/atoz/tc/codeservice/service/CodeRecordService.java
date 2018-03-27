package atoz.tc.codeservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import atoz.tc.codeservice.dao.CodeFlowRepository;
import atoz.tc.codeservice.dao.CodeRecordRepository;
import atoz.tc.codeservice.dao.CodeRuleRepository;
import atoz.tc.codeservice.model.CodeFlow;
import atoz.tc.codeservice.model.CodeRecord;
import atoz.tc.codeservice.model.CodeRule;

public class CodeRecordService {
	@Autowired
	private CodeFlowRepository codeFlowRepository;
	@Autowired
	private CodeRuleRepository codeRuleRepository;
	@Autowired
	private CodeRecordRepository codeRecordRepository;
	public String getCode(Map<String,String> map){
		String code = "";
		int currentNumber=1;
		String partTypeId = map.get("partTypeId");
		if(partTypeId==null||"".equals(partTypeId)) return "";
		if("".equals(partTypeId)) return "";
		
		List<CodeRule> codeRuleList =this.codeRuleRepository.getRule(partTypeId);
		boolean hasFlow = containsSort(codeRuleList);
		String codeKey = getCodeKey(map,codeRuleList);
		CodeRecord codeRecord = this.codeRecordRepository.queryByPk(codeKey);
		if(codeRecord==null||"".equals(codeRecord.getRecordPk())){
			if(hasFlow){
				currentNumber = getFirstNumber(map,codeRuleList,partTypeId);
				code = getCode(map,codeRuleList,currentNumber);
				codeRecord = new CodeRecord();
				codeRecord.setRecordPk(codeKey);
				codeRecord.setNextNumber(currentNumber+1);
				this.codeRecordRepository.insert(codeRecord);
			}else{
				code = getCode(map,codeRuleList,-1);
			}
		}else{
			if(hasFlow){
				currentNumber = codeRecord.getNextNumber();
				code = getCode(map,codeRuleList,currentNumber);
				codeRecord.setNextNumber(currentNumber+1);
				this.codeRecordRepository.update(codeRecord);
			}else{
				code = getCode(map,codeRuleList,-1);
			}
		}
		return code;
	}
	private boolean containsSort(List<CodeRule> list){
		boolean flag=false;
		for(CodeRule rule : list){
			if("flow".equals(rule.getCodeType())){
				flag=true;
				break;
			}
		}
		return flag;
	}
	private String getCodeKey(Map<String,String> map,List<CodeRule> ruleList){
		String codeKey = ruleList.get(0).getPartTypeId();
		if(ruleList==null||ruleList.size()==0) return "";
		for(int i=0;i<ruleList.size();i++){
			CodeRule codeRule = ruleList.get(i);
			String codeField = codeRule.getCodeField();
			String codeType = codeRule.getCodeType();
			String ifPk = codeRule.getIfPk();
			
			if("fixed".equals(codeType)){
				codeKey += codeField;
			}else if("flow".equals(codeType)){
				int flowLength = codeRule.getFlowLength();
				if("_number".equals(codeField)){
					codeKey += codeField+flowLength;
				}else{
					String codeFieldValue = map.get(codeField);
					codeKey += codeFieldValue+flowLength;
				}
			}else{
				String codeFieldValue = map.get(codeField);
				if("Y".equals(ifPk)) {
					codeKey += codeFieldValue;
				}else {
					codeKey += codeField;
				}
			}
		}
		return codeKey;
	}
	private int getFirstNumber(Map<String,String> map,List<CodeRule> ruleList,String partTypeId){
		int firstNumber = 1;
		for(int i=0;i<ruleList.size();i++){
			String codeType = ruleList.get(i).getCodeType();
			if("flow".equals(codeType)){
				String codeField = ruleList.get(i).getCodeField();
				if(!"_number".equals(codeField)){
					String codeFieldValue = map.get(codeField);
					CodeFlow codeFlow = new CodeFlow(partTypeId,null,codeField,codeFieldValue,0,0);
					codeFlow = this.codeFlowRepository.queryByFieldValue(codeFlow);
					firstNumber = codeFlow.getMinNumber();
				}else{
					firstNumber=1;
				}
			}
		}
		return firstNumber;
	}
	private static String getCode(Map<String,String> map,List<CodeRule> ruleList,int sortNumber){
		String code = "";
		if(ruleList==null||ruleList.size()==0) return "";
		for(int i=0;i<ruleList.size();i++){
			CodeRule codeRule = ruleList.get(i);
			String codeField = codeRule.getCodeField();
			String codeType = codeRule.getCodeType();
			int flowLength = codeRule.getFlowLength();
			if("fixed".equals(codeType)){
				code += codeField;
			}else if("flow".equals(codeType)){
				code += getNumber(sortNumber,flowLength);
			}else{
				String codeFieldValue = map.get(codeField);
				code += codeFieldValue;
			}
		}
		return code;
	}
	private static String getNumber(int value,int length){
		String numberStr = String.valueOf(value);
		int otherLength = length - numberStr.length();
		for(int i=0;i<otherLength;i++){
			numberStr = "0"+numberStr;
		}
		return numberStr;
	}
}
