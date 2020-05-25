package com.zan.hu.crp;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/04/26 11/55
 */
public interface Pipeline {

    Pipeline fireTaskReceived();

    Pipeline fireTaskFiltered();

    Pipeline fireTaskExecuted();

    Pipeline fireAfterCompletion();
}
