package com.unmsm.fisi.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.unmsm.fisi.configuration"})
@Import(value = {RepositoryConfiguration.class})
public class ApplicationConfiguration
{

}