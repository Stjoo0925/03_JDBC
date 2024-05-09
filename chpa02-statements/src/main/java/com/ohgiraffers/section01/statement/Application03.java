package com.ohgiraffers.section01.statement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import static com.ohgiraffers.common.JDBCTemplate.*;

import java.sql.*;
import java.util.Scanner;

public class Application03 {

    public static void main(String[] args) {
        Connection con =  getConnection();

        Statement stmt = null;
        ResultSet rset = null;

        Scanner scanner = new Scanner(System.in);
        System.out.print("조회할 사번을 입력해주세요: ");
        int empId = scanner.nextInt();
        scanner.nextLine();

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = " + empId;
        EmployeeDTO employeeDTO = null;
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if (rset.next()) {
                employeeDTO = new EmployeeDTO();
                employeeDTO.setEmpId(rset.getString("EMP_ID"));
                employeeDTO.setEmpName(rset.getString("EMP_NAME"));
                employeeDTO.setEmpNo(rset.getString("EMP_NO"));
                employeeDTO.setEmail(rset.getString("EMAIL"));
                employeeDTO.setPhone(rset.getString("PHONE"));
                employeeDTO.setDeptCode(rset.getString("DEPT_CODE"));
                employeeDTO.setJobCode(rset.getString("JOB_CODE"));
                employeeDTO.setSalLevel(rset.getString("SAL_LEVEL"));
                employeeDTO.setSal(rset.getInt("SALARY"));
                employeeDTO.setBouns(rset.getInt("BONUS"));
                employeeDTO.setManagerId(rset.getString("MANAGER_ID"));
                employeeDTO.setHireDate(rset.getDate("HIRE_DATE"));
                employeeDTO.setEntDate(rset.getDate("ENT_DATE"));
                employeeDTO.setEntYn(rset.getString("ENT_YN"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }

        System.out.println("select emp = " + employeeDTO);
    }
}
