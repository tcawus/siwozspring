package org.siwoz.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.siwoz.dao.model.HistoricalVisit;
import org.siwoz.dao.model.Users;
import org.siwoz.model.CsvVisitBean;
import org.siwoz.service.general.HistoricalVisitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@Controller
@RequestMapping(value = "/exportcsv")
public class ExportCsvController {

	@Resource(name = "historicalVisitService")
	HistoricalVisitService historicalVisitService;

	@RequestMapping(value = "/")
	public void downloadCSV(HttpServletResponse response) throws IOException {
		String csvFileName = "visits.csv";
		response.setContentType("text/csv");
		// creates mock data
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);
		// uses the Super CSV API to generate CSV data from the model data
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);
		String[] header = { "name", "email", "visitDate" };
		csvWriter.writeHeader(header);
		for (HistoricalVisit historicalVisit : historicalVisitService.getAll()) {
			System.out.println(historicalVisit.getVisitDate());
			Users currentUser = historicalVisit.getIdPatient2Company()
					.getIdPatient().getIdUser();
			csvWriter.write(
					new CsvVisitBean(historicalVisit.getVisitDate().toString(),
							currentUser.getName() + " "
									+ currentUser.getSurname(), currentUser
									.getUsername()), header);
		}
		csvWriter.close();
	}
}
