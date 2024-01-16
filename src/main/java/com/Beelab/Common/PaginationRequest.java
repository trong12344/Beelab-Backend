package com.Beelab.Common;

import lombok.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginationRequest {

    protected int page = 1;
    protected int pageSize = 10;
    protected String sortField="";
    protected String sortDir="asc";
    @Builder.Default
    protected String keyword = "";

    public Sort.Direction getSortDirection() {
        return sortDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
    }

    public Pageable getPageable(String defaultSortField) {
        if (sortField.isEmpty()) {
            sortField = defaultSortField;
        }
        return org.springframework.data.domain.PageRequest.of(page - 1, pageSize, getSortDirection(), sortField);
    }
}
