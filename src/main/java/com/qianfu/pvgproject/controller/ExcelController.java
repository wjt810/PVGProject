package com.qianfu.pvgproject.controller;

import com.qianfu.pvgproject.pojo.Camera;
import com.qianfu.pvgproject.service.camera.CameraService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Resource
    private CameraService cameraService;

    @RequestMapping("excelExport")
    public void excelExport(HttpServletRequest request , HttpServletResponse response){
        // 获取到 list 数据
        List<Camera> cameraList = cameraService.cameraList(null);

        //======================EXCEL表导出核心代码====================
        //   声明一个Excel
        HSSFWorkbook wb=null;

        //title代表的是excel表开头每列的名字
        String[] title =new String[]{"区域","设备箱编号","接入层交换机IP","摄像机编号","产品序号","摄像机IP","备注"};

        String name="摄像机清单";
        //excel文件名
        String fileName = name+".xls";

        //sheet名
        String sheetName = name+"表";

        //二维数组铺满整个Excel
        String[][] content = new String[cameraList.size()][title.length];
        //--------------------------------------------------------------------------------------------

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        //设置背景色
//        style.setFillForegroundColor(HSSFColor.);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //设置边框
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置居右
        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);//水平居右
        style.setVerticalAlignment(HSSFCellStyle.ALIGN_RIGHT);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        //设置字体
        HSSFFont font=wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 14);//设置字体大小
        HSSFFont font2=wb.createFont();
        font2.setFontName("仿宋_GB2312");
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font2.setFontHeightInPoints((short) 12);

        style.setFont(font);//选择需要用到的字体格式

        //设置列宽
        sheet.setColumnWidth(0, 4000);//第一个参数代表列id（从0开始），第二个参数代表宽度值
        sheet.setColumnWidth(1, 4567);//第一个参数代表列id（从1开始），第二个参数代表宽度值
        sheet.setColumnWidth(2, 5267);//第一个参数代表列id（从2开始），第二个参数代表宽度值
        sheet.setColumnWidth(3, 4567);//第一个参数代表列id（从3开始），第二个参数代表宽度值
        sheet.setColumnWidth(4, 4567);//第一个参数代表列id（从4开始），第二个参数代表宽度值
        sheet.setColumnWidth(5, 4567);//第一个参数代表列id（从4开始），第二个参数代表宽度值
        sheet.setColumnWidth(6, 4567);//第一个参数代表列id（从4开始），第二个参数代表宽度值
        style.setWrapText(true);//设置自动换行

        //加边框
        HSSFCellStyle cellStyle=wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //把list放进content里
        for (int i = 0; i < cameraList.size(); i++) {
            content[i] = new String[title.length];
            Camera obj = cameraList.get(i);
            content[i][0] = obj.getCameraEq().getEqArea().getAreaName();
            content[i][1] = obj.getCameraEq().getEqNumber();
            content[i][2] = obj.getCameraEq().getEqInterchangerIP();
            content[i][3] = obj.getCameraNumber();
            content[i][4] = obj.getCameraProductNumber();
            content[i][5] = obj.getCameraIP();
            content[i][6] = obj.getCameraComment();
        }

        //添加数据进入excel
        for(int i=0;i<content.length;i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<content[i].length;j++){
                //将内容按顺序赋给对应的列对象
                HSSFCell cel = row.createCell(j);
                cel.setCellValue(content[i][j]);
            }
        }

        //响应到客户端
        try {
            try {
                try {
                    fileName = new String(fileName.getBytes(),"ISO8859-1");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                response.setContentType("application/octet-stream;charset=ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
