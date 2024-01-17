package com.Beelab.DAO;

import com.Beelab.Entity.Category;
import com.Beelab.Entity.ProductReport;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public interface ProductReportDAO extends JpaRepository<ProductReport, Long> {
    @Procedure(value = "Get_Product")
    List<ProductReport>getproduct();
}
