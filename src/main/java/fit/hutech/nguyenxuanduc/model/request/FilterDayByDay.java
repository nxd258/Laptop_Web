package fit.hutech.nguyenxuanduc.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FilterDayByDay {
    private String toDate;
    private String fromDate;
}
