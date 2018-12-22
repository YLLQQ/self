package self.yang.tools.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeUtil {

    private static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    private static final String YYYYMMDD = "yyyymmdd";

    /**
     * 返回当前时间yyyymmdd
     *
     * @return
     */
    public static String getYYYYMMDD() {
        return formatDate(YYYYMMDD);
    }

    /**
     * 返回当前时间yyyyMMddHHmmss
     *
     * @return
     */
    public static String getYYYYMMDDHHMMSS() {
        return formatDate(YYYYMMDDHHMMSS);
    }

    /**
     * 以yyyyMMddHHmmss输出当前时间
     *
     * @return
     */
    private static String formatDate(String format) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format, Locale.CHINA);

        return now.format(dateTimeFormatter);
    }
}
