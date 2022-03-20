package es.secaro.thymeleafdemo.controller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.secaro.thymeleafdemo.dto.Criterio;
import es.secaro.thymeleafdemo.dto.Pregunta;
import es.secaro.thymeleafdemo.dto.Question;
import es.secaro.thymeleafdemo.dto.Response;
import es.secaro.thymeleafdemo.dto.Subcriterio;
import es.secaro.thymeleafdemo.dto.Subtema;
import es.secaro.thymeleafdemo.dto.Table01;
import es.secaro.thymeleafdemo.dto.Table02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lowagie.text.DocumentException;

import es.secaro.thymeleafdemo.dto.Raffle;
import es.secaro.thymeleafdemo.service.PdfGenarator;

@Controller
public class RaffleController {

	@Autowired
	private PdfGenarator pdfGenarator;

	private String templateName = "templatePDF.html";
	private String templateName2 = "templatePDFEPR1.html";
	private String templateName3 = "templatePDF-EP2T1.html";
	private String templateName4 = "templatePDF-EP2T2.html";
	private String templateName5 = "templatePDF-EP2.html";
	private String templateName6 = "templatePDF-EPR2.html";
	private String templateName7 = "templatePDF-EP3T1.html";
	private String templateName8 = "templatePDF-EP3.html";
	private String templateName9 = "templatePDF-EPR3.html";
	private String templateName10 = "templatePDF-EF1D1.html";
	private String templateName11 = "templatePDF-EF1D2.html";
	private String templateName12 = "templatePDF-EF1D3.html";
	private String templateName13 = "templatePDF-EFR1.html";
	private String templateName14 = "templatePDF-EF2D1.html";
	private String templateName15 = "templatePDF-EF2D2.html";
	private String templateName16 = "templatePDF-EFR2.html";
	private String templateName17 = "templatePDF-EF3.html";
	private String templateName18 = "templatePDF-EFR3.html";
	private String templateName19 = "templatePDF-EF4.html";
	private String templateName20 = "templatePDF-EFR4.html";
	
	private String templateName21 = "templatePDF-EF5.html";
	private String templateName22 = "templatePDF-EFR5.html";
	private String templateName23 = "templatePDF-EF6.html";
	private String templateName24 = "templatePDF-EFR6.html";
	private String templateName25 = "templatePDF-EF7.html";
	private String templateName26 = "templatePDF-EFR7.html";
	private String templateName29 = "templatePDF-EF9.html";
	private String templateName30 = "templatePDF-EFR9.html";
	private String templateName33 = "templatePDF-EF11.html";
	private String templateName34 = "templatePDF-EFR11.html";
	private String templateName35 = "templatePDF-Estructura_PM_Preliminar.html";
	private String templateName37 = "templatePDF-Eval_PM_Preliminar.html";
	private String templateName38 = "templatePDF-Grupo_de_Interes.html";
	private String templateName39 = "templatePDF-Eval_GI.html";
	private String templateName36 = "templatePDF-Informe_Precisiones.html";
	
	private String fileName = "reaffle.pdf";

	@GetMapping("/raffle")
	public String raffleForm(final Model model) {
		model.addAttribute("raffle", new Raffle());
		return "raffle";
	}

	@PostMapping("/raffle")
	public String raffleSubmit(@ModelAttribute final Raffle raffle) {
		// List<Response> winners = getResponseItems();
		return "result";
	}

	@GetMapping("/raffle/pdf/ep1")
	public ResponseEntity<ByteArrayResource> rafflePDFEP1(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {

		// List<Response> questionnaire = getResponseItems();
		List<Table01> table01data = getTable1();
		List<Table02> table02data = getTable2();
		List<Table02> table03data = getTable3();
		List<Table02> table05data = getTable5();
		List<Table02> table06data = getTable6();
		List<Table02> table07data = getTable7();
		List<Table02> table08data = getTable8();
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		String titulo01 = "Valor del title 01";

		/* Set mapParameter here to read from the Pdf template */
		mapParameter.put("name", "Proyecto SERNANP");
		mapParameter.put("titleOne", titulo01);
		mapParameter.put("table01", table01data);
		mapParameter.put("table02", table02data);
		mapParameter.put("table03", table03data);
		mapParameter.put("table05", table05data);
		mapParameter.put("table06", table06data);
		mapParameter.put("table07", table07data);
		mapParameter.put("table08", table08data);
		// mapParameter.put("questionnaire", questionnaire);

		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/epr1")
	public ResponseEntity<ByteArrayResource> rafflePDFEPR1(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		List<Table02> table09data = getTable9();
		List<Subcriterio> table10data = getTable10();
		List<Subcriterio> table11data = getTable11();
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		mapParameter.put("para", "Indicar el nombre completo del profesional y cargo que corresponda");
		mapParameter.put("de", "Indicar el nombre completo del profesional y cargo que corresponda");
		mapParameter.put("asunto","Evaluación de los términos de Referencia del Plan Maestro del (Indicar el nombre del ANP)");
		mapParameter.put("referencia", "Indicar el documento de referencia y el CTU que corresponda");
		mapParameter.put("fecha", "Ciudad, XX de XXXX de 202X");
		mapParameter.put("anpname", "Indicar el nombre del ANP");
		mapParameter.put("fechapresentacion", "Indicar la fecha que presento el TdR vía SGD");
		mapParameter.put("table09", table09data);
		mapParameter.put("table10", table10data);
		mapParameter.put("table11", table11data);
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName2, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);

	}
	@GetMapping("/raffle/pdf/ep2t1")
	public ResponseEntity<ByteArrayResource> rafflePDFEP2T1(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		List<Subtema> table12data =  getTable12();
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		mapParameter.put("anpname", "(Indicar el nombre del ANP según lo señalado en la norma de creación/establecimiento del ANP)");
		mapParameter.put("fecha", "Ciudad, día/mes/año");
		mapParameter.put("table12", table12data);

		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName3, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/ep2t2")
	public ResponseEntity<ByteArrayResource> rafflePDFEP2T2(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		mapParameter.put("anpname", "(Indicar el nombre del ANP según lo señalado en la norma de creación/establecimiento del ANP)");
		mapParameter.put("fecha", "Ciudad, día/mes/año");
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName4, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);

	}
	@GetMapping("/raffle/pdf/ep2")
	public ResponseEntity<ByteArrayResource> rafflePDFEP2(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName5, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);

	}
	@GetMapping("/raffle/pdf/epr2")
	public ResponseEntity<ByteArrayResource> rafflePDFEPR2(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		mapParameter.put("de", "Indicar el nombre completo del profesional y cargo que corresponda");
		mapParameter.put("asunto","Evaluación de los términos de Referencia del Plan Maestro del (Indicar el nombre del ANP)");
		mapParameter.put("referencia", "Indicar el documento de referencia y el CTU que corresponda");
		mapParameter.put("fecha", "Ciudad, XX de XXXX de 202X");
		mapParameter.put("anpname", "Indicar el nombre del ANP");
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName6, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);

	}
	@GetMapping("/raffle/pdf/ep3t1")
	public ResponseEntity<ByteArrayResource> rafflePDFEP3T1(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName7, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);

	}
	@GetMapping("/raffle/pdf/ep3")
	public ResponseEntity<ByteArrayResource> rafflePDFEP3(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		mapParameter.put("fecha", "Ciudad, XX de XXXX de 202X");
		mapParameter.put("anpname", "Indicar el nombre del ANP");
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName8, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);

	}
	@GetMapping("/raffle/pdf/epr3")
	public ResponseEntity<ByteArrayResource> rafflePDFEPR3(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		mapParameter.put("para", "Indicar el nombre completo del profesional y cargo que corresponda");
		mapParameter.put("de", "Indicar el nombre completo del profesional y cargo que corresponda");
		mapParameter.put("asunto","Evaluación de los términos de Referencia del Plan Maestro del (Indicar el nombre del ANP)");
		mapParameter.put("referencia", "Indicar el documento de referencia y el CTU que corresponda");
		mapParameter.put("fecha", "Ciudad, XX de XXXX de 202X");
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName9, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);

	}
	@GetMapping("/raffle/pdf/ef1d1")
	public ResponseEntity<ByteArrayResource> rafflePDFEF1D1(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName10, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/ef1d2")
	public ResponseEntity<ByteArrayResource> rafflePDFEF1D2(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName11, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/ef1d3")
	public ResponseEntity<ByteArrayResource> rafflePDFEF1D3(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName12, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/efr1")
	public ResponseEntity<ByteArrayResource> rafflePDFEFR1(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName13, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/ef2d1")
	public ResponseEntity<ByteArrayResource> rafflePDFEF2D1(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName14, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/ef2d2")
	public ResponseEntity<ByteArrayResource> rafflePDFEF2D2(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName15, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/efr2")
	public ResponseEntity<ByteArrayResource> rafflePDFEFR2(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName16, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/ef3")
	public ResponseEntity<ByteArrayResource> rafflePDFEF3(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName17, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/efr3")
	public ResponseEntity<ByteArrayResource> rafflePDFEFR3(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName18, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/ef4")
	public ResponseEntity<ByteArrayResource> rafflePDFEF4(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName19, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/efr4")
	public ResponseEntity<ByteArrayResource> rafflePDFEFR4(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName20, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	
	@GetMapping("/raffle/pdf/ef5")
	public ResponseEntity<ByteArrayResource> rafflePDFEF5(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName21, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/efr5")
	public ResponseEntity<ByteArrayResource> rafflePDFEFR5(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName22, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/ef6")
	public ResponseEntity<ByteArrayResource> rafflePDFEF6(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName23, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/efr6")
	public ResponseEntity<ByteArrayResource> rafflePDFEFR6(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName24, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/ef7")
	public ResponseEntity<ByteArrayResource> rafflePDFEF7(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName25, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/efr7")
	public ResponseEntity<ByteArrayResource> rafflePDFEFR7(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName26, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/ef9")
	public ResponseEntity<ByteArrayResource> rafflePDFEF9(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName29, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/efr9")
	public ResponseEntity<ByteArrayResource> rafflePDFEFR9(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName30, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/ef11")
	public ResponseEntity<ByteArrayResource> rafflePDFEF11(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName33, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/efr11")
	public ResponseEntity<ByteArrayResource> rafflePDFEFR11(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName34, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/estructura_pm_preliminar")
	public ResponseEntity<ByteArrayResource> rafflePDFEstructura_PM_Preliminar(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName35, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/informe_precisiones")
	public ResponseEntity<ByteArrayResource> rafflePDFInforme_Precisiones(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName36, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/eval_pm_preliminar")
	public ResponseEntity<ByteArrayResource> rafflePDFEval_PM_Preliminar(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName37, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/grupo_de_interes")
	public ResponseEntity<ByteArrayResource> rafflePDFGrupo_de_Interes(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName38, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	@GetMapping("/raffle/pdf/eval_gi")
	public ResponseEntity<ByteArrayResource> rafflePDFEval_GI(@ModelAttribute final Raffle raffle,
			final HttpServletRequest request, final HttpServletResponse response) throws DocumentException {
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		ByteArrayOutputStream byteArrayOutputStreamPDF = pdfGenarator.createPdf(templateName39, mapParameter, request,
				response);
		ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(byteArrayOutputStreamPDF.toByteArray());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).contentLength(inputStreamResourcePDF.contentLength())
				.body(inputStreamResourcePDF);
	}
	
	/*
	 * private List<Response> getResponseItems() { List<Response> dataArray = new
	 * ArrayList<Response>() {}; Question questionItem1 = new Question(1,
	 * "¿De que lugar eres?"); Response responseItem1 = new Response(1,
	 * questionItem1, "Soy de Nanria.", "Activo");
	 * 
	 * Question questionItem2 = new Question(2, "¿Que edad tienes?"); Response
	 * responseItem2 = new Response(2, questionItem2,
	 * "la edad solo es un número sin importancia.", "Inactivo");
	 * 
	 * Question questionItem3 = new Question(3, "¿Te gusta programar?"); Response
	 * responseItem3 = new Response(3, questionItem3,
	 * "creo que si me gusta desarrollar.", "Activo");
	 * 
	 * Question questionItem4 = new Question(4,
	 * "¿cual es tu lenguaje de programación favorito?"); Response responseItem4 =
	 * new Response(4, questionItem4, "Javascript es lo mejor que hay.", "Activo");
	 * 
	 * Question questionItem5 = new Question(5,
	 * "¿another question something or whaterver 05?"); Response responseItem5 = new
	 * Response(5, questionItem5, "Another response, something or whatever 05.",
	 * "Activo");
	 * 
	 * Question questionItem6 = new Question(6,
	 * "¿another question something or whaterver 06?"); Response responseItem6 = new
	 * Response(6, questionItem6, "Another response, something or whatever 06.",
	 * "Inactivo");
	 * 
	 * Question questionItem7 = new Question(7,
	 * "¿another question something or whaterver 07?"); Response responseItem7 = new
	 * Response(7, questionItem7, "Another response, something or whatever 07.",
	 * "Activo");
	 * 
	 * Question questionItem8 = new Question(8,
	 * "¿another question something or whaterver 08?"); Response responseItem8 = new
	 * Response(8, questionItem8, "Another response, something or whatever 08.",
	 * "Activo");
	 * 
	 * Question questionItem9 = new Question(9,
	 * "¿another question something or whaterver 09?"); Response responseItem9 = new
	 * Response(9, questionItem9, "Another response, something or whatever 09.",
	 * "Activo");
	 * 
	 * Question questionItem10 = new Question(10,
	 * "¿another question something or whaterver 010?"); Response responseItem10 =
	 * new Response(10, questionItem10,
	 * "Another response, something or whatever 010.", "Inactivo");
	 * 
	 * Question questionItem11 = new Question(11,
	 * "¿another question something or whaterver 011?"); Response responseItem11 =
	 * new Response(11, questionItem11,
	 * "Another response, something or whatever 011.", "Activo");
	 * 
	 * dataArray.add(responseItem1); dataArray.add(responseItem2);
	 * dataArray.add(responseItem3); dataArray.add(responseItem4);
	 * dataArray.add(responseItem5); dataArray.add(responseItem6);
	 * dataArray.add(responseItem7); dataArray.add(responseItem8);
	 * dataArray.add(responseItem9); dataArray.add(responseItem10);
	 * dataArray.add(responseItem11);
	 * 
	 * return dataArray; }
	 */
	private List<Table01> getTable1() {
		List<Table01> dataArray = new ArrayList<Table01>() {
		};
		Table01 data1 = new Table01(
				"El ANP requiere iniciar proceso de Plan Maestro - PM debido a que: (a) El Plan Maestro se encuentra en su cuarto año de vigencia o en año posterior (b) La última evaluación  de la implementación del Plan Maestro identifico la necesidad de su actualización",
				"Indicar la alternativa que corresponda y hacer un corto comentario");
		Table01 data2 = new Table01(
				"El ANP cuenta con: (a) ECA - Ejecutor de Contrato (Condición obligatoria para Reservas Comunales ). (b) Comisión Ejecutiva vigente o comisión Ad Hoc para llevar a cabo el proceso de actualización del Plan Maestro.",
				"Indicar la alternativa que corresponda y precisar el documento y el tiempo de vigencia.");
		Table01 data3 = new Table01(
				"El ANP se encuentra en la lista de áreas aptas para iniciar proceso de elaboración y/o actualización de PM y comunicación a jefaturas de ANP.",
				"Indicar el número y fecha del documento en el que se incluya al ANP para realizar la elaboración/actualización del Plan Maestro");
		dataArray.add(data1);
		dataArray.add(data2);
		dataArray.add(data3);
		return dataArray;
	}

	private List<Table02> getTable2() {
		List<Table02> dataArray = new ArrayList<Table02>() {
		};
		Table02 data1 = new Table02(
				"1er taller de inducción del proceso de elaboración/ actualización de Planes Maestros: La lógica de la planificación y  elaboración de los términos de referencia del proceso.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la unidad a cargo de brindar el taller y de ser posible los participantes. Por ejemplo: A cargo de la DDE, a través de la UOF de Políticas y Prospectiva, con la participación de las Unidades de la DGANP");
		Table02 data2 = new Table02(
				"Reunión informativa y de organización interna del equipo de la jefatura para ajuste en la elaboración de los TdR del proceso de PM (Normativa de salud dada por el Estado).",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del ANP que corresponda. Por ejemplo: A cargo del equipo técnico del ANP XXX");
		Table02 data3 = new Table02(
				"Envío de la propuesta ajustada de TdR a la Dirección de Desarrollo Estratégico-DDE",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del ANP que corresponda. Por ejemplo: A cargo del equipo técnico del ANP XXX");
		Table02 data4 = new Table02("Sustentación de la propuesta ajustada de TdR ante las Direcciones de línea.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX, con la participación de las Direcciones de línea (DDE-DGANP)");
		Table02 data5 = new Table02(
				"Revisión y conformidad a la propuesta ajustada de Términos de Referencia  entre la JANP  y Comisión Ejecutiva del Comité de Gestión. Firma de Acta que da conformidad o precisa observaciones",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX, con la participación del CE de CdG");
		Table02 data6 = new Table02(
				"Envío de propuesta de Términos de referencia suscrito por la CECG del ANP (En caso de haber observaciones debe remitir el informe respectivo).",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX");
		Table02 data7 = new Table02("Aprobación de los TdR con Resolución Directoral.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la DDE como responsables de aprobar los TdR con el Visto Bueno de la DGANP");
		dataArray.add(data1);
		dataArray.add(data2);
		dataArray.add(data3);
		dataArray.add(data4);
		dataArray.add(data5);
		dataArray.add(data6);
		dataArray.add(data7);
		return dataArray;
	}

	private List<Table02> getTable3() {
		List<Table02> dataArray = new ArrayList<Table02>() {
		};
		Table02 data1 = new Table02("Evaluación del Plan Maestro vigente",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX");
		Table02 data2 = new Table02("Elaboración de Análisis situacional del ANP",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX");
		Table02 data3 = new Table02(
				"Socialización del análisis Situacional del ANP y evaluación del PM con la CECG.(Acta)",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX, con la participación del CE de CdG");
		Table02 data4 = new Table02("Remisión del análisis Situacional del ANP y evaluación del Plan Maestro vigente",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX");
		Table02 data5 = new Table02(
				"Revisión y visto bueno al Análisis Situacional del ANP y a la evaluación del Plan Maestro vigente.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la dirección y unidad responsable (A cargo de la DDE-UOF Políticas y Prospectivas)");
		dataArray.add(data1);
		dataArray.add(data2);
		dataArray.add(data3);
		dataArray.add(data4);
		dataArray.add(data5);
		return dataArray;
	}

	private List<Table02> getTable5() {
		List<Table02> dataArray = new ArrayList<Table02>() {
		};
		Table02 data1 = new Table02(
				"I Taller de inducción: Priorización de elementos, construcción de la visión a 20 años y establecimiento de objetivos: Priorización de elementos ambientales para la conservación (elementos ambientales, SSEE y bienestar), construcción del modelo conceptual del ANP, construcción de la visión a 20 años del ANP, establecimiento de los objetivos del Plan Maestro a corto y largo plazo",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la unidad a cargo de brindar el taller y de ser posible los participantes. Por ejemplo: A cargo de la DDE, a través de la UOF de Políticas y Prospectiva, con la participación del equipo técnico del ANP XXX y las Unidades de la DGANP");
		Table02 data2 = new Table02("Elaboración del ejercicio de los elementos de la visión, objetivos priorizados.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX y de ser posible los participantes. Por ejemplo: A cargo del equipo técnico del ANP XXX, con la participación de las Unidades de la DGANP");
		Table02 data3 = new Table02("Envío de ejercicios a la DDE",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX");
		Table02 data4 = new Table02("Revisión del ejercicio  de los elementos de la visión, objetivos priorizados.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la unidad a cargo de la revisión. Por ejemplo: A cargo de la DDE, a través de la UOF de Políticas y Prospectiva, con la participación del equipo técnico del ANP XXX y las Unidades de la DGANP");
		Table02 data5 = new Table02(
				"Taller para socialización y consolidación de visión y objetivos priorizados\nFecha: 12 de abril del 2021\nHora: 9:00 a.m.\nLugar: virtual por plataforma.\nAsistentes: 40 participantes",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX");
		Table02 data6 = new Table02(
				"Envío de los resultados de la fase: Visión compartida, tabla de objetivos priorizados,  actas de reuniones.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX");
		Table02 data7 = new Table02(
				"II Taller de inducción: Priorización de amenazas directas: Diseño y análisis de la situación actual en el modelo conceptual, análisis y priorización de amenazas directas y oportunidades",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la unidad a cargo de brindar el taller y de ser posible los participantes. Por ejemplo: A cargo de la DDE, a través de la UOF de Políticas y Prospectiva, con la participación del equipo técnico del ANP XXX y las Unidades de la DGANP");
		Table02 data8 = new Table02(
				"Elaboración del Modelo Conceptual (elementos ambientales, factores, servicios ecosistémicos relacionados al bienestar humano y población que se beneficia de los servicios ecosistémicos). Asimismo,  se elaborará la propuesta de actores que conformarán los grupos de interés.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX y de ser posible los participantes. Por ejemplo: A cargo del equipo técnico del ANP XXX, con la participación de las Unidades de la DGANP");
		Table02 data9 = new Table02("Envío del modelo conceptual",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX");
		Table02 data10 = new Table02("Revisión del modelo conceptual",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la unidad a cargo de la revisión. Por ejemplo: A cargo de la DDE, a través de la UOF de Políticas y Prospectiva, con la participación del equipo técnico del ANP XXX y las Unidades de la DGANP");
		Table02 data11 = new Table02(
				"Taller de validación del modelo conceptual y estrategias con los diferentes actores e identificación de grupos de interés.\nFecha: 21 de mayo del 2021\nHora: 9:00 am\nLugar: Virtual por plataforma\nAsistentes: 20 a 30 personas",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX y de ser posible los participantes. Por ejemplo: A cargo del equipo técnico del ANP XXX, con la participación de las Unidades de la DGANP, CdG y actores claves.");
		Table02 data12 = new Table02(
				"Envío de los resultados de la fase: Modelo conceptual (elementos ambientales, factores, servicios ecosistémicos relacionados al bienestar humano y población que se beneficia de los servicios ecosistémicos) y estrategias priorizadas",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX");
		Table02 data13 = new Table02(
				"Conformidad del Modelo Conceptual, Estrategias priorizadas e identificación de Grupos de Interés.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la unidad a cargo de la revisión y conformidad. Por ejemplo: A cargo de la DDE, a través de la UOF de Políticas y Prospectiva, con el visto bueno de la DGANP");
		dataArray.add(data1);
		dataArray.add(data2);
		dataArray.add(data3);
		dataArray.add(data4);
		dataArray.add(data5);
		dataArray.add(data6);
		dataArray.add(data7);
		dataArray.add(data8);
		dataArray.add(data9);
		dataArray.add(data10);
		dataArray.add(data11);
		dataArray.add(data12);
		dataArray.add(data13);
		return dataArray;
	}

	private List<Table02> getTable6() {
		List<Table02> dataArray = new ArrayList<Table02>() {
		};
		Table02 data1 = new Table02(
				"III Taller de inducción: Estrategias, resultados y matriz de planificación financiera: Formulación y priorización de estrategias, cadena de resultados (definición e importancia), elaboración de indicadores de resultados e impacto, construcción de matriz de planificación estratégica del ANP",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la unidad a cargo de brindar el taller y de ser posible los participantes. Por ejemplo: A cargo de la DDE, a través de la UOF de Políticas y Prospectiva, con la participación del equipo técnico del ANP XXX y las Unidades de la DGANP");
		Table02 data2 = new Table02("Definición de propuestas de estrategias y cadena de resultados.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX y de ser posible los participantes. Por ejemplo: A cargo del equipo técnico del ANP XXX, con la participación de las Unidades de la DGANP, CdG y actores claves.");
		Table02 data3 = new Table02("Envío de propuestas de estrategias y cadena de resultados.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico de la Jefatura del ANP XXX");
		Table02 data4 = new Table02(
				"Revisión de propuestas de estrategias y cadena de resultados y organización de los grupos de interés.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la unidad a cargo de la revisión y conformidad. Por ejemplo: A cargo de la DDE, a través de la UOF de Políticas y Prospectiva, con la participación de las unidades de la DGANP");
		Table02 data5 = new Table02(
				"Trabajo con los grupos de interés a través de reuniones, talleres, entre otros, de acuerdo a la organización, estrategias y obtención de compromisos.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX y de ser posible los participantes. Por ejemplo: A cargo del equipo técnico del ANP XXX, con la participación de las Unidades de la DGANP, CdG y actores claves.");
		Table02 data6 = new Table02("Consolidación de estrategias y cadena de resultados.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX y de ser posible los participantes. Por ejemplo: A cargo del equipo técnico del ANP XXX,");
		Table02 data7 = new Table02(
				"Fecha de remisión de los resultados de la fase: estrategias, cadena de resultados.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX y de ser posible los participantes. Por ejemplo: A cargo del equipo técnico del ANP XXX,");
		Table02 data8 = new Table02("Elaboración de la estructura de financiamiento.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX y de ser posible los participantes. Por ejemplo: A cargo del equipo técnico del ANP XXX, con la participación de las Unidades de la DGANP y OPP");
		Table02 data9 = new Table02("Conformidad  de las estrategias y cadena de resultados.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la unidad a cargo de la revisión y conformidad. Por ejemplo: A cargo de la DDE, a través de la UOF de Políticas y Prospectiva, con el visto bueno de la DGANP");
		dataArray.add(data1);
		dataArray.add(data2);
		dataArray.add(data3);
		dataArray.add(data4);
		dataArray.add(data5);
		dataArray.add(data6);
		dataArray.add(data7);
		dataArray.add(data8);
		dataArray.add(data9);
		return dataArray;
	}

	private List<Table02> getTable7() {
		List<Table02> dataArray = new ArrayList<Table02>() {
		};
		Table02 data1 = new Table02("Envío de la propuesta preliminar del Plan Maestro",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX");
		Table02 data2 = new Table02(
				"Sustentación del Plan Maestro preliminar y propuesta de zonificación ante las Direcciones de línea.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX y de ser posible los participantes. Por ejemplo: A cargo del equipo técnico del ANP XXX, con la participación de las Unidades de la DGANP y DDE-UOF de PyP");
		Table02 data3 = new Table02("Inclusión de aportes y Levantamiento de observaciones",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX");
		Table02 data4 = new Table02("Remisión de levantamiento de observaciones.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX");
		Table02 data5 = new Table02("Conformidad de la propuesta preliminar del Plan Maestro ",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre de la unidad a cargo de la revisión y conformidad. Por ejemplo: A cargo de la DDE, a través de la UOF de Políticas y Prospectiva, con el visto bueno de la DGANP");
		Table02 data6 = new Table02(
				"Taller de Validación del Plan Maestro y zonificación con la comisión ejecutiva del Comité de Gestión y actores estratégicos. Fecha: 16/11/2021 Hora: 9:00 am Lugar: Plataforma virtual. Asistentes: 50 participantes",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX");
		Table02 data7 = new Table02(
				"Fecha máxima prevista para recepción de observaciones o recomendaciones al Plan Maestro y zonificación de parte de los actores relacionados al ANP.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX");
		Table02 data8 = new Table02(
				"Remisión a la DDE del Informe de precisiones a la propuesta preliminar del PM y zonificación (en caso se requiera).",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX");
		dataArray.add(data1);
		dataArray.add(data2);
		dataArray.add(data3);
		dataArray.add(data4);
		dataArray.add(data5);
		dataArray.add(data6);
		dataArray.add(data7);
		dataArray.add(data8);
		return dataArray;
	}

	private List<Table02> getTable8() {
		List<Table02> dataArray = new ArrayList<Table02>() {
		};
		Table02 data1 = new Table02(
				"Envío de la propuesta definitiva del Plan Maestro (visado por la comisión ejecutiva del CdG) a las Direcciones de Línea junto al Acta de validación de la CECG.",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX");
		Table02 data2 = new Table02("Sustentación de la versión final del PM  ante la Alta Dirección del SERNANP",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX y de ser posible los participantes. Por ejemplo: A cargo del equipo técnico del ANP XXX, con la participación de las Unidades de la DGANP, DDE-UOF de PyP y Otros");
		Table02 data3 = new Table02(
				"Envío de Informe de precisiones, informe del proceso participativos con sus medios de verificación,  el PM definitivo (visado por las jefaturas).",
				"Precisar la fecha que corresponda; por ejemplo: Hasta el XX de XXXXX de 202X",
				"Indicar el nombre del equipo técnico del ANP XXX");
		dataArray.add(data1);
		dataArray.add(data2);
		dataArray.add(data3);
		return dataArray;
	}

	private List<Table02> getTable9() {
		List<Table02> dataArray = new ArrayList<Table02>() {
		};
		Table02 data1 = new Table02(
				"a. Oficio de remisión de los TdR por la Jefatura del ANP.( Fecha de Presentación de Término de Referencia)",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data2 = new Table02("b.  TdR cumple los contenidos mínimos.", "Indicar la alternativa que corresponda",
				"Indicar los comentarios que se crea conveniente precisar");
		Table02 data3 = new Table02("c. Acta de aprobación de los TdR.", "Indicar la alternativa que corresponda",
				"Indicar los comentarios que se crea conveniente precisar");
		dataArray.add(data1);
		dataArray.add(data2);
		dataArray.add(data3);
		return dataArray;
	}

	private List<Subcriterio> getTable10() {
		List<Subcriterio> dataArray = new ArrayList<>();
		Subcriterio subcriterio1 = new Subcriterio();
		subcriterio1.setDescripcion("Sistematización de información previa");
		List<Table02> criterios = new ArrayList<>();
		Table02 data1 = new Table02(
				"Considera la realización del ejercicio de sistematización de sus información actualizada.,",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data2 = new Table02(
				"Considera la evaluación de sus plan maestro anterior(solo en el caso de áreas que actualizan su Plan)",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data3 = new Table02("Considera reunión de organización interna y explicación del proceso.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		criterios.add(data1);
		criterios.add(data2);
		criterios.add(data3);
		subcriterio1.setCriterios(criterios);
		dataArray.add(subcriterio1);
		// ============================================
		Subcriterio subcriterio2 = new Subcriterio();
		subcriterio2.setDescripcion("Fase: Elaboración de los Términos de Referencia");
		List<Table02> criterios2 = new ArrayList<>();
		Table02 data4 = new Table02("El ANP se encuentra en la lista publicada en el Diario Oficial El Peruano.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data5 = new Table02(
				"Los TdR han sido aprobados por la Comisión Ejecutiva del Comité de Gestión vigente.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data6 = new Table02(
				"Se precisan los mecanismos de publicidad sobre el inicio del proceso de elaboración/ actualización del Plan maestro, que incluye: - Una publicación en un diario de circulación regional, - La presentación de los términos de referencia en asamblea general del Comité de Gestión (en caso los TdR solo fueran aprobados por la Comisión Ejecutiva del Comité de Gestión).",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data7 = new Table02(
				"Precisa fecha de remisión del informe sobre las comunicaciones realizadas para el inicio del proceso",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		criterios2.add(data4);
		criterios2.add(data5);
		criterios2.add(data6);
		criterios2.add(data7);
		subcriterio2.setCriterios(criterios2);
		dataArray.add(subcriterio2);
		// ============================================
		Subcriterio subcriterio3 = new Subcriterio();
		subcriterio3.setDescripcion("Fase: Construcción de Visión Compartida y Priorización de Objetivos");
		List<Table02> criterios3 = new ArrayList<>();
		Table02 data8 = new Table02(
				"Precisa fecha máxima de presentación preliminar de visión, objetivos y modelo conceptual.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data9 = new Table02("Precisa la fecha de remisión de los resultados de la fase de visión ",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		criterios3.add(data8);
		criterios3.add(data9);
		subcriterio3.setCriterios(criterios3);
		dataArray.add(subcriterio3);
		// ============================================
		Subcriterio subcriterio4 = new Subcriterio();
		subcriterio4.setDescripcion("Diseño de Zonificación");
		List<Table02> criterios4 = new ArrayList<>();
		Table02 data10 = new Table02("Precisa fecha máxima de presentación preliminar de zonificación.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data11 = new Table02("Precisa fecha máxima de sustentación con las direcciones.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data12 = new Table02("Precisa fecha máxima de socialización de la propuesta de zonificación.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data13 = new Table02(
				"Precisa Fecha máxima para recepción de observaciones a la zonificación propuesta.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data14 = new Table02(
				"Sustentación de la propuesta del Plan Maestro consolidado a las Direcciones de Línea.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data15 = new Table02("Precisar lugar y fecha de presentación del Plan Maestro consolidado.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data16 = new Table02(
				"Precisar fecha máxima prevista para recepción de observaciones o recomendaciones al Plan Maestro de parte de los actores relacionados al ANP.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data17 = new Table02(
				"Precisa fecha de presentación de la versión definitiva a la comisión Ejecutiva del Comité de Gestión.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		criterios4.add(data10);
		criterios4.add(data11);
		criterios4.add(data12);
		criterios4.add(data13);
		criterios4.add(data14);
		criterios4.add(data15);
		criterios4.add(data16);
		criterios4.add(data17);
		subcriterio4.setCriterios(criterios4);
		dataArray.add(subcriterio4);
		// ==============================================
		Subcriterio subcriterio5 = new Subcriterio();
		subcriterio5.setDescripcion("Fase: Validación del Plan Maestro");
		List<Table02> criterios5 = new ArrayList<>();
		Table02 data18 = new Table02("Precisa lugar y fechas de presentación del Plan Maestro consolidado.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data19 = new Table02(
				"Precisa fecha máxima prevista para recepción de observaciones o recomendaciones al Plan Maestro de parte de los actores relacionados al ANP.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data20 = new Table02(
				"Precisa fecha de presentación de la versión definitiva a la Comisión Ejecutiva del Comité de Gestión",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		criterios5.add(data18);
		criterios5.add(data19);
		criterios5.add(data20);
		subcriterio5.setCriterios(criterios5);
		dataArray.add(subcriterio5);
		// ==============================================
		Subcriterio subcriterio6 = new Subcriterio();
		subcriterio6.setDescripcion("Fase: Aprobación del Plan Maestro");
		List<Table02> criterios6 = new ArrayList<>();
		Table02 data21 = new Table02(
				"Precisa fecha de remisión de la Propuesta de Plan Maestro validada y el informe del proceso participativo a la Alta Dirección del SERNANP",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data22 = new Table02(
				"Precisa la fecha de sustentación del Plan Maestro definitivo a la Alta Dirección del SERNANP",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		criterios6.add(data21);
		criterios6.add(data22);
		subcriterio6.setCriterios(criterios6);
		dataArray.add(subcriterio6);
		return dataArray;
	}

	private List<Subtema> getTable12() {
		List<Subtema> dataArray = new ArrayList<>();
		List<Pregunta> preguntas1=new ArrayList<>();
		Pregunta pregunta1=new Pregunta("¿El modelo conceptual es el adecuado? ¿Sigue vigente?","Respuesta o Analisis");
		Pregunta pregunta2=new Pregunta("¿El modelo conceptual representaba la situación de hace 5 años?","Respuesta o Analisis");
		Pregunta pregunta3=new Pregunta("¿Contiene todos los elementos?","Respuesta o Analisis");
		Pregunta pregunta4=new Pregunta("¿Se identificaron las causas de las amenazas identificadas?","Respuesta o Analisis");
		Pregunta pregunta5=new Pregunta("¿Se hizo el análisis causa-efecto?","Respuesta o Analisis");
		Pregunta pregunta6=new Pregunta("¿Se identificaron los servicios ecosistémicos y el bienestar humano?","Respuesta o Analisis");
		preguntas1.add(pregunta1);
		preguntas1.add(pregunta2);
		preguntas1.add(pregunta3);
		preguntas1.add(pregunta4);
		preguntas1.add(pregunta5);
		preguntas1.add(pregunta6);
		List<Pregunta> preguntas2=new ArrayList<>();
		Pregunta pregunta7=new Pregunta("¿Estuvieron bien planteados los objetivos?","Respuesta o Analisis");
		Pregunta pregunta8=new Pregunta("¿Tiene objetivos ambientales, económicos, sociales y culturales?, ¿Tienen relación con los elementos priorizados?","Respuesta o Analisis");
		Pregunta pregunta9=new Pregunta("¿Tienen indicadores de impacto y resultados finales? ¿Son medibles? ¿Se formuló bien?","Respuesta o Analisis");
		Pregunta pregunta10=new Pregunta("¿Se contó con línea base?","Respuesta o Analisis");
		Pregunta pregunta11=new Pregunta("¿Se consideró catástrofes o epidemias como la del COVID 19?","Respuesta o Analisis");
		preguntas2.add(pregunta7);
		preguntas2.add(pregunta8);
		preguntas2.add(pregunta9);
		preguntas2.add(pregunta10);
		preguntas2.add(pregunta11);
		List<Pregunta> preguntas3=new ArrayList<>();
		Pregunta pregunta12=new Pregunta("¿Es adecuada la estrategia de intervención e implementación del plan maestro?","Respuesta o Analisis");
		Pregunta pregunta13=new Pregunta("¿Las actividades y los resultados son coherentes con los objetivos, impactos y efectos previstos?","Respuesta o Analisis");
		Pregunta pregunta14=new Pregunta("¿Los supuestos planteados en la cadena de resultados son válidos?","Respuesta o Analisis");
		Pregunta pregunta15=new Pregunta("¿La visión es lo suficientemente clara como para permitir identificar los cambios esperados en el área natural protegida por parte de los actores sociales relacionados a ésta?","Respuesta o Analisis");
		Pregunta pregunta16=new Pregunta("¿Han sido adecuadas la estrategias y acciones propuestas, para atender las necesidades los actores definidas como elementos de conservación (bienestar humano)?","Respuesta o Analisis");
		Pregunta pregunta17=new Pregunta("¿Fue adecuada la identificación de los actores y beneficiarios del ANP?","Respuesta o Analisis");
		Pregunta pregunta18=new Pregunta("¿En qué medida las estrategias y acciones propuestas, permitieron la participación de los diferentes actores del ANP, en la gestión del ANP?","Respuesta o Analisis");
		Pregunta pregunta19=new Pregunta("Estas estrategias, ¿Permitieron la participación de las comunidades locales en la toma de decisiones? ","Respuesta o Analisis");
		Pregunta pregunta20=new Pregunta("¿En qué medida el plan maestro ha incorporado la de igualdad de género en su diseño y favorece el empoderamiento de las mujeres, los jóvenes, y otros grupos vulnerables? ","Respuesta o Analisis");
		Pregunta pregunta21=new Pregunta("¿Se ha insertado el enfoque de interculturalidad en los resultados del plan maestro?","Respuesta o Analisis");
		preguntas3.add(pregunta12);
		preguntas3.add(pregunta13);
		preguntas3.add(pregunta14);
		preguntas3.add(pregunta15);
		preguntas3.add(pregunta16);
		preguntas3.add(pregunta17);
		preguntas3.add(pregunta18);
		preguntas3.add(pregunta19);
		preguntas3.add(pregunta20);
		preguntas3.add(pregunta21);
		List<Pregunta> preguntas4=new ArrayList<>();
		Pregunta pregunta22=new Pregunta("¿Cuáles fueron los criterios utilizados para la zonificación","Respuesta o Analisis");
		Pregunta pregunta23=new Pregunta("¿se contó con un diagnóstico previo y completo?","Respuesta o Analisis");
		Pregunta pregunta24=new Pregunta("¿hubo coherencia entre las líneas de acción y las normas de uso?","Respuesta o Analisis");
		preguntas4.add(pregunta22);
		preguntas4.add(pregunta23);
		preguntas4.add(pregunta24);
		List<Pregunta> preguntas5=new ArrayList<>();
		Pregunta pregunta25=new Pregunta("¿Las modalidades de intervención, la estructura institucional, los recursos y procedimientos financieros, técnicos y operativos dispuestos, han contribuido u obstaculizado la consecución de los resultados y objetivos del plan maestro?","Respuesta o Analisis");
		Pregunta pregunta26=new Pregunta("¿Se han ejecutado todas las actividades previstas en el plan maestro?","Respuesta o Analisis");
		Pregunta pregunta27=new Pregunta("¿Fueron necesarias todas las actividades contempladas en el plan maestro para la consecución de los resultados?","Respuesta o Analisis");
		Pregunta pregunta28=new Pregunta("¿Cuáles son los factores limitantes y las ventajas para la implementación del plan maestro?","Respuesta o Analisis");
		preguntas5.add(pregunta25);
		preguntas5.add(pregunta26);
		preguntas5.add(pregunta27);
		preguntas5.add(pregunta28);
		List<Pregunta> preguntas6=new ArrayList<>();
		Pregunta pregunta29=new Pregunta("¿Se han identificado las estrategias y resultados?","Respuesta o Analisis");
		Pregunta pregunta30=new Pregunta("¿Qué resultados se han logrado hasta el momento de la evaluación?","Respuesta o Analisis");
		Pregunta pregunta31=new Pregunta("¿Son adecuados los indicadores de los objetivos y de los resultados del plan maestro?","Respuesta o Analisis");
		Pregunta pregunta32=new Pregunta("Estos resultados, ¿contribuyen al logro de los objetivos del plan maestro?","Respuesta o Analisis");
		Pregunta pregunta33=new Pregunta("Estos resultados, ¿contribuyen al logro de los objetivos del plan maestro?","Respuesta o Analisis");
		Pregunta pregunta34=new Pregunta("¿Existe una mayor participación o compromiso de los actores estratégicos para el logro los resultados?","Respuesta o Analisis");
		Pregunta pregunta35=new Pregunta("¿Existe una mayor participación de las mujeres para el logro de los resultados?","Respuesta o Analisis");
		Pregunta pregunta36=new Pregunta("¿Existe una mayor participación de las comunidades campesinas o comunidades nativas para lograr los resultados?","Respuesta o Analisis");
		Pregunta pregunta37=new Pregunta("¿Se han cumplido las hipótesis planteadas en la teoría de cambio /cadenas de resultados? ","Respuesta o Analisis");
		Pregunta pregunta38=new Pregunta("¿Cuáles fueron los principales factores que influyeron en el avance o no hacia el logro de los objetivos? ","Respuesta o Analisis");
		Pregunta pregunta39=new Pregunta("¿Se han tomado decisiones adecuadas para minimizar el riesgo de factores externos no previstos durante la implementación del plan maestro?","Respuesta o Analisis");
		Pregunta pregunta40=new Pregunta("¿Se ha gestionado de manera adecuada los factores externos al plan maestro? ","Respuesta o Analisis");
		preguntas6.add(pregunta29);
		preguntas6.add(pregunta30);
		preguntas6.add(pregunta31);
		preguntas6.add(pregunta32);
		preguntas6.add(pregunta33);
		preguntas6.add(pregunta34);
		preguntas6.add(pregunta35);
		preguntas6.add(pregunta36);
		preguntas6.add(pregunta37);
		preguntas6.add(pregunta38);
		preguntas6.add(pregunta39);
		preguntas6.add(pregunta40);
		List<Pregunta> preguntas7=new ArrayList<>();
		Pregunta pregunta41=new Pregunta("¿Cuáles son los cambios positivos y negativos producidos hasta ahora con la implementación del plan maestro, directa o indirectamente, intencionados o no?","Respuesta o Analisis");
		Pregunta pregunta42=new Pregunta("¿Cuáles son los impactos sobre el bienestar  de la población ubicada al interior del ANP y en sus zonas de influencia? ","Respuesta o Analisis");
		Pregunta pregunta43=new Pregunta("¿Estos incluyen beneficios sobre el ambiente? ¿Se mantienen o recuperan los elementos ambientales priorizados y servicios ecosistémicos?","Respuesta o Analisis");
		Pregunta pregunta44=new Pregunta("¿Cuáles son los impactos sobre el bienestar de la población?","Respuesta o Analisis");
		preguntas7.add(pregunta41);
		preguntas7.add(pregunta42);
		preguntas7.add(pregunta43);
		preguntas7.add(pregunta44);
		List<Pregunta> preguntas8=new ArrayList<>();
		Pregunta pregunta45=new Pregunta("¿Qué tan sostenibles son y/o serán los resultados alcanzados hasta la fecha a nivel ambiental, social, institucional y financiero?","Respuesta o Analisis");
		Pregunta pregunta46=new Pregunta("¿Existen factores que puedan poner en peligro y revertir los resultados del plan maestro?","Respuesta o Analisis");
		preguntas8.add(pregunta45);
		preguntas8.add(pregunta46);

		List<Criterio> criterios1=new ArrayList<>();
		Criterio criterio1 = new Criterio("MODELO CONCEPTUAL",preguntas1);
		Criterio criterio2 = new Criterio("OBJETIVOS E INDICADORES",preguntas2);
		Criterio criterio3 = new Criterio("ESTRATEGIAS Y RESULTADOS",preguntas3);
		Criterio criterio4 = new Criterio("ZONIFICACIÓN",preguntas4);
		criterios1.add(criterio1);
		criterios1.add(criterio2);
		criterios1.add(criterio3);
		criterios1.add(criterio4);
		List<Criterio> criterios2=new ArrayList<>();
		Criterio criterio5 = new Criterio("EFICIENCIA",preguntas5);
		Criterio criterio6 = new Criterio("EFICACIA",preguntas6);
		Criterio criterio7 = new Criterio("IMPACTO",preguntas7);
		Criterio criterio8 = new Criterio("SOSTENIBILIDAD",preguntas8);

		criterios2.add(criterio5);
		criterios2.add(criterio6);
		criterios2.add(criterio7);
		criterios2.add(criterio8);

		Subtema subtema1 = new Subtema();
		subtema1.setDescripcion("PERTINENCIA: Diseño del Plan Maestro vigente");
		subtema1.setCriterios(criterios1);
		Subtema subtema2 = new Subtema();
		subtema2.setDescripcion("Implementación");
		subtema2.setCriterios(criterios2);
		dataArray.add(subtema1);
		dataArray.add(subtema2);

		return dataArray;
	}
	private List<Subcriterio> getTable11() {
		List<Subcriterio> dataArray = new ArrayList<>();
		Subcriterio subcriterio1 = new Subcriterio();
		subcriterio1.setDescripcion("");
		List<Table02> criterios = new ArrayList<>();
		Table02 data1 = new Table02("Comisión ejecutiva vigente a la fecha del acuerdo.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		Table02 data2 = new Table02("Firman cuando menos los miembros de la Comisión Ejecutiva.",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		criterios.add(data1);
		criterios.add(data2);
		subcriterio1.setCriterios(criterios);
		dataArray.add(subcriterio1);
		Subcriterio subcriterio2 = new Subcriterio();
		subcriterio2.setDescripcion("Cronograma del proceso");
		List<Table02> criterios2 = new ArrayList<>();
		Table02 data3 = new Table02("Presente cronograma del proceso del elaboración y/o actualización ",
				"Indicar la alternativa que corresponda", "Indicar los comentarios que se crea conveniente precisar");
		criterios2.add(data3);
		subcriterio2.setCriterios(criterios2);
		dataArray.add(subcriterio2);
		return dataArray;
	}
}