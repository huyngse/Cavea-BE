package com.example.demo.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PageDtoV2 {
    private int code;
    private String message;
    //    private int page;
//    private int pageSize;
    private Integer totalPages;
    private int totalItems;
    private List<Object> list;
    private Object object;


}
