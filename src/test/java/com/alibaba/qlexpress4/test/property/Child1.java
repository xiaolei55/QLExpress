package com.alibaba.qlexpress4.test.property;

import com.alibaba.qlexpress4.runtime.Value;

/**
 * @Author TaoKan
 * @Date 2022/7/10 下午6:53
 */
public class Child1 extends Parent implements Value {
    private final long result;
    public Child1(long a, int b){
        this.result = a+b+1;
    }
}
