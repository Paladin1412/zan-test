package com.zan.hu;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-23 16:14
 * @Description todo
 **/
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println("MyAccessDecisionManager.decide()");
        if (configAttributes == null || configAttributes.size() == 0) {
            throw new AccessDeniedException("permission denied");
        }

        ConfigAttribute cfa;
        String needRole;
        //遍历基于URL获取的权限信息和用户自身的角色信息进行对比.
        for (Iterator<ConfigAttribute> it = configAttributes.iterator(); it.hasNext(); ) {
            cfa = it.next();
            needRole = cfa.getAttribute();
            System.out.println("decide,needRole:" + needRole + ",authentication=" + authentication);
            //authentication 为CustomUserDetailService中添加的权限信息.
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needRole.equals(grantedAuthority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("permission denied");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
