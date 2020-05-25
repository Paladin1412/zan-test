package com.zan.hu.crp;

import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/04/26 14/46
 */
@Service
public class DurationHandler implements Handler {

    @Override
    public void filterTask(HandlerContext ctx, Task task) {
        System.out.println("时效性检验");
        ctx.fireTaskFiltered(task);
    }

}
