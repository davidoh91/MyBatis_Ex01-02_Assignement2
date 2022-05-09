package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
//@AllArgsConstructor << don't add this.. won't work with 1:1 or 1:M injections (association or collection)
@ToString(exclude={"empDTOList"})
public class SalGradeDTO {
    private int grade;
    private int loSal;
    private int hiSal;

    //1:M relationship (collection)
    private List<EmpDTO> empDTOList;
}
