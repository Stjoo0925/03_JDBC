package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application01 {

    public static void main(String[] args) {

        Connection con = getConnection();
        // 쿼리문을 저장하고 실행하는 기능을 하는 용도의 인터페이스
        Statement stmt = null;
        // select 결과집합을 받아올 용도의 인터페이스
        ResultSet rset = null;
    }
}