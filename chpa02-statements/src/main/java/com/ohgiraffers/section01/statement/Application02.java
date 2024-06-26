package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Connection con = getConnection();
        // 쿼리문을 저장하고 실행하는 기능을 하는 용도의 인터페이스
        Statement stmt = null;
        // select 결과집합을 받아올 용도의 인터페이스
        ResultSet rset = null;
        String name = "선동일";

        System.out.print("검색할 회원의 번호를을 입력해주세요: ");
        int empId = scanner.nextInt();
        scanner.nextLine();

        try {
            // sql에 말하는 방식을 만들어줌.
            // sql은 sql 문법을 이용해 말함.
            stmt = con.createStatement();

            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = " + empId);
            while (rset.next()) {
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(stmt);
            close(rset);
        }
    }
}
