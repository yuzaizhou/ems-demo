package com.winner.mes.ems.utils;

import com.winner.mes.ems.pojo.CottonRecord;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.C;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yzz
 * @date 2021/8/24
 * @description
 */
public class JasperUtil {
    public static void toPDF(String jasperFile, Map params) throws JRException {
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(jasperFile));
        List<CottonRecord> list = new ArrayList<>();
        for(int i=0;i<35;i++){
            CottonRecord cottonRecord = new CottonRecord();
            cottonRecord.setRow1(i);
            cottonRecord.setRow2(i+35);
            cottonRecord.setCottonLot1("num"+ i);
            cottonRecord.setCottonLot1("num"+ String.valueOf(i+35));
            list.add(cottonRecord);
        }
        JsonDataSource ds =
                new JsonDataSource(new ByteArrayInputStream("{}".getBytes(StandardCharsets.UTF_8)));
        String jrprint = "C:/Users/3542/Desktop/cotton.jrprint";
        JasperFillManager.fillReportToFile(jasperReport, jrprint, params, new JRBeanCollectionDataSource(list));
        //JasperFillManager.fillReportToFile(jasperReport, jrprint, params, ds);
        JasperExportManager.exportReportToPdfFile(jrprint, "C:/Users/3542/Desktop/cotton.pdf");
    }

    public static void toJasper(String jrxml, String jasperPath) throws Exception {
        JasperCompileManager.compileReportToFile(jrxml, jasperPath);
    }

    public static void toPDF2(String jasperFile, Map params) throws JRException {
        //???????????????
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(jasperFile));

        JsonDataSource ds =
                new JsonDataSource(new ByteArrayInputStream("{}".getBytes(StandardCharsets.UTF_8)));

        //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, ds);
        // JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint,"C:/Users/3542/Desktop/cottonRecord2.pdf");
        JasperExportManager.exportReportToHtmlFile(jasperPrint,"C:/Users/3542/Desktop/cottonRecord2.html");
    }

    public static void main(String[] args) {
        try {
            String jrxml = "C:/Users/3542/Desktop/cotton.jrxml";
            String jasperPath = "C:/Users/3542/Desktop/cotton.jasper";
            toJasper(jrxml,jasperPath);
            Map<String,Object> map = new HashMap<>();
            map.put("cottonLot","1111");
            map.put("specs","1234");
            //map.put("cottonRecordcc","????????????");
            toPDF(jasperPath,map);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static void toListPDF(String jasperFile, Map params) throws JRException {
        List<ApplyDetails> applyDetailsList = Lists.newArrayList();
        Map<String, Object> m = new HashMap<String, Object>();
        List<Map> list =materialsIeApplyDetailsService.getAllByDynamicWhere(id);
        MaterialsIeApply materialsIeApply=materialsIeApplyService.get(id);
        m.put("APPLICANT",materialsIeApply.getApplicant());//?????????
        m.put("ORDERNO",materialsIeApply.getOrderno());
        m.put("IEAPPLYTYPE","0".equals(materialsIeApply.getIeApplyType())?"??????":"??????");
        m.put("PLANGETDATE",materialsIeApply.getPlanGetDate());//????????????
        m.put("PLANRETURNDATE",materialsIeApply.getPlanReturnDate());//????????????
        m.put("AUDIT",materialsIeApply.getAuditId());//?????????
        m.put("AUDITDATE",materialsIeApply.getApplyDate());//????????????
        //(0????????????1????????????2????????????3????????????4?????????5???????????????6???????????????7??????)
        m.put("APPROVALSTATE", ReturnMaterialsIeApplyString.returnString(materialsIeApply.getApprovalState()));//???????????????
        m.put("APPLYDATE",materialsIeApply.getApplyDate());//??????????????????
        m.put("REASON",materialsIeApply.getReason());
        m.put("REMARK",materialsIeApply.getRemark());
        m.put("AUDITOPINION",materialsIeApply.getAuditOpinion());//????????????
        ApplyDetails applyDetails;
        for (Map map:list){
            applyDetails=new ApplyDetails(map.get("materialsname").toString(),map.get("suppliername").toString(),Integer.parseInt(map.get("amount").toString()),map.get("remark").toString(),map.get("spec").toString(),"1");
            applyDetailsList.add(applyDetails);
        }
        return ReportUtils.toPdf("MaterialsIeApply", m, applyDetailsList);
    }*/

}
