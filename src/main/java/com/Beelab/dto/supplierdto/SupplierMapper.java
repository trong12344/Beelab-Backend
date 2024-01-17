package com.Beelab.dto.supplierdto;

import com.Beelab.Entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface SupplierMapper {
    SupplierResponse toMapSupplierResponse( Supplier supplier);
    List<SupplierResponse> toMapListSupplierResponse(List<Supplier> supplier);
    void updateSupplier(@MappingTarget Supplier supplier , SupplierDto request);
}
