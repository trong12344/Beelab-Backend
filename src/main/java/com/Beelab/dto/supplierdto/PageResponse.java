package com.Beelab.dto.supplierdto;

import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {
    private int totalPages;
    private int pageSize;
    private long totalElements;
    @Builder.Default
    private List<T> data = Collections.emptyList();
}
