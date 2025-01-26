package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

    private List<CategoryDTO> content;
    private long pageNumber;
    private long pageSize;
    private long totalElements;
    private long totalPages;
    private boolean lastPage;
}
