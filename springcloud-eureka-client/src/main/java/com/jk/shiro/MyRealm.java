/** 
 * <pre>项目名称:shiro_springboot 
 * 文件名称:MyRealm.java 
 * 包名:com.jk.shiro 
 * 创建日期:2018年8月21日上午9:23:30 
 * Copyright (c) 2018, myangsh@sina.com All Rights Reserved.</pre> 
 */  
package com.jk.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/** 
 * <pre>项目名称：shiro_springboot    
 * 类名称：MyRealm
 * 类描述：    
 * 创建人：Yangshy myangsh@sina.com    
 * 创建时间：2018年8月21日 上午9:23:30    
 * 修改人：Yangshy myangsh@sina.com     
 * 修改时间：2018年8月21日 上午9:23:30    
 * 修改备注：       
 * @version </pre>    
 */
public class MyRealm extends AuthorizingRealm{
    /**
     * 授权方法
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	 /**
     * 认证方法 登录方法 连接数据库 根据前台用户名查询用户对象
     *                 使用前台的密码和数据库密码比较。
     * token 令牌 用来标明身份
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取到当前页面传递回的用户名
		String userName = (String)token.getPrincipal();
		if(!"zhangsan".equals(userName)){
			//如果用户名错误 抛出用户名异常
			throw new UnknownAccountException();
		}
		//userName 根据用户名连接数据库 查到用户对象
		//简单用户认证器  第一个参数为用户名 第二参数为数据库查询出来的密码
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName,"123456",this.getName());		
		return simpleAuthenticationInfo;
	}

}
