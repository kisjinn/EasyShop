package dev.sakshi.easyshop.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SortParameter {
    private String parameterName;
    //asc means ascending, if desc means descending
    private String sortType;
}
