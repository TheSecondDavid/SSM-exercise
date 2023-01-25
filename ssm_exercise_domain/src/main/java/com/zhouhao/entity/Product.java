package com.zhouhao.entity;

import com.zhouhao.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    String id;
    String productNum;
    String productName;
    String cityName;
    @DateTimeFormat(pattern="yyyy年MM月dd日")
    Date departureTime;
    String departureTimeStr;
    String productPrice;
    String productDesc;
    Integer productState;
    String productStateStr;

    public String getDepartureTimeStr() {
        return DateUtil.DateToStr(departureTime, "yyyy-MM-dd");
    }

    public String getProductStateStr() {
        if(productState == 0)
            return "关闭";
        return "开启";
    }
}
