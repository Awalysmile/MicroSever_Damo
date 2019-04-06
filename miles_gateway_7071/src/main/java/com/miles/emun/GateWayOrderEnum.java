package com.miles.emun;

/**
 * @ClassName GateWayOrder
 * @Description enum order
 * @Author Miles
 * @Date 2019/4/6 11:15
 * @Version 1.0
 */
public enum GateWayOrderEnum {
    GLOBAL_FILTER_ORDER(100),
    IP_FILTER_ORDER(200);

    private int order;

    GateWayOrderEnum(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

}
