package com.zan.poi.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/11 15/55
 */
@RestController
@RequestMapping(value = "/api/excel")
public class ExcelExportController {

    @GetMapping(value = "/export")
    public void export(HttpServletResponse response) throws IOException {
        Map<String, String> fieldMap = new LinkedHashMap<String, String>(); // 数据列信息
        fieldMap.put("id", "编号");
        fieldMap.put("name", "姓名");
        fieldMap.put("pwd", "密码");
        fieldMap.put("tel", "电话");
        fieldMap.put("code", "编码");
        fieldMap.put("comment", "备注");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet");// 创建sheet
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);// 创建第一行对象,设置表标题
        Cell cell;
        int cellNum = 0;
        for (String name : fieldMap.values()) {
            cell = row.createCell(cellNum);
            cell.setCellValue(name);
            cellNum++;
        }

        String fileName = "胡鹏";
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            response.reset();
            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
    }

    @GetMapping(value = "/getString")
    public String getString() {
        return "hello";
    }
}
