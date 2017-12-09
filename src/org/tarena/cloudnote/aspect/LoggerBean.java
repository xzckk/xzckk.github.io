package org.tarena.cloudnote.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 打桩的切面组件
 * @author soft01
 */
@Aspect //定义为切面组件
@Component("loggerBean") //扫描
public class LoggerBean {

	@Before("within(org.tarena.cloudnote.controller..*)")
	public void logController(){
		System.out.println("请求进入Controller组件处理");
	}
}