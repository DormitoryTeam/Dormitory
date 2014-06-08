package com.noeasy.money.admin.util;

import java.util.Arrays;
import java.util.List;

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

import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.PickupLineItem;
import com.noeasy.money.util.DateUtils;

/**
 * 
 * @author: Yove
 * @version: 1.0, Jun 8, 2014
 */

public class OrderExcelUtils {

    private static final String    DEFUALT_SHEET_NAME      = "sheet";

    private static final String[]  PICKUP_COLUMN_NAMES     = new String[] { "接机订单编号", "支付金额", "支付状态", "是否通过本司预定正课宿舍",
            "学生识别码", "名", "姓", "生日", "性别", "QQ", "邮箱地址", "联系方式", "uk手机号", "航空公司", "航班号", "起飞时间", "到达时间", "起飞机场(城市)",
            "中转机场", "到达机场", "落地航站楼", "送达住址", "送达地邮编", "行李", "国内快递地址", "会员卡号", "快递单号", "备注" };

    private static final Integer[] PICKUP_COLUMN_UNDEFINED = new Integer[] { 12, 18, 20, 24, 25, 26, 27 };

    private static List<Integer>   mPickupUndefinedIndexes;

    static {
        mPickupUndefinedIndexes = Arrays.asList(PICKUP_COLUMN_UNDEFINED);
    }



    protected static String converGender(final int gender) {
        return gender > 0 ? "女" : "男";
    }



    public static HSSFWorkbook writePickupExcel(final List<OrderBean> pOrders) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet(DEFUALT_SHEET_NAME + "1");

        HSSFPalette palette = workbook.getCustomPalette();
        palette.setColorAtIndex((short) 12, (byte) (79), (byte) (129), (byte) (189));

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
                titleCellStyle.setFillForegroundColor(HSSFColor.BLACK.index);
            } else {
                titleCellStyle.setFillForegroundColor((short) 12);
            }
            titleCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

            cell.setCellValue(PICKUP_COLUMN_NAMES[i]);
            cell.setCellStyle(titleCellStyle);
        }

        HSSFCell cell;
        for (int i = 0; i < pOrders.size(); i++) {
            OrderBean order = pOrders.get(i);
            HSSFRow orderRow = worksheet.createRow(i + 1);
            int colIndex = 0;
            PickupLineItem item = (PickupLineItem) order.getLineItems().get(0);

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
            cell.setCellValue(order.getOrderStatus());
            // 3
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("???");
            // 4
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(order.getBelongsTo().getNewCode());
            // 5
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(order.getBelongsTo().getInfo().getName());
            // 6
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(order.getBelongsTo().getInfo().getLastName());
            // 7
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(DateUtils.dateToString(order.getBelongsTo().getInfo().getBirthday(),
                    DateUtils.DATE_TIME_FORAMT_RULE));
            // 8
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(converGender(order.getBelongsTo().getInfo().getGender()));
            // 9
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(order.getBelongsTo().getInfo().getQq());
            // 10
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(order.getBelongsTo().getEmail());
            // 11
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(order.getBelongsTo().getInfo().getPhone());
            // 12
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 13
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(item.getFlightCompany());
            // 14
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(item.getFlightNum());
            // 15
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(DateUtils.dateToString(item.getTakeOffDate(), DateUtils.DATE_TIME_FORAMT_RULE));
            // 16
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(DateUtils.dateToString(item.getPickupDate(), DateUtils.DATE_TIME_FORAMT_RULE));
            // 17
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(item.getTakeOffCity());
            // 18
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 19
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(item.getArrivalAirport() + "," + item.getArrivalCity());
            // 20
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 21
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(item.getPickup2Address());
            // 22
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(item.getPickup2Postalcode());
            // 23
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue(item.getLuggageAmount());
            // 24
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 25
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 26
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
            // 27
            cell = orderRow.createCell(colIndex++);
            cell.setCellValue("");
        }

        for (Integer i = 0; i < PICKUP_COLUMN_NAMES.length; i++) {
            worksheet.autoSizeColumn(i);
        }

        return workbook;
    }
}
