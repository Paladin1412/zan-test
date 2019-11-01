package com.zan.hu;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-11 10:11
 * @Description todo
 **/
@Configuration
@Import(value = UserServiceImpl.class)
public class Config {
}
