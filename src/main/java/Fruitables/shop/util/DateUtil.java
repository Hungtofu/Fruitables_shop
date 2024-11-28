package Fruitables.shop.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static Instant parseTimestamp(String timestamp) {
        try {
            return Instant.parse(timestamp); // ISO-8601 hợp lệ
        } catch (Exception e) {
            // Chuyển đổi nếu thiếu "Z"
            LocalDateTime localDateTime = LocalDateTime.parse(timestamp, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        }
    }
}
