/**
 * 
 */
package com.bs.beyond.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Configure Class
 *
 */
@Configuration
@ComponentScan("com.bs.beyond.*")
@EnableAspectJAutoProxy
public class AppConfig
{

}
