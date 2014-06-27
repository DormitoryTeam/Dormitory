package com.noeasy.money.admin.util;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

import com.noeasy.money.model.DormitoryLineItem;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.PickupLineItem;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserInfoBean;
import com.noeasy.money.util.DateUtils;

/**
 * 
 * @author: Yove
 * @version: 1.0, Jun 8, 2014
 */

public class OrderExcelUtils {

    private static final String    DEFUALT_SHEET_NAME         = "sheet";

    private static final String[]  PICKUP_COLUMN_NAMES        = new String[] { "接机订单编号", "支付金额", "支付状态", "下单时间",
            "是否通过本司预定正课宿舍", "学生识别码", "名", "姓", "生日", "性别", "QQ", "邮箱地址", "联系方式", "uk手机号", "航空公司", "航班号", "起飞时间",
            "到达时间", "起飞机场(城市)", "中转机场", "到达机场", "落地航站楼", "送达住址", "送达地邮编", "行李", "国内快递地址", "会员卡号", "快递单号", "备注", "微信号" };

    private static final Integer[] PICKUP_COLUMN_UNDEFINED    = new Integer[] { 4, 13, 19, 21, 26, 27, 28 };

    private static List<Integer>   mPickupUndefinedIndexes;

    private static final String[]  DORMITORY_COLUMN_NAMES     = new String[] { "宿舍订单编号", "宿舍隶属公司", "宿舍名字", "城市", "组别",
            "学生识别码", "名", "姓", "生日", "性别", "邮箱地址", "QQ", "手机号码", "房间类型", "房间号", "楼层", "订单状态", "下单时间", "补充信息", "家庭住址",
            "家长姓名", "家长联系方式", "备注"                           };

    private static final Integer[] DORMITORY_COLUMN_UNDEFINED = new Integer[] { 4, 14, 15, 20, 21, 22 };

    private static List<Integer>   mDormitoryUndefinedIndexes;

    static {
        mPickupUndefinedIndexes = Arrays.asList(PICKUP_COLUMN_UNDEFINED);
        mDormitoryUndefinedIndexes = Arrays.asList(DORMITORY_COLUMN_UNDEFINED);
    }



    protected static String convertDormitroyStatus(final String status) {
        switch (status) {
        case "INITIAL":
            return "等待用户完成订单";
        case "COMMIT":
            return "已提交,等待审核";
        case "REVIEWDE":
            return "审核完成，等待发送合同";
        case "SENDING_CONTACT":
            return "合同发送中";
        case "DONE":
            return "完成";
        default:
            return "未知的状态";
        }
    }



    protected static String convertGender(final int gender) {
        return gender > 0 ? "女" : "男";
    }



    protected static String convertLuggageSize(final PickupLineItem lineItem) {
        lineItem.analyzeLuggage();
        String luggage = "";
        if (null != lineItem.getLuggageSize1()) {
            luggage += lineItem.getLuggageSize1() + "寸X" + lineItem.getLuggageAmount1() + "个";
        }
        if (null != lineItem.getLuggageSize2()) {
            luggage += "; " + lineItem.getLuggageSize2() + "寸X" + lineItem.getLuggageAmount2() + "个";
        }
        if (null != lineItem.getLuggageSize3()) {
            luggage += "; " + lineItem.getLuggageSize3() + "寸X" + lineItem.getLuggageAmount3() + "个";
        }

        if (null != lineItem.getLuggageSize4()) {
            luggage += "; " + lineItem.getLuggageSize4() + "寸X" + lineItem.getLuggageAmount4() + "个";
        }

        if (null != lineItem.getLuggageSize5()) {
            luggage += "; " + lineItem.getLuggageSize5() + "寸X" + lineItem.getLuggageAmount5() + "个";
        }
        return luggage;
    }



    protected static String convertPickupStatus(final String status) {
        switch (status) {
        case "INITIAL":
            return "等待用户完成订单";
        case "COMMIT":
            return "已提交,等待审核";
        case "REVIEWDE":
            return "审核完成，已发送付款邮件";
        case "PAYMENT_DONE":
            return "已支付，已发送车票邮件";
        case "PAYMENT_NOT_DONE":
            return "未支付，已发送车票邮件";
        default:
            return "未知的状态";
        }
    }



    public static HSSFWorkbook writeDormitoryExcel(final List<OrderBean> pOrders) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet(DEFUALT_SHEET_NAME + "1");

        HSSFPalette palette = workbook.getCustomPalette();
        palette.setColorAtIndex((short) 12, (byte) (79), (byte) (129), (byte) (189));
        palette.setColorAtIndex((short) 8, (byte) (69), (byte) (69), (byte) (69));

        HSSFRow titleRow = worksheet.createRow(0);
        titleRow.setHeightInPoints(71.25f);

        for (int i = 0; i < DORMITORY_COLUMN_NAMES.length; i++) {
            HSSFCell cell = titleRow.createCell(i);
            HSSFCellStyle titleCellStyle = workbook.createCellStyle();
            titleCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            titleCellStyle.setAlignment(CellStyle.ALIGN_CENTER);

            HSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short) 11);
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
            font.setColor(HSSFColor.WHITE.index);
            titleCellStyle.setFont(font);

            if (mDormitoryUndefinedIndexes.contains(i)) {
                titleCellStyle.setFillForegroundColor((short) 8);
            } else {
                titleCellStyle.setFillForegroundColor((short) 12);
            }
            titleCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

            cell.setCellValue(DORMITORY_COLUMN_NAMES[i]);
            cell.setCellStyle(titleCellStyle);
        }

        HSSFCell cell;
        for (int i = 0, j = 0; i < pOrders.size(); i++) {
            OrderBean order = pOrders.get(i);
            HSSFRow orderRow = worksheet.createRow(i + 1 - j);
            int colIndex = 0;
            DormitoryLineItem item = (DormitoryLineItem) order.getLineItems().get(0);

            if (order.getBelongsTo() == null || item == null || item.getRoomInfo() == null) {
                j++;
                continue;
            }

            // 0
            cell = orderRow.createCell(colIndex++);
            String orderId = OrderTokenUtil.getOrderToken(order.getId().toString(),
                    OrderTokenUtil.DORMITORY_ORDER_TOKEN_PREFIX);
            cell.setCellValue(orderId);
            // 1
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(item.getDormitory().getCompany()));
            // 2
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(item.getDormitory().getName()));
            // 3
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(item.getDormitory().getCity()));
            // 4
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 5
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(order.getBelongsTo().getNewCode());
            // 6
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(order.getBelongsTo().getInfo().getName()));
            // 7
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(order.getBelongsTo().getInfo().getLastName()));
            // 8
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(DateUtils.dateToString(order.getBelongsTo().getInfo().getBirthday()));
            // 9
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(convertGender(order.getBelongsTo().getInfo().getGender()));
            // 10
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(order.getBelongsTo().getInfo().getQq());
            // 11
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(order.getBelongsTo().getEmail());
            // 12
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(order.getBelongsTo().getInfo().getPhone());
            // 13
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(item.getRoomInfo().getRoomType());
            // 14
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 15
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 16
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(convertDormitroyStatus(order.getOrderStatus()));
            // 17
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(DateUtils.dateToString(order.getCreateTime(), DateUtils.DATE_TIME_FORAMT_RULE));
            // 18
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 19
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(order.getBelongsTo().getInfo().getAddress()));
            // 20
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 21
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 22
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
        }

        for (Integer i = 0; i < DORMITORY_COLUMN_NAMES.length; i++) {
            worksheet.autoSizeColumn(i);
        }

        return workbook;
    }



    public static HSSFWorkbook writePickupExcel(final List<OrderBean> pOrders) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet(DEFUALT_SHEET_NAME + "1");

        HSSFPalette palette = workbook.getCustomPalette();
        palette.setColorAtIndex((short) 12, (byte) (79), (byte) (129), (byte) (189));
        palette.setColorAtIndex((short) 8, (byte) (69), (byte) (69), (byte) (69));

        HSSFRow titleRow = worksheet.createRow(0);
        titleRow.setHeightInPoints(71.25f);

        for (int i = 0; i < PICKUP_COLUMN_NAMES.length; i++) {
            HSSFCell cell = titleRow.createCell(i);
            HSSFCellStyle titleCellStyle = workbook.createCellStyle();
            titleCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            titleCellStyle.setAlignment(CellStyle.ALIGN_CENTER);

            HSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short) 11);
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
            font.setColor(HSSFColor.WHITE.index);
            titleCellStyle.setFont(font);

            if (mPickupUndefinedIndexes.contains(i)) {
                titleCellStyle.setFillForegroundColor((short) 8);
            } else {
                titleCellStyle.setFillForegroundColor((short) 12);
            }
            titleCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

            cell.setCellValue(PICKUP_COLUMN_NAMES[i]);
            cell.setCellStyle(titleCellStyle);
        }

        HSSFCell cell;
        for (int i = 0, j = 0; i < pOrders.size(); i++) {
            OrderBean order = pOrders.get(i);
            PickupLineItem item = (PickupLineItem) order.getLineItems().get(0);
            UserBean belongsTo = order.getBelongsTo();
            if (null == item || null == belongsTo) {
                j++;
                continue;
            }
            if (null == order.getOrderContact() || null == order.getOrderContact().getBelongsToInfo()) {
                j++;
                continue;
            }
            UserInfoBean info = order.getOrderContact().getBelongsToInfo();

            HSSFRow orderRow = worksheet.createRow(i + 1 - j);
            int colIndex = 0;

            // 0
            cell = orderRow.createCell(colIndex++);
            String orderId = OrderTokenUtil.getOrderToken(order.getId().toString(),
                    OrderTokenUtil.PICKUP_ORDER_TOKEN_PREFIX);
            cell.setCellValue(orderId);
            // 1
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(order.getAmount().toString());
            // 2
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(convertPickupStatus(order.getOrderStatus()));
            // 3
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(DateUtils.dateToString(order.getCreateTime(), DateUtils.DATE_TIME_FORAMT_RULE));
            // 4
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 5
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(belongsTo.getNewCode());
            // 6
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(info.getName()));
            // 7
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(info.getLastName()));
            // 8
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(DateUtils.dateToString(info.getBirthday()));
            // 9
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(convertGender(info.getGender()));
            // 10
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(info.getQq());
            // 11
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(info.getEmail());
            // 12
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(info.getPhone());
            // 13
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 14
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(item.getFlightCompany()));
            // 15
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(item.getFlightNum()));
            // 16
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(DateUtils.dateToString(item.getTakeOffDate(), DateUtils.DATE_TIME_FORAMT_RULE));
            // 17
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(DateUtils.dateToString(item.getPickupDate(), DateUtils.DATE_TIME_FORAMT_RULE));
            // 18
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(item.getTakeOffCity()));
            // 19
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 20
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(item.getArrivalAirport() + "," + item.getArrivalCity()));
            // 21
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 22
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(item.getPickup2Address()));
            // 23
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(item.getPickup2Postalcode());
            // 24
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(convertLuggageSize(item));
            // 25
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(StringEscapeUtils.unescapeHtml4(info.getCountry()) + " " + StringEscapeUtils.unescapeHtml4(info.getProvince()) + "(省) "+ StringEscapeUtils.unescapeHtml4(info.getCity()) + "(市) " + StringEscapeUtils.unescapeHtml4(info.getCounty()) +"(区县) " +StringEscapeUtils.unescapeHtml4(info.getAddress()) + "( "+ StringEscapeUtils.unescapeHtml4(info.getPostalcode()) + " )");
            // 26
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 27
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 28
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 29
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(info.getWechat());
        }

        for (Integer i = 0; i < PICKUP_COLUMN_NAMES.length; i++) {
            worksheet.autoSizeColumn(i);
        }

        return workbook;
    }
}
