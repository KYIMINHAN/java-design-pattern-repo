package com.core.java.design.pattern005.chainOfResponsibility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

/**
 * The Class App.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Jul 2, 2019 <BR>
 *        java-design-pattern-02-behavioral-ptn system <BR>
 *        com.core.java.design.pattern005.chainOfResponsibility <BR>
 *        App.java <BR>
 */
@Configuration
@ComponentScan(basePackages = "com.core.java.design.pattern005")
@Log4j2
public class App {

	// <bean id="supportService" class="com.howtodoinjava.handler.SupportService">
	// <property name="handler" ref="frontDeskSupport"></property>
	// </bean>
	// <bean id="frontDeskSupport"
	// class="com.howtodoinjava.handler.FrontDeskSupport">
	// <property name="next" ref="supervisorSupport"></property>
	// </bean>
	// <bean id="supervisorSupport"
	// class="com.howtodoinjava.handler.SupervisorSupport">
	// <property name="next" ref="managerSupport"></property>
	// </bean>
	// <bean id="managerSupport" class="com.howtodoinjava.handler.ManagerSupport">
	// <property name="next" ref="directorSupport"></property>
	// </bean>
	// <bean id="directorSupport"
	// class="com.howtodoinjava.handler.DirectorSupport"></bean>

	/**
	 * Support service bean.
	 *
	 * @return SupportServiceItf
	 */
	@Bean(name = "supportServiceBean")
	public SupportServiceItf supportServiceBean() {
		final SupportService service = new SupportService();
		service.setHandler(this.frontDeskSupportBean());
		return service;
	}

	/**
	 * Front desk support bean.
	 *
	 * @return FrontDeskSupport
	 */
	@Bean(name = "frontDeskSupportBean")
	public FrontDeskSupport frontDeskSupportBean() {
		final FrontDeskSupport service = new FrontDeskSupport();
		service.setNext(this.supervisorSupportBean());
		return service;
	}

	/**
	 * Supervisor support bean.
	 *
	 * @return SupervisorSupport
	 */
	@Bean(name = "supervisorSupportBean")
	public SupervisorSupport supervisorSupportBean() {
		final SupervisorSupport service = new SupervisorSupport();
		service.setNext(this.managerSupportBean());
		return service;
	}

	/**
	 * Manager support bean.
	 *
	 * @return ManagerSupport
	 */
	@Bean(name = "managerSupportBean")
	public ManagerSupport managerSupportBean() {
		final ManagerSupport service = new ManagerSupport();
		service.setNext(this.directorSupportBean());
		return service;
	}

	/**
	 * Director support bean.
	 *
	 * @return DirectorSupport
	 */
	@Bean(name = "directorSupportBean")
	public DirectorSupport directorSupportBean() {
		final DirectorSupport service = new DirectorSupport();
		return service;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {

		final ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		final SupportService supportService = (SupportService) context.getBean("supportServiceBean");

		ServiceRequest request = new ServiceRequest();
		request.setType(ServiceLevel.LEVEL_ONE);
		supportService.handleRequest(request);
		App.log.info(request.getConclusion());

		request = new ServiceRequest();
		request.setType(ServiceLevel.LEVEL_THREE);
		supportService.handleRequest(request);
		App.log.info(request.getConclusion());

		request = new ServiceRequest();
		request.setType(ServiceLevel.INVALID_REQUEST);
		supportService.handleRequest(request);
		App.log.info(request.getConclusion());

		((AnnotationConfigApplicationContext) context).close();
	}

}