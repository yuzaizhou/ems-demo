package com.winner.mes.ems.controller;

import io.swagger.annotations.ApiOperation;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yzz
 * @date 2021/8/24
 * @description
 */
@RestController
public class JasperController {
    /**
     * 转换为pdf展示
     *
     * @param reportName
     * @param parameters
     * @param response
     */
    @ApiOperation("jasper测试")
    @PostMapping("/{reportName}")
    public void getReportByParam(
            @PathVariable("reportName") final String reportName,
            @RequestParam(required = false) Map<String, Object> parameters,
            HttpServletResponse response) throws SQLException, ClassNotFoundException, JRException, IOException {

        parameters = parameters == null ? new HashMap<>() : parameters;

        parameters.put("createTime","20210808");
        parameters.put("cottonRecord","1111");
        //获取文件流
        ClassPathResource resource = new ClassPathResource("jaspers" + File.separator + reportName + ".jasper");
        InputStream jasperStream = resource.getInputStream();

        JsonDataSource ds =
                new JsonDataSource(new ByteArrayInputStream("{}".getBytes(StandardCharsets.UTF_8)));

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
        // JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

}
