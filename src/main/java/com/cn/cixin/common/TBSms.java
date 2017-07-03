package com.cn.cixin.common;

import net.sf.json.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class TBSms {
	/**
	 * @param code
	 *			验证码所需内容(JSONObject):"{code:'说说ad'}"
	 *			通知所需内容(String):待定
	 * @param recNum
	 * 			对方电话号码
	 * @param SMSTemplateCode
	 * 			短信模板代码
	 * @return 返回发送结果
	 */
	public static void sendSms(JSONObject code,String recNum,String SMSTemplateCode){
		TaobaoClient client = new DefaultTaobaoClient(BaseData.SMS_ATTR_URL, BaseData.SMS_ATTR_APPKEY, BaseData.SMS_ATTR_SECRET);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend(BaseData.SMS_EXTEND_NOMAL);
		req.setSmsType(BaseData.SMS_TYPE_NOMAL);
		req.setSmsFreeSignName(BaseData.SMS_SIGN_CODE);	//签名
		req.setSmsParamString(code.toString());
		req.setRecNum(recNum);
		req.setSmsTemplateCode(SMSTemplateCode);
		
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			JSONObject j=JSONObject.fromObject( rsp.getBody() );
			System.out.println("短信发送结果:"+j.getJSONObject("alibaba_aliqin_fc_sms_num_send_response").getJSONObject("result").getString("success"));
			System.out.println(""+BaseData.SMS_EXTEND_NOMAL+"   "+code.toString()+"   "+rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param code
	 *			验证码内容
	 * @param recNum
	 * 			对方电话号码
	 * @return 返回发送结果
	 */
	public void sendSms_YZM(String code,String recNum){
		JSONObject codes = new JSONObject();
    	codes.put("code", code);
		sendSms(codes,recNum,BaseData.SMS_TEMPLATE_CODE_YZM);
	}
	/**
	 * @param userName,content
	 *			用户姓名,消息内容
	 * @param recNum
	 * 			对方电话号码
	 * @return 返回发送结果
	 */
	public static void sendSms_XX(String userName,String content,String recNum){
		JSONObject codes = new JSONObject();
    	codes.put("userName", userName);
    	codes.put("content", content);
		sendSms(codes,recNum,BaseData.SMS_TEMPLATE_CODE_XX);
	}
}
