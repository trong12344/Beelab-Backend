package com.Beelab.API;

import com.Beelab.DAO.ProductReportDAO;
import com.Beelab.Entity.ProductReport;
import com.Beelab.Entity.Supplier;
import com.Beelab.Service.ProductReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ProductReportAPI {


    @Autowired
    private ProductReportService productReportService;
    @GetMapping
    @Secured("PRODUCT_MANAGEMENT")
    public ResponseEntity<Map<String,Object>> getProductReports() {
        List<ProductReport> productReports = productReportService.getProducts();
        double totalExpense = productReportService.calculateTotalExpense(productReports);
        double totalAmount = productReportService.calculateTotalAmount(productReports);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("productReports", productReports);
        response.put("totalExpense", totalExpense);
        response.put("totalAmount", totalAmount);
        if (!productReports.isEmpty()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
