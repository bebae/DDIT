package kr.or.ddit.basic.logging;

import org.apache.log4j.Logger;

public class SimpleLog {
    // Logger 클래스의 인스턴스 구하기
    static Logger logger = Logger.getLogger(SimpleLog.class);

    public static void main(String[] args) {
        System.out.println("프로그램이 출력을 합니다.");

        // 로그 메시지는 Logger 객체를 이용하여 나타낸다.
        // 형식) Logger객체.로그레밸명("출력할 문자열");
        logger.trace("이것은 Log4j의 [TRACE]모드의 출력입니다...");
        logger.debug("이것은 Log4j의 [DEBUG]모드의 출력입니다...");
        logger.info("이것은 Log4j의 [INFO]모드의 출력입니다...");
        logger.warn("이것은 Log4j의 [WARN]모드의 출력입니다...");
        logger.error("이것은 Log4j의 [ERROR]모드의 출력입니다...");
        logger.fatal("이것은 Log4j의 [FATAL]모드의 출력입니다...");

    }
}
