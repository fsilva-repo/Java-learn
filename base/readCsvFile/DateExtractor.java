package poo.base.readCsvFile;

import java.util.regex.*;
import java.time.LocalDate;

public class DateExtractor {
	
	public static final LocalDate function(String file) {

		Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher matcher = pattern.matcher(file);
		
		if (matcher.find()) {
      String dataMatcher = matcher.group();
      LocalDate date = LocalDate.parse(dataMatcher);
      
      return date;
  }
		return null;
	}
}
