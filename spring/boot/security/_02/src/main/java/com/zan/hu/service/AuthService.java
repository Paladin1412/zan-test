package com.zan.hu.service;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-23 15:20
 * @Description todo
 **/
@Component
public class AuthService {

    public boolean canAccess(HttpServletRequest request, Authentication authentication) {

        System.out.println("AuthService.canAccess()");
        boolean b = false;
        System.out.println(authentication);

        //1/ 判断是否已经登录了，anonymousUser|userdetails.User
        Object principal = authentication.getPrincipal();
        if (principal == null || "anonymousUser".equals(principal)) {
            return b;
        }

        //这里可以单独把AnonymousAuthenticationToken拿出来校验，也可以将放到roles统一校验，其role为ROLE_ANONYMOUS
        if (authentication instanceof AnonymousAuthenticationToken) {
            //check if this uri can be access by anonymous
            //return
        }

        Map<String, Collection<ConfigAttribute>> map = new HashMap<>();
        SecurityConfig configAttribute = new SecurityConfig("ROLE_USER");
        map.put("/hello", Arrays.asList(configAttribute));
        //String uri = request.getRequestURI();
        //这种获取方式不好，不支持/user/**的匹配方式。
        //Collection<ConfigAttribute> configAttributes = map.get(uri);

        Collection<ConfigAttribute> configAttributes = null;
        String resUrl;
        //URL规则匹配.
        AntPathRequestMatcher matcher;
        for (Iterator<String> it = map.keySet().iterator(); it.hasNext(); ) {
            resUrl = it.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                configAttributes = map.get(resUrl);
                break;
            }
        }


        if (configAttributes == null || configAttributes.size() == 0) {
            return b;
        }

        ConfigAttribute cfa = null;
        String needRole = null;
        for (Iterator<ConfigAttribute> it = configAttributes.iterator(); it.hasNext(); ) {
            cfa = it.next();
            needRole = cfa.getAttribute();
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needRole.equals(grantedAuthority.getAuthority())) {
                    System.out.println("needRole = " + needRole);
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
}
