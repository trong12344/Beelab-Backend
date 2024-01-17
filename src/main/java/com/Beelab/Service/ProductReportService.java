package com.Beelab.Service;

import com.Beelab.DAO.ProductReportDAO;
import com.Beelab.Entity.ProductReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductReportService {
    List<ProductReport> getProducts();
  /*  public List<ProductReport> getTempTableData();*/
  double calculateTotalExpense(List<ProductReport> productList);
    double calculateTotalAmount(List<ProductReport> productList);

}
