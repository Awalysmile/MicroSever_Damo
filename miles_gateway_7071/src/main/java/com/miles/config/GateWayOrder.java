package com.miles.emun;

/**
 * @ClassName GateWayOrder
 * @Description enum order
 * @Author Miles
 * @Date 2019/4/6 11:15
 * @Version 1.0
 */
public enum GateWayOrder {
    URI_FILTER(100),
    IP_FILTER(200);

    private int order;

    GateWayOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

}
