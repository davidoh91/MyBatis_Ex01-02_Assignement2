package main;

import dao.DynamicJoinDAO;

public class DynamicJoinMain {
    public static void main(String[] args) {

        /*
        문제 1-1 / 1-2 :

            사원번호가 전달되면 사원번호에 해당하는
            "사원번호, 사원이름 , 부서명, 부서지역" 검색하고
            사원번호가 없으면 모든 사원의
            "사원번호, 사원이름 , 부서명, 부서지역" 검색 한다.

            1-1) 사원별 사원정보와 부서정보 (1 : 1)
            --동적쿼리 이용

            1-2) 각 부서별 사원이름검색 (1 : M)
            ((deptno,dname, loc, empno,ename)
         */

        //1-1
        System.out.println("1-1 : invoking DynamicJoinDAO.selectEmpAndDept(0)..\n");
        DynamicJoinDAO.selectEmpAndDept(0);
        System.out.println("1-1 : invoking DynamicJoinDAO.selectEmpAndDept(7369)..");
        DynamicJoinDAO.selectEmpAndDept(7369);

        //1-2
        System.out.println("1-2 : invoking DynamicJoinDAO.selectDeptAndEmp()..\n");
        DynamicJoinDAO.selectDeptAndEmp();


         /*
         문제 2-1 / 2-2 :

            사원번호, 사원이름,직업, 급여, 급여등급, losal, hisal검색

            SELECT e.empno, e.ename, e.job, e.sal, s.grade, s.losal, s.hisal
            FROM emp e JOIN salgrade s
            ON e.sal BETWEEN s.losal AND s.hisal


            2-1)  사원의 급여 등급 (1 : 1)
            emp <-> salgrade(1:1)

            2-2) 각 등급별 사원의 정보 검색(1 : M)
            salgrade <-> emp (1:M)
          */

        //2-1
        System.out.println("2-1 : invoking DynamicJoinDAO.selectEmpAndSalGrade()..");
        DynamicJoinDAO.selectEmpAndSalGrade();

        //2-2
        System.out.println("2-2 : invoking DynamicJoinDAO.selectSalGradeAndEmp()..");
        DynamicJoinDAO.selectSalGradeAndEmp();


    }
}
