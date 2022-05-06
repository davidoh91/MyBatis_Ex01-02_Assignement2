package dao;

import dto.DeptDTO;
import dto.EmpDTO;
import dto.SalGradeDTO;
import org.apache.ibatis.session.SqlSession;
import util.DbUtil;

import java.util.List;

public class DynamicJoinDAO {

    public static void selectEmpAndDept(int empNo) {
        SqlSession session = null;

        try {
            session = DbUtil.getSession();
            List<EmpDTO> list = session.selectList("joinMapper.selectEmpAndDept", empNo);

            System.out.println("empno" + " | " + "ename" + " | " + "job" + " | " + "sal" + " | "
                + "deptno"  + " | " + "dname" + " | " + "loc");
            for(EmpDTO e : list) {
                System.out.print(e.getEmpNo() + " | ");
                System.out.print( e.getEName() + " | ");
                System.out.print( e.getJob() + " | ");
                System.out.print( e.getSal() + " | ");

                System.out.print( e.getDeptDTO().getDeptNo() + " | ");
                System.out.print( e.getDeptDTO().getDName() + " | ");
                System.out.print( e.getDeptDTO().getLoc());
                System.out.println("\n-----------------------------------");
            }
            System.out.println("=====================================");
        }finally {
            DbUtil.sessionClose(session);
        }
    }


    public static void selectDeptAndEmp() {
        SqlSession session = null;

        try{
            session = DbUtil.getSession();
            List<DeptDTO> list = session.selectList("joinMapper.selectDeptAndEmp");

            for(DeptDTO d : list) {
                System.out.println("----------------DEPT---------------");
                System.out.print( d.getDeptNo() + " | ");
                System.out.print( d.getDName() + " | ");
                System.out.print( d.getLoc() + " | ");
                System.out.println("\n----------------DEPT---------------");

                for(EmpDTO e : d.getEmpDTOList() ) {
                    System.out.println("\n       ---------EMP---------       ");
                    System.out.print( e.getEmpNo() + " | ");
                    System.out.print( e.getEName() + " | ");
                    System.out.print( e.getJob() + " | ");
                    System.out.print( e.getSal() + " | ");
                }
                System.out.println("\n=====================================");
            }
        }finally {
            DbUtil.sessionClose(session);
        }
    }


    public static void selectEmpAndSalGrade() {
        SqlSession session = null;

        try {
            session = DbUtil.getSession();
            List<EmpDTO> list = session.selectList("joinMapper.selectEmpAndSalGrade");

            System.out.println("empno" + " | " + "ename" + " | " + "job" + " | " + "sal" + " | "
                    + "grade"  + " | " + "losal" + " | " + "hisal");
            for(EmpDTO e : list) {
                System.out.print(e.getEmpNo() + " | ");
                System.out.print(e.getEName() + " | ");
                System.out.print(e.getJob() + " | ");
                System.out.print(e.getSal() + " | ");

                System.out.print(e.getSalGradeDTO().getGrade() + " | ");
                System.out.print(e.getSalGradeDTO().getLoSal() + " | ");
                System.out.print(e.getSalGradeDTO().getHiSal() + " | ");
                System.out.println("\n-----------------------------------");
            }
            System.out.println("\n=====================================");
        }finally {
            DbUtil.sessionClose(session);
        }
    }


    public static void selectSalGradeAndEmp() {
        SqlSession session = null;

        try {
            session = DbUtil.getSession();
            List<SalGradeDTO> list = session.selectList("joinMapper.selectSalGradeAndEmp");

            for(SalGradeDTO s : list) {
                System.out.println("----------------SalGrade---------------");
                System.out.println("grade"  + " | " + "losal" + " | " + "hisal");
                System.out.print(s.getGrade() + " | ");
                System.out.print(s.getLoSal() + " | ");
                System.out.print(s.getHiSal() + " | ");
                System.out.println("\n----------------SalGrade---------------");

                for(EmpDTO e : s.getEmpDTOList()) {
                    System.out.println("        ---------EMP---------       ");
                    System.out.println("empno" + " | " + "ename" + " | " + "job" + " | " + "sal");
                    System.out.print(e.getEmpNo() + " | ");
                    System.out.print(e.getEName() + " | ");
                    System.out.print(e.getJob() + " | ");
                    System.out.print(e.getSal() + " | ");
                    System.out.println("\n-----------------------------------");
                }
            }
            System.out.println("\n=====================================");
        }finally {
            DbUtil.sessionClose(session);
        }
    }
}
