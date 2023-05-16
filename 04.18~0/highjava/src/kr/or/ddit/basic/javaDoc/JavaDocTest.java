package kr.or.ddit.basic.javaDoc;

// JAVADOC 파일 만들기 예제 => 프로그램과 메뉴얼을 같이 만드는 방법

/**
 * @author 내이름
 * @version 1.0
 *
 * <p>
 *     파일명 : JavaDocTest.java<br>
 *     설  명 : JavaDoc 문서 작성을 위한 연습용 Interface<br><br>
 *
 *     변경 이력<br>
 *     ---------------------------<br>
 *     변경 날짜 : 2023-05-15<br>
 *     변경 인 : 아무개<br>
 *     변경 내용 : 최초 생성<br>
 *     ---------------------------<br>
 * </p>
 */
public interface JavaDocTest {
    /**
     * 메서드명 : methodTest1<br>
     * 설 명 : 반환값이 없는 메소드<br>
     *
     * @param a 매개변수(정수형) a에 대한 설명입니다
     * @param b 매개변수(정수형) b에 대한 설명입니다.
     */
    public void methodTest1(int a, int b);

    /**
     * 메서드명 : methodAdd<br>
     * 설 명 : 반환값이 있는 메소드<br>
     * @param a 정수형 첫번째 매개변수
     * @param b 정수형 두번째 매개변수
     * @return  처리된 결과를 정수형을 반환한다.
     */
    public int methodAdd(int a, int b);

    /**
     * 메서드명 : methodInput<br>
     * 설 명 : 매개변수가 없는 메소드<br>
     * @return 정수형으로 반환한다.
     */
    public int methodInput();

}
