package com.cn.cixin.common;

import java.util.HashMap;
import java.util.Map;

public final class BaseData {
	
	private BaseData() {
	}
	//���Žӿ�
	public static final String SMS_ATTR_URL = "http://gw.api.taobao.com/router/rest";	//��ַ
	public static final String SMS_ATTR_APPKEY = "23419405";			//appkey
	public static final String SMS_ATTR_SECRET = "dd2eacc4513ad1caa320090113b2b123";	//secret
	public static final String SMS_TEMPLATE_CODE_YZM = "SMS_12816510";	//��֤��_ģ��ID
	public static final String SMS_TEMPLATE_CODE_XX = "SMS_16751348";	//������Ϣ_ģ��ID
	public static final String SMS_SIGN_CODE = "�����д�";			//��֤��ǩ��1
	public static final String SMS_EXTEND_NOMAL = "";				//����Ĭ��extend
	public static final String SMS_TYPE_NOMAL = "nomal";			//����Ĭ������
	public static final Map<String, String> SMS_CODE = new HashMap<String,String>();			//����Ĭ������
		
	//���ش���
	public static final int RETURN_CODE_TRUE = 1;
	public static final int RETURN_CODE_FALSE = 0;
	public static final String RETURN_STR_TRUE = "true";
	public static final String RETURN_STR_FALSE = "false";
	
}
