package com.Beelab.dto.productdto;

import com.Beelab.Common.IRequest;
import com.Beelab.Common.Paginated;
import com.Beelab.Common.PaginationRequest;
import lombok.*;

@Getter
@Setter
@ToString
public class SearchProductDto extends PaginationRequest implements IRequest<Paginated<ProductDto>> {

        private int[] categoryIds;
        @Builder.Default
        private Integer minPrice = 0;
        @Builder.Default
        private Integer maxPrice = Integer.MAX_VALUE;
        private int[] colorIds;
        private String[] sizes;

    }


