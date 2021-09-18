/*
package com.winner.mes.ems.utils;

import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.pdf.BaseFont;

import java.io.*;

*/
/**
 * @author yzz
 * @date 2021/8/19
 * @description
 *//*

public class HTMLToPDF {
    */
/** HTML文件路径*//*

    public static final String   HTML   = "D:\\" + "cotton.html";
    */
/** 生成的PDF文件路径*//*

    public static final String   DEST   = "D:\\cotton"+ System.currentTimeMillis() + ".pdf"

    private static void readHtmlToPdfFile_1() {
        BufferedInputStream bis = null;
        ByteArrayOutputStream out = null;
        OutputStream os = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(HTML)));
            out = new ByteArrayOutputStream(1024);
            os = new FileOutputStream(DEST);

            byte[] temp = new byte[1024];
            int size = 0;
            while ((size = bis.read(temp)) != -1) {
                out.write(temp, 0, size);
            }

            String str = new String(out.toByteArray(), "utf-8");
            // String url = new File(HTML).toURI().toURL().toString();

            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(str);
            // renderer.setDocument(url);

            // 解决中文支持问题
            ITextFontResolver fontResolver = renderer.getFontResolver();
            String fontFilePath = "/simsun.ttc";
            fontResolver.addFont(fontFilePath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.layout();
            // 创建PDF
            renderer.createPDF(os);

            os.flush();
            out.flush();
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            try {
                os.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    */
/**
     * 读取HTML生成PDF文件，HTML中有图片加载
     *//*

    private static void readHtmlToPdfFile_2() {
        StringBuffer sb = new StringBuffer();
        String path = "C:\\Windows\\Fonts\\simsun.ttc";//字体文件。必须要。不然无法显示中文
        OutputStream out = null;
        BufferedReader reader = null;
        try {
            // 需要生成pdf的html文件
            reader = new BufferedReader(new FileReader(new File(HTML)));
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\r\n");
            }
            ITextRenderer render = new ITextRenderer();
            ITextFontResolver font = render.getFontResolver();
            font.addFont(path, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            // 生成后的pdf文件
            out = new FileOutputStream(new File(DEST));
            render.setDocumentFromString(sb.toString());
            // 设置图片html文件中图片的路径。需要在"123"文件夹下有html文件中需要的图片
            render.getSharedContext().setBaseURL("file:\\D:\\123\\");
            render.layout();
            render.createPDF(out);

            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                reader.close();
            } catch (IOException e) {
                logger.error("", e);
            }
        }
    }
}
*/
