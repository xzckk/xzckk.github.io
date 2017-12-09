package org.tarena.cloudnote.aspect;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 异常切面
 * @author soft01
 */
@Aspect //定义为切面组件
@Component("exceptionBean") //扫描
public class ExceptionBean {

	@AfterThrowing(throwing="e",pointcut="within(org.tarena.cloudnote.controller..*)")
	public void logException(Exception e){
		try {
			//记录异常信息
			FileWriter fw=new FileWriter("cloud_note.log",true);
			PrintWriter out=new PrintWriter(fw);
			e.printStackTrace(out);
			out.flush();
			out.close();
			fw.close();
		} catch (Exception ex) {
			System.out.println("记录异常失败："+ex);
		}
	}
}