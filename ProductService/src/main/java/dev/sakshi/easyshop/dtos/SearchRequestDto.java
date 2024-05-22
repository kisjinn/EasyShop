package dev.sakshi.easyshop.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchRequestDto {
    //for simple search
    private String query;
    private int pageNo;
    private int sizeOfPage;
    private List<SortParameter> sortBy;
}
