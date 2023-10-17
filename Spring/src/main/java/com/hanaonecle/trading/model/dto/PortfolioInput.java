package com.hanaonecle.trading.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;

@Data
@Getter
@Setter
public class PortfolioInput {
    private String one_id;
    private int buy_amount;
    private int profit;
    private int value_amount;
    private Date work_dt;
    public PortfolioInput(HashMap<String, Object> portfolioTransactionData, HttpServletRequest request) {
        this.buy_amount = (int)portfolioTransactionData.get("buy_amount");
        this.profit = (int)portfolioTransactionData.get("profit");
        this.value_amount = (int)portfolioTransactionData.get("value_amount");
        String tmpWorkDt = (String)portfolioTransactionData.get("workDt");
        this.work_dt = Date.valueOf(tmpWorkDt.replace("/","-"));
        this.one_id = (String) request.getSession().getAttribute("id");
    }
}
