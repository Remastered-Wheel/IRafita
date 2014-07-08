// no te main...
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Logger {
FileWriter fw;
BufferedWriter br;
File file = new File("log.log");
boolean fileExists = file.exists();
public void log(String message) {
try {
fw = new FileWriter(file, true);
br = new BufferedWriter(fw);
Calendar cal = Calendar.getInstance();
int hour = cal.get(Calendar.HOUR_OF_DAY);
if(hour > 12)
hour = hour - 12;
																			                    int minute = cal.get(Calendar.MINUTE);
int second = cal.get(Calendar.SECOND);
int millis = cal.get(Calendar.MILLISECOND);
																									                    int ampm = cal.get(Calendar.AM_PM); 
String ampmString;
if(ampm == 1)
ampmString = "PM";
else
ampmString = "AM";
																																	                    String now = String.format("%02d:%02d:%02d.%03d %s", hour, minute, second, millis, ampmString);
																																			                    System.out.println(now + " - " + message);
br.write(now + " - " + message);
																																							                    br.newLine();
br.close();
} catch (Exception err) {
System.out.println("Error");
}
								            }
public void create() {
try {
fw = new FileWriter(file, true);
br = new BufferedWriter(fw);
SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYYY");
String dateString = sdf.format(new Date());
if(file.length() != 0)
br.newLine();
System.out.println("Log: " + file.getAbsolutePath());
br.write("--------------------" + dateString + "--------------------");
br.newLine();
br.close();
} catch (Exception err) {
System.out.println("Error");
}
}
}
