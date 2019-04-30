package com.daojia.zzk.arithmetic.java8;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author zhangzk
 */
public class Java8Date {
    public static void main(String[] args){
        LocalDate now = LocalDate.now();
        System.out.println(now);

        int year = now.getYear();
        Month month = now.getMonth();
        int dayOfYear = now.getDayOfYear();
        System.out.println("year: {}" + year + ", month: " + month.getValue() + ", dayOgYear: " + dayOfYear);

        LocalDate of = LocalDate.of(2019, 4, 3);
        System.out.println(of);

        System.out.println("equals: " + now.equals(of));

        LocalTime localTime = LocalTime.now();
        System.out.println("localTime.." + localTime);

        // 一周后的日期
        LocalDate today = LocalDate.now();
        LocalDate plus = today.plus(1, ChronoUnit.WEEKS);
//        LocalDate localDate = today.plusWeeks(1);
        System.out.println("当前日期：" + today + "， 1周后日期： " + plus);

        //一年后的日期
//        today.plusYears(1);
        LocalDate yearPlus = today.plus(1, ChronoUnit.YEARS);
        System.out.println("当前日期：" + today + "， 1周后日期： " + yearPlus);

        // 用它来获取某个时区下当前的瞬时时间，日期或者时间,可以用Clock来替代System.currentTimeInMillis()与 TimeZone.getDefault() 方法。
        Clock clock = Clock.systemUTC();
        long currentTimeMillis = System.currentTimeMillis();
        Clock clock1 = Clock.systemDefaultZone();
        System.out.println("System.currentTimeMillis: " + currentTimeMillis + "clock systemUTC: " + clock.millis() + ", systemDefaultZone" + clock1);

        LocalDate tomorrow = LocalDate.of(2019, 4, 4);

        if (tomorrow.isAfter(today)) {
            System.out.println("tomorrow is after today");
        }

        // 处理不同的时区
        ZoneId america = ZoneId.of("America/New_York");
        ZonedDateTime americaTime = ZonedDateTime.of(LocalDateTime.now(), america);
        System.out.println(americaTime);

        // 如何表示固定的日期，比如信用卡过期时间
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);

        // 判断是否是闰年
        boolean leapYear = today.isLeapYear();
        System.out.println("now year： {}" + year + ", is leap year: {}" + leapYear);

        // 两个日期之间包含多少天，多少个月
        LocalDate day20190204 = LocalDate.of(2019, Month.FEBRUARY, 4);
        Period between = Period.between(day20190204, today);
        System.out.println("包含多少天 between: " + today + ", and day20190204 " + day20190204 + ", between: " + between.getDays() + ", month: " + between.getMonths());

        // 带时区偏移量的日期与时间
        LocalDateTime nowTime = LocalDateTime.of(2019, Month.FEBRUARY, 3, 17, 16, 30);
        ZoneOffset zoneOffset = ZoneOffset.of("+03:30");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(nowTime, zoneOffset);
        System.out.println("offsetDateTime " + offsetDateTime);

        // 在Java 8中如何获取当前时间戳
        Instant timestamp = Instant.now();
        System.out.println("Instant timestamp " + timestamp);

        // 如何在Java 8中使用预定义的格式器来对日期进行解析/格式化
        String dayPattarn = "20190408";
        LocalDate parse = LocalDate.parse(dayPattarn, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayPattarn, parse);

        // 如何在Java 8中对日期进行格式化，转换成字符串
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
        String format = nowTime.format(dateTimeFormatter);
        System.out.println("日期进行格式化 " + format);


    }
}
