/** 
 * <pre>项目名称:shiro_springboot 
 * 文件名称:ShiroConfig.java 
 * 包名:com.jk.shiro 
 * 创建日期:2018年8月21日上午8:53:51 
 * Copyright (c) 2018, myangsh@sina.com All Rights Reserved.</pre> 
 */  
package com.jk.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

/** 
 * <pre>项目名称：shiro_springboot    
 * 类名称：ShiroConfig    
 * 类描述：    
 * 创建人：Yangshy myangsh@sina.com    
 * 创建时间：2018年8月21日 上午8:53:51    
 * 修改人：Yangshy myangsh@sina.com     
 * 修改时间：2018年8月21日 上午8:53:51    
 * 修改备注：       
 * @version </pre>    
 */
@Configuration//声明当前类是一个配置文件类 此类就相当于之前spring配置文件
public class ShiroConfig {
	    //认证和授权的缓存处理器 用来管理认证授权之间的bean(对象)关系
	    @Bean(name = "lifecycleBeanPostProcessor")
	    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
	        return new LifecycleBeanPostProcessor();
	    }
	    /**
	     * <pre>securityManager(安全管理器 认证和 授权都在此类中管理 是shiro核心类)   
	     * 创建人：Yangshy myangsh@sina.com    
	     * 创建时间：2018年8月21日 上午8:59:55    
	     * 修改人：Yangshy myangsh@sina.com     
	     * 修改时间：2018年8月21日 上午8:59:55    
	     * 修改备注： @Bean声明一个bean实例 于@Service、@Controller类似 需要加载方法上
	     *          把方法返回值对象放入spring运行环境中
	     * @return</pre>
	     */
	    @Bean//在xml文件中配置一个bean标签 相当于<bean class=" org.apache.shiro.mgt.SecurityManager" name="securityManager"></bean>
		public SecurityManager securityManager() {

			DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

			// 设置realm. 域(数据源 用来连接数据库完成认证和授权)
			//把自己创建的Realm 注入到securityManager中
			securityManager.setRealm(myShiroRealm());

			// 注入缓存管理器;
			//securityManager.setCacheManager(ehCacheManager());// 这个如果执行多次，也是同样的一个对象;
			//securityManager.setRememberMeManager(rememberMeManager());

			return securityManager;

		}
	    
	    /**
	     * <pre>shirFilter(ShiroFilterFactoryBean shiro过滤器链)   
	     * 创建人：Yangshy myangsh@sina.com    
	     * 创建时间：2018年8月21日 上午9:05:15    
	     * 修改人：Yangshy myangsh@sina.com     
	     * 修改时间：2018年8月21日 上午9:05:15    
	     * 修改备注： 
	     * @param securityManager
	     * @return</pre>
	     */
	    @Bean
		public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

			System.out.println("ShiroConfiguration.shirFilter()");
            //shiro过滤器工厂
			ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

			// 必须设置 SecurityManager 如果不设置就无法完成认证和授权
			shiroFilterFactoryBean.setSecurityManager(securityManager);
			// 过滤器链
			Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

			// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
			//logout shiro定义好的过滤器名字  /logout访问路径
			//浏览器访问的地址栏路径中以/logout结尾的路径 走logout过滤器 
			//logout会清除session 退出登录
			filterChainDefinitionMap.put("/logout", "logout");
			//所有的css文件走anon过滤器 此过滤器代表放过拦截 不需要权限也能访问
			filterChainDefinitionMap.put("/css/**", "anon");
			//放过登录页面拦截
			filterChainDefinitionMap.put("/toLogin", "anon");
			filterChainDefinitionMap.put("/img/**", "anon");
			filterChainDefinitionMap.put("/js/**", "anon");
			///**代表所有路径 除以上路径外都拦截  authc代表权限拦截过滤器
			filterChainDefinitionMap.put("/**", "authc");
			//perms权限过滤器  必须拥有某项权限才能访问对应路径
			//filterChainDefinitionMap.put("/add", "perms[user:query]");
			//登录请求路径 登录页面提交form表单时 表单的action写此路径
			shiroFilterFactoryBean.setLoginUrl("/login");
			// 登录成功跳转到登录成功页面
			shiroFilterFactoryBean.setSuccessUrl("/index");
			// 未授权界面;
			//shiroFilterFactoryBean.setUnauthorizedUrl("/warning");
			shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
            //最终返回过滤器链
			return shiroFilterFactoryBean;

		}
	    
	    //在配置类中注入realm
	    @Bean
	    public MyRealm myShiroRealm(){
	    	MyRealm myRealm = new MyRealm();
	    	return myRealm;
	    }
	
}
