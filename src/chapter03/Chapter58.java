package chapter03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

// 문자열을 날짜와 시간으로 변환
public class Chapter58 {
    public static void main(String[] args) {

        // 각각의 정의된 패턴에 맞춰 parse할 수 있다.
        final LocalDate localDate = LocalDate.parse("2023-08-01");                          // DateTimeFormatter.ISO_LOCAL_DATE
        final LocalDateTime localDateTime = LocalDateTime.parse("2023-11-23T22:20:15");     // DateTimeFormatter.ISO_LOCAL_DATE_TIME
        final ZonedDateTime zonedDateTime = ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]"); // DateTimeFormatter.ISO_ZONED_DATE_TIME
        final OffsetDateTime offsetDateTime = OffsetDateTime.parse("2007-12-03T10:15:30+01:00");            // DateTimeFormatter.ISO_OFFSET_DATE_TIME

        // 다른 포메터를 사용하고 싶다면 아래와 같이 정의한다.
        final LocalDate localDateFormat = LocalDate.parse("2023.01.01 10:10", DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
        final LocalDateTime localDateTimeFormat = LocalDateTime.parse("2023-05-05 10:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        // 데이터 -> 문자열
        final String LocalDateString = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
    }

}
