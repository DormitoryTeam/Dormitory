package com.noeasy.money.admin.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.admin.util.OrderExcelUtils;
import com.noeasy.money.constant.Constants;
import com.noeasy.money.enumeration.OrderType;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderSearchBean;
import com.noeasy.money.service.IOrderService;
import com.noeasy.money.service.IUserService;
import com.noeasy.money.util.DateUtils;

/**
 * 
 * @author: Yove
 * @version: 1.0, Jun 8, 2014
 */
@Controller
@RequestMapping("/admin/excel")
public class AdminExcelController {
    @Resource(name = "orderService")
    IOrderService orderService;

    @Resource(name = "userService")
    IUserService  userService;



    @RequestMapping("/exportPickUpExcel" + Constants.URL_SUFFIX)
    public void exportPickUpRecords(final HttpServletRequest request, final HttpServletResponse response,
            final ModelMap model, final String startDate, final String endDate, final String status, final String paid) {
        OrderSearchBean searchBean = new OrderSearchBean();
        if (StringUtils.isNoneBlank(startDate)) {
            searchBean.setDateFrom(DateUtils.stringToDate(startDate));
        }
        if (StringUtils.isNoneBlank(endDate)) {
            searchBean.setDateTo(DateUtils.stringToDate(endDate));
        }
        searchBean.setStatus(status);
        searchBean.setOrderType(OrderType.PICKUP);
        List<OrderBean> orders = orderService.queryOrder(searchBean);
        HSSFWorkbook workbook = OrderExcelUtils.writePickupExcel(orders);

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=pickupOrders.xls");
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
