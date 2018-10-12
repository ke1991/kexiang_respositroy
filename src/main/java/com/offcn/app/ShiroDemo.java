package com.offcn.app;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroDemo {

	public static void main(String[] args) {
		
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token  = new UsernamePasswordToken("test", "888");
		
		try {
			
			subject.login(token);
			
			System.out.println("认证通过");
			
		} catch (AuthenticationException e) {
			
			System.out.println("认证失败");
		
			e.printStackTrace();
		}
		
		boolean b = subject.isAuthenticated();
		
		System.out.println("认证状态:"+b);
		
		System.out.println(subject.isAuthenticated());
		
	}

}
