package com.Beelab.dto.productdto;

import com.Beelab.Common.IRequest;
import com.Beelab.Common.Paginated;
import com.Beelab.Common.PaginationRequest;
import lombok.*;
@Getter
@Setter
public class getAllProductDto extends PaginationRequest implements IRequest<Paginated<ProductDto>> {

}
