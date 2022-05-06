package dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@AllArgsConstructor << don't add this.. won't work with 1:1 or 1:M injections (association or collection)
public class EmpDTO {
    private int empNo;
    private String eName;
    private String job;
    private int mgr;
    private String hireDate;
    private int sal;
    private int comm;
    private int deptNo;

    //1:1 relationship (association)
    private DeptDTO deptDTO;
    private SalGradeDTO salGradeDTO;

}
