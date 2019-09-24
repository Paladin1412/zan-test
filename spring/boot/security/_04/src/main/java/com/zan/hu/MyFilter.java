package com.zan.hu;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-23 16:38
 * @Description todo
 **/
public class MyFilter extends AbstractSecurityInterceptor {

    @Override
    public Class<?> getSecureObjectClass() {
        return null;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return null;
    }
}
