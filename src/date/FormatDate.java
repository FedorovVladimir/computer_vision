package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
    public static String get(String format) {
        Date date = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(format);
        return DATE_FORMAT.format(date);
    }
}
