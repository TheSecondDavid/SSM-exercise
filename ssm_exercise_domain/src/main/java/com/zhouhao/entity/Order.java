package com.zhouhao.entity;

import com.zhouhao.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    public String getOrderTimeStr() {
        return DateUtil.DateToStr(orderTime, "yyyy-mm-dd");
    }
    public String getOrderStatusStr() {
        if(orderStatus == 1)
            return "开启";
        return "关闭";
    }
    public String getPayTypeStr() {
        if(payType == 0)
            return "支付宝";
        if(payType == 1)
            return "微信";
        return "听说你还有它";
    }
}
