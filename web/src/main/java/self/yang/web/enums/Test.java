package self.yang.web.enums;

import java.time.Clock;
import java.time.Instant;

/**
 * self.yang.web.enums.Test
 *
 * @author eleven
 * @date 2019/03/20
 */
public class Test {
    public static void main(String[] args) {
        long start = Instant.now(Clock.systemDefaultZone()).toEpochMilli();

        ResponseMessageEnum responseMessageEnumByCode = ResponseMessageEnum.getResponseMessageEnumByCode(1000);

        long end = Instant.now(Clock.systemDefaultZone()).toEpochMilli();

        printTimestamp(start, end, responseMessageEnumByCode);

        start = Instant.now(Clock.systemDefaultZone()).toEpochMilli();

        responseMessageEnumByCode = ResponseMessageEnum.getResponseMessageEnumByCode(200);

        end = Instant.now(Clock.systemDefaultZone()).toEpochMilli();

        printTimestamp(start, end, responseMessageEnumByCode);
    }

    /**
     * 打印时间戳
     *
     * @param start
     * @param end
     * @param responseMessageEnumByCode
     */
    private static void printTimestamp(long start, long end, ResponseMessageEnum responseMessageEnumByCode) {
        System.out.println(start);
        System.out.println(end);
        System.out.println(end - start);
        System.out.println(responseMessageEnumByCode);
    }
}
