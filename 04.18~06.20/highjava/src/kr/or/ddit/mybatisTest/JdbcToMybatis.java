package kr.or.ddit.mybatisTest;

import kr.or.ddit.mybatisTest.TestVo.LprodVO;
import kr.or.ddit.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

public class JdbcToMybatis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        // 1. myBatis의 환경설정파일(mybatis-config.xml)을 읽어와서 실행
//        InputStream in = null;
//        SqlSessionFactory factory = null;
//        try {
//            // 1-1. 환경설정 파일을 읽어 올 스트림 객체 생성
//            in = Resources.getResourceAsStream("kr/or/ddit/config/mybatis-config.xml");
//
//            // 1-2. 환경설정 파일을 읽어와 환경 설정을 완성한 후 SQL문을 호출해서 실행할 수 있는 객체를 생성할 수 있는 SQLSessionFactory 객체를 생성한다.
//            factory = new SqlSessionFactoryBuilder().build(in);
//
//        } catch (Exception e) {
//            System.out.println("myBatis 초기화 실패");
//            e.printStackTrace();
//        } finally {
//            if (in != null) try {
//                in.close();
//            } catch (Exception ignored) {
//            }
//        }

        // 1) Lprod_id 중 MAX 값을 찾아 +1 해서 변수에 저장 만약 MAX값이 없다면 0
        System.out.println("ID MAX select 작업 중...");

        SqlSession session = null;
        int maxNum = 0;
        String lprod_gu = "";
        boolean isDuplicate = true;
        String lprod_nm = "";
        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            /*  응답 결과가 1개일 경우에는 selectOne() 메소드를 사용한다.
             * 형식) SqlSession객체.selectOne("namespace속성값.id속성값", 파라미터클래스)
             *          반환값 : resultType 속성에 지정된 데이터가 반환된다. 없다면 Null
             */
            LprodVO lvo1 = session.selectOne("jdbc.getMaxId");

            if (lvo1 == null) {
                System.out.println("검색한 데이터가 하나도 없습니다.  ㅠㅠ");
            } else {
                maxNum = lvo1.getLprod_id();
                System.out.println("ID : " + maxNum);
            }

            while (isDuplicate) {
                System.out.print("lprod_gu 값 입력하세요(P101~) : ");
                lprod_gu = scan.nextLine();

                LprodVO lvo2 = session.selectOne("jdbc.getLprod", lprod_gu);

                if (lvo2 == null) {
                    isDuplicate = false;
                } else {
                    System.out.println("이미 존재하는 lprod_gu 입니다. 다시 입력하세요.");
                }
            }

            System.out.print("lprod_nm 값 입력하세요(컴퓨터제품, 화장품...) : ");
            lprod_nm = scan.nextLine();

            LprodVO lvo3 = new LprodVO();
            lvo3.setLprod_id(++maxNum);
            lvo3.setLprod_gu(lprod_gu);
            lvo3.setLprod_nm(lprod_nm);
            int cnt = session.insert("jdbc.insertLprod", lvo3);
            if (cnt > 0) {
                System.out.println("insert 가  작업 성공");
                session.commit();
            } else {
                System.out.println("insert 가  작업 실패");
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}