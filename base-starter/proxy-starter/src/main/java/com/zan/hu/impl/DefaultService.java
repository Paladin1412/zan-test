package com.zan.hu.impl;

import com.zan.hu.service.BaseService;

public class DefaultService implements BaseService {
    @Override
    public void ok() {
        System.out.println("ok");
    }
}
