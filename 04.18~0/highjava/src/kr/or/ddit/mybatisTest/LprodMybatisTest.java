package kr.or.ddit.mybatisTest;

import kr.or.ddit.mybatisTest.vo.LprodVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class LprodMybatisTest {
    // myBatis를 이용하여 DB 자료를 처리하는 순서 및 방법
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 1. myBatis의 환경설정파일(mybatis-config.xml)을 읽어와서 실행
        InputStream in = null;
        SqlSessionFactory factory = null;
        try {
            // 1-1. 환경설정 파일을 읽어 올 스트림 객체 생성
            in = Resources.getResourceAsStream("kr/or/ddit/config/mybatis-config.xml");

            // 1-2. 환경설정 파일을 읽어와 환경 설정을 완성한 후 SQL문을 호출해서 실행할 수 있는 객체를 생성할 수 있는 SQLSessionFactory 객체를 생성한다.
            factory = new SqlSessionFactoryBuilder().build(in);

        } catch (Exception e) {
            System.out.println("myBatis 초기화 실패");
            e.printStackTrace();
        } finally {
            if (in != null) try {
                in.close();
            } catch (Exception e) {
            }
        }
        //-----------------------------------------------------

        // 2. mapper에 등록된 SQL문들 중 실행할 SQL문을 호출해서 원하는 작업을 수행한다.

        // 2-1. insert 연습
//        System.out.println("insert 작업 시작...");
//        System.out.print("Lprod_id 입력 : ");
//        int lprod_id = scan.nextInt();
//        System.out.print("Lprod_gu  입력  : ");
//        String lprod_gu = scan.next();
//        System.out.print("Lprod_nm  입력  : ");
//        String lprod_nm = scan.next();
//
//        // 입력한 데이트를 Vo 객체에 저장
//        LprodVO lvo1 = new LprodVO();
//        lvo1.setLprod_id(lprod_id);
//        lvo1.setLprod_gu(lprod_gu);
//        lvo1.setLprod_nm(lprod_nm);
//
//        SqlSession session = null;  // SqlSession 객체 변수 선언
//        try {
//            /* SqlSessionFactory 객체를 이용하여 SqlSession 객체를 구한다.
//             * 형식 ) SqlSessionFactory 객체.openSession(논리값)
//             *      '논리값'이 true이면 AutoCommit이 활성화된 상태이고
//             *      '논리값'이 생략되거나 false이면 AutoCommit이 비활성화된 상태이다.
//             */
//            session = factory.openSession(true);
//
//            /* SqlSession 객체를 이용하여 처리할 SQL 문을 호출하여 실행한다.
//             * 형식) SqlSession객체.insert("namespace속성값.id속성값", 파라미터클래스)
//             *          반환값 : 작업에 성공한 레코드 수</unk>
//             */
//            int cnt = session.insert("lprod.insertLprod1", lvo1);
//
//            if (cnt > 0) {
//                System.out.println("insert 가  작업 성공");
//            } else {
//                System.out.println("insert 가  작업 실패");
//            }
//
//        } finally {
//          if (session != null) { session.close(); }
//        }
//        // 2-2. update 연습
//        System.out.println("update 작업 시작...");
//        System.out.print("수정할 Lprod_gu 입력 : ");
//        String lprod_gu2 = scan.next();
//        System.out.print("새로운 Lprod_id 입력 : ");
//        int lprod_id2 = scan.nextInt();
//        System.out.print("새로운 Lprod_nm 입력 : ");
//        String lprod_nm2 = scan.next();
//
//        // 입력한 데이트를 Vo 객체에 저장
//        LprodVO lvo2 = new LprodVO();
//        lvo2.setLprod_gu(lprod_gu2);
//        lvo2.setLprod_id(lprod_id2);
//        lvo2.setLprod_nm(lprod_nm2);
//
//        SqlSession session = null;
//        try {
//            session = factory.openSession(true);    // SqlSession 객체 변수 선언
//
//            /* SqlSessionFactory 객체를 이용하여 SqlSession 객체를 구한다.
//             * 형식 ) SqlSessionFactory 객체.update("namespace속성값.id속성값",파라미터클래스)
//             *      반환값 : 작업에 성공한 레코드 수
//             */
//            int cnt = session.update("lprod.updateLprod", lvo2);
//
//            if (cnt > 0) {
//                System.out.println("update 성공!");
//            } else {
//                System.out.println("update 실패 ㅠㅠ");
//            }
//        } finally {
//            if (session != null) { session.close(); }
//        }
//
//        //-----------------------------------------------------
//        // 2-3. delete
//        System.out.println("delete 작업 시작...");
//
//        System.out.print("삭제할 Lprod_gu 입력 : ");
//        String lprod_gu3 = scan.next();
//
//        SqlSession session = null;
//        try {
//            session = factory.openSession();
//            /* SqlSession객체의 delete()메소드를 이용해서 삭제한다.
//             * 형식) SqlSessio객체.delete("namespace속성값.id속성값", 파라미터클래스)
//             *      반환값 : 작업에 성공한 레코드 수
//             */
//            int cnt = session.delete("lprod.deleteLprod", lprod_gu3);
//            if (cnt > 0) {
//                System.out.println("delete 성공!");
//            } else {
//                System.out.println("delete 실패  ㅠㅠ");
//            }
//        } finally {
//            if (session != null) { session.close(); }
//        }
//        //-----------------------------------------------------
//        // 2-4. select 연습
//
//        // 1) 응답 결과가 여러개인 경우
//         SqlSession session = null;
//        try {
//            session = factory.openSession();
//
//            /* 응답 결과가 여러 개일 경우 selectList()메소드를 사용하는데 이 메소드는
//             * 여러개의 레코드 각각을 VO객체에 담은 후 List에 추가해 주는 작업을 자동으로 수행한다.
//             * 형식) SqlSessio객체.selectList("namespace속성값.id속성값", 파라미터클래스)
//             */
//            List<LprodVO> list = session.selectList("lprod.getAllLprod");
//
//            for (LprodVO vo : list) {
//                System.out.println(
//                        "ID : "+vo.getLprod_id() +
//                        "GU : "+vo.getLprod_gu() +
//                        "NM : "+vo.getLprod_nm()
//                );
//                System.out.println("=================================");
//            }
//        } finally {
//            if (session != null) { session.close(); }
//        }
        //-----------------------------------------------------
        // 2) 응답결과가 1개인 경우
        System.out.println("select 작업 -- 응답 결과가 1개인 경우...");
        System.out.print("검색할 Lprod_gu 입력 : ");
        String lprod_gu4 = scan.next();

        SqlSession session = null;
        try {
            session = factory.openSession();

            /*  응답 결과가 1개일 경우에는 selectOne() 메소드를 사용한다.
             * 형식) SqlSession객체.selectOne("namespace속성값.id속성값", 파라미터클래스)
             *          반환값 : resultType 속성에 지정된 데이터가 반환된다. 없다면 Null
             */

            LprodVO lvo5 = session.selectOne("lprod.getLprod", lprod_gu4);

            if (lvo5 == null) {
                System.out.println("검색한 데이터가 하나도 없습니다.  ㅠㅠ");
            } else {
                System.out.println("ID : "+lvo5.getLprod_id());
                System.out.println("GU : "+lvo5.getLprod_gu());
                System.out.println("NM : "+lvo5.getLprod_nm());
                System.out.println("=================================");
            }
        } finally {
            if (session != null) { session.close(); }
        }

    }
}
