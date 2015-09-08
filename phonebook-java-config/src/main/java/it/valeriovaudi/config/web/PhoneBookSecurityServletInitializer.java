package it.valeriovaudi.config.web;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 <web-app xmlns="http://java.sun.com/xml/ns/javaee"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
     http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
     version="3.0">

     <context-param>
         <param-name>contextConfigLocation</param-name>
         <param-value>classpath:application-context.xml</param-value>
     </context-param>

     <context-param>
         <param-name>spring.profiles.active</param-name>
         <param-value>${springProfile}</param-value>
     </context-param>

     <filter>
         <filter-name>springSecurityFilterChain</filter-name>
         <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
     </filter>

     <filter-mapping>
         <filter-name>springSecurityFilterChain</filter-name>
         <url-pattern>/*</url-pattern>
     </filter-mapping>

     <filter>
         <filter-name>SpringOpenEntityManagerInViewFilter</filter-name>
         <filter-class>org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter</filter-class>
     </filter>

     <filter-mapping>
         <filter-name>SpringOpenEntityManagerInViewFilter</filter-name>
         <url-pattern>/*</url-pattern>
     </filter-mapping>

     <filter>
         <filter-name>simpleCORSFilter</filter-name>
         <filter-class>it.valeriovaudi.web.filter.SimpleCORSFilter</filter-class>
     </filter>

     <filter-mapping>
         <filter-name>simpleCORSFilter</filter-name>
         <url-pattern>/*</url-pattern>
     </filter-mapping>


     <listener>
         <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
     </listener>

     <servlet>
         <servlet-name>dispatcher</servlet-name>
         <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
         <load-on-startup>1</load-on-startup>
     </servlet>

     <servlet-mapping>
         <servlet-name>dispatcher</servlet-name>
         <url-pattern>/</url-pattern>
     </servlet-mapping>

 </web-app>
 */
@Order(2)
public class PhoneBookSecurityServletInitializer extends AbstractSecurityWebApplicationInitializer { }
