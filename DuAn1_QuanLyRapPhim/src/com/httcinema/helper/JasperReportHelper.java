/**
 * @author: Dinh Dat Thong
 * */

package com.httcinema.helper;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

public class JasperReportHelper {
	
	@SuppressWarnings("deprecation")
	public static JasperPrint getPrintPrototype(String reportSrcFile, Map<String, Object> parameters) throws JRException, ClassNotFoundException, SQLException{
		JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
		Connection conn = JdbcHelper.getConnection();
		JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
		
		JRDesignStyle jrDesignStyle = new JRDesignStyle();
	    // Set the Encoding to UTF-8 for pdf and embed font to arial
	    jrDesignStyle.setDefault(true);
	    File fontFile = new File("font", "arialbd.ttf");
		String fontFilePath = fontFile.getAbsolutePath();
	    String fontPath = fontFilePath;
	    jrDesignStyle.setPdfFontName(fontPath);
	    jrDesignStyle.setPdfEncoding("Identity-H");
	    jrDesignStyle.setPdfEmbedded(true);
	    print.addStyle(jrDesignStyle);
	    
	    return print;
	}
	
	
	public static void printToPDF(JasperPrint print, String outputFile) throws JRException, ClassNotFoundException, SQLException {
		// PDF Exportor.
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setExporterInput(new SimpleExporterInput(print)); // ExporterInput
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFile)); // ExporterOutput

		//
		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
		exporter.setConfiguration(configuration);
		exporter.exportReport();
	}
	
	/**
	 * In duy nhất một vé dựa theo mã vé
	 * */
	public static void inMotVePDF(String maVe) {
		String reportSrcFile = new File("mauIn", "Ve.jrxml").getAbsolutePath();
		String thuMucHinh = new File("").getAbsolutePath() + "/mauIn/hinh/";

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("maVe", maVe);
		parameters.put("thuMucHinh", thuMucHinh);
		
		try {
			printToPDF(getPrintPrototype(reportSrcFile, parameters), new File("ve", maVe + ".pdf").getAbsolutePath());
		} catch (ClassNotFoundException | JRException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * trả về 1 trang tương ứng với 1 vé dựa theo mã vé, hàm này được gọi bởi hàm inNhieuVePDF bên dưới
	 * */
	public static JasperPrint inVePDF(String maVe) {
		String reportSrcFile = new File("mauIn", "Ve.jrxml").getAbsolutePath();
		String thuMucHinh = new File("").getAbsolutePath() + "/mauIn/hinh/";

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("maVe", maVe);
		parameters.put("thuMucHinh", thuMucHinh);
		
		try {
			return getPrintPrototype(reportSrcFile, parameters);
		} catch (ClassNotFoundException | JRException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * in nhiều vé dựa vào một mảng gồm các mã vé, trả về đường dẫn đến file PDF vừa xuất
	 * */
	public static String inNhieuVePDF(int[] maVes) {
		List<JasperPrint> jasperPrints = new ArrayList<JasperPrint>();
		for (int i = 0; i < maVes.length; i++) {
			jasperPrints.add(inVePDF(maVes[i] + ""));
		}

		JRPdfExporter exporter = new JRPdfExporter();
		
		exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrints)); // dữ liệu cần in
		
		String outputFileName = maVes[0] + "-" + maVes[maVes.length - 1] + ".pdf"; // tên file PDF sẽ là mã vé nhỏ nhất - mã vé lớn nhất (15-22.pdf)
		String outputFilePath = new File("ve", outputFileName).getAbsolutePath();
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFilePath)); // vị trí xuất file
		
		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
		configuration.setCreatingBatchModeBookmarks(true);
		exporter.setConfiguration(configuration);
		try {
			exporter.exportReport();
			return outputFilePath;
		} catch (JRException e) {
			e.printStackTrace();
			return null;
		}
	}
}