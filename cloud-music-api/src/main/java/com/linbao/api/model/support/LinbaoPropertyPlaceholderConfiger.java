/**
 * Jan 10, 2016
 *cloud-music-api
 *TODO
 *Linbao
 */
package com.linbao.api.model.support;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author Linbao
 *
 */
public class LinbaoPropertyPlaceholderConfiger extends PropertyPlaceholderConfigurer {
	
	private Properties props;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		super.processProperties(beanFactory, props);
		this.props = props;
	}

	public Object getProperty(String key) {
		return props.get(key);
	}
}
