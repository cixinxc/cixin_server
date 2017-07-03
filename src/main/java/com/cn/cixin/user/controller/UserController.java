package com.cn.cixin.user.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.UUID;
import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cn.cixin.common.BaseData;
import com.cn.cixin.common.GlobalMethods;
import com.cn.cixin.common.ReadStream;
import com.cn.cixin.common.TBSms;
import com.cn.cixin.user.model.User;  
import com.cn.cixin.user.service.IUserService;  

@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Resource  
    private IUserService userService;  
    
    @SuppressWarnings("static-access")
    
    @RequestMapping(value = "/showUser")
	@ResponseBody
    public JSONObject toIndex(Model model){   
    	TBSms t = new TBSms();
    	JSONObject code = new JSONObject();
    	code.put("code", "yzms");
    	t.sendSms(code, "18810328922",BaseData.SMS_TEMPLATE_CODE_YZM);
    	JSONObject j = new JSONObject();
    	j.put("url", "user/showUser");
    	return j;
    }
    /*
     * µÇÂ¼
     * 
     * */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request)throws Exception{
    	JSONObject j = new JSONObject();
    	
		String streamIn = ReadStream.read(new BufferedInputStream(request.getInputStream()));
		JSONObject object = JSONObject.fromObject(streamIn);
		
		User user = new User();
	    String userName = (String)(object.getString("userName")); 
	    String password = (String)(object.getString("password")); 
	    	
	    boolean result = this.userService.loginCheck(userName, password);
	    if(result){
	    	user.setUserName(userName);
	    	j.put("user", user);
	    	return GlobalMethods.ReturnJSONObject(1, j).toString();
	    }
	    else{
	    	j.put("url", "common/error");
	    	return GlobalMethods.ReturnJSONObject(0, j).toString();
	    }
    }
    /*
     * ×¢²á
     * 
     * */
    @RequestMapping(value="/register",method=RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request,Model model) {    	
    	JSONObject j = new JSONObject();
    	
		String streamIn;
		try {
			streamIn = ReadStream.read(new BufferedInputStream(request.getInputStream()));
		System.out.println(streamIn.toString());

			JSONObject object = JSONObject.fromObject(streamIn);
			System.out.println(object.toString());
	    	User user = new User();
	    	user.setUserId( UUID.randomUUID().toString().replaceAll("-", "") );
	    	user.setUserName( (String)(object.getString("userName") ) );
	    	user.setPassword( (String)(object.getString("password") ) );
	    	int result = this.userService.insert(user);
	    	if(result==1){
	    		j.put("user", user);
		    	return GlobalMethods.ReturnJSONObject(1, j).toString();
		    }
		    else{
		    	j.put("url", "common/error");
		    	return GlobalMethods.ReturnJSONObject(0, j).toString();
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
    }
    /*
     * Ìø×ª½çÃæ
     * 
     * */
    @RequestMapping("/toLogin")  
    public String toLogin(HttpServletRequest request){
    	String url = request.getParameter("url");
    	return url;
    }
}  