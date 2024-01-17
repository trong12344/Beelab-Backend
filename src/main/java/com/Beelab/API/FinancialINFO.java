package com.Beelab.API;

import com.Beelab.Entity.FinancialInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class FinancialINFO {
    /// NHỚ ĐỌC COMMENT ĐỂ TẠO PROCEDURE NHA
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/financial-info")
    @Secured("REPORT_MANAGEMENT")
    public ResponseEntity<FinancialInfo> getFinancialInfo() {
        try {
            BigDecimal doanhThu = jdbcTemplate.queryForObject("CALL getDoanhThu1()", BigDecimal.class);
            BigDecimal chiPhi = jdbcTemplate.queryForObject("CALL getChiPhi()", BigDecimal.class);

            BigDecimal loiNhuan = doanhThu.subtract(chiPhi);

            FinancialInfo financialInfo = new FinancialInfo(doanhThu, chiPhi, loiNhuan);

            return new ResponseEntity<>(financialInfo, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // -- thêm trường total_amount & amount (double) dưới DB bảng order_detail_bill
    // - tạo procedure getChiPhi() :
    //    CREATE DEFINER=`root`@`localhost` PROCEDURE `getChiPhi`()
    //    BEGIN
    //    DECLARE total DECIMAL(18, 2);
    //
    //    SELECT SUM(total_amount) INTO total
    //    FROM product
    //    WHERE status = 1;
    //    SELECT total AS "CHI PHÍ CỦA BEELAB";
    //    END
    // - tạo procedure getDoanhThu1() :
    //    CREATE DEFINER=`root`@`localhost` PROCEDURE `getDoanhThu1`()
    //    BEGIN
    //    DECLARE TotalAmount DECIMAL(18, 2);
    //    SELECT SUM(total_amount) INTO TotalAmount
    //    FROM order_detail_bill
    //    WHERE status = 1
    //    SELECT TotalAmount AS 'Doanh thu của BEELAB';
    //    END





//    @GetMapping("/chiphi")
//    public ResponseEntity<ChiPhi> getChiPhi() {
//        try {
//            // Gọi stored procedure và lấy kết quả từ ResultSet
//            BigDecimal totalAmount = jdbcTemplate.queryForObject(
//                    "CALL getChiPhi()", BigDecimal.class);
//            // Tạo đối tượng ChiPhi từ kết quả và trả về trong ResponseEntity
//            ChiPhi chiPhi = new ChiPhi(totalAmount);
//            return new ResponseEntity<>(chiPhi, HttpStatus.OK);
//        } catch (Exception ex) {
//            // Xử lý các trường hợp ngoại lệ
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/doanhthu")
//    public ResponseEntity<DoanhThu> getDoanhThu1() {
//        try {
//            // Gọi stored procedure và lấy kết quả từ ResultSet
//            BigDecimal totalAmount = jdbcTemplate.queryForObject(
//                    "CALL getDoanhThu1()", BigDecimal.class);
//            // Tạo đối tượng DoanhThu từ kết quả và trả về trong ResponseEntity
//            DoanhThu doanhThu = new DoanhThu(totalAmount);
//            return new ResponseEntity<>(doanhThu, HttpStatus.OK);
//        } catch (Exception ex) {
//            // Xử lý các trường hợp ngoại lệ
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/loinhuan")
//    public ResponseEntity<LoiNhuan> getLoiNhuan() {
//        try {
//            // Gọi stored procedures để lấy tổng chi phí và tổng doanh thu
//            BigDecimal chiPhi = jdbcTemplate.queryForObject("CALL getChiPhi()", BigDecimal.class);
//            BigDecimal doanhThu = jdbcTemplate.queryForObject("CALL getDoanhThu1()", BigDecimal.class);
//
//            // Tính lợi nhuận
//            BigDecimal loiNhuan = doanhThu.subtract(chiPhi);
//
//            // Tạo đối tượng LoiNhuan từ kết quả và trả về trong ResponseEntity
//            LoiNhuan loiNhuanObj = new LoiNhuan(loiNhuan);
//            return new ResponseEntity<>(loiNhuanObj, HttpStatus.OK);
//        } catch (Exception ex) {
//            // Xử lý các trường hợp ngoại lệ
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}