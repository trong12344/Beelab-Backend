package com.Beelab.Imp;

import com.Beelab.DAO.ProductReportDAO;
import com.Beelab.Entity.ProductReport;
import com.Beelab.Service.ProductReportService;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class ProductReportImpl implements ProductReportService {
    @Autowired
    private ProductReportDAO productReportDAO;
    @Override
    public List<ProductReport> getProducts() {
        return productReportDAO.getproduct();
    }
    @Override
    public double calculateTotalExpense(List<ProductReport> productList) {
        return productList.stream()
                .mapToDouble(ProductReport::getProductExpense)
                .sum();// tính toán tông giá tiền tất cả sản phẩm
    }
    @Override
    public double calculateTotalAmount(List<ProductReport> productList) {
        return productList.stream()
                .mapToDouble(ProductReport::getProductTotalAmount)
                .sum();// tính toán tổng giá tiền tất cả sản phẩm đã sold
    }

    }


 /*   @Override
    public List<ProductReport> getTempTableData() {
        return productReportDAO.getTempTableData();
    }*/

