package com.Beelab.API;

import com.Beelab.Entity.ChiPhi;
import com.Beelab.Entity.DoanhThu;

import com.Beelab.Entity.LoiNhuan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class ChiPhiAPI {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/chiphi")
    public ResponseEntity<ChiPhi> getChiPhi() {
        try {
            // Gọi stored procedure và lấy kết quả từ ResultSet
            BigDecimal totalAmount = jdbcTemplate.queryForObject(
                    "CALL getChiPhi()", BigDecimal.class);
            // Tạo đối tượng ChiPhi từ kết quả và trả về trong ResponseEntity
            ChiPhi chiPhi = new ChiPhi(totalAmount);
            return new ResponseEntity<>(chiPhi, HttpStatus.OK);
        } catch (Exception ex) {
            // Xử lý các trường hợp ngoại lệ
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/doanhthu")
    public ResponseEntity<DoanhThu> getDoanhThu1() {
        try {
            // Gọi stored procedure và lấy kết quả từ ResultSet
            BigDecimal totalAmount = jdbcTemplate.queryForObject(
                    "CALL getDoanhThu1()", BigDecimal.class);
            // Tạo đối tượng DoanhThu từ kết quả và trả về trong ResponseEntity
            DoanhThu doanhThu = new DoanhThu(totalAmount);
            return new ResponseEntity<>(doanhThu, HttpStatus.OK);
        } catch (Exception ex) {
            // Xử lý các trường hợp ngoại lệ
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/loinhuan")
    public ResponseEntity<LoiNhuan> getLoiNhuan() {
        try {
            // Gọi stored procedures để lấy tổng chi phí và tổng doanh thu
            BigDecimal chiPhi = jdbcTemplate.queryForObject("CALL getChiPhi()", BigDecimal.class);
            BigDecimal doanhThu = jdbcTemplate.queryForObject("CALL getDoanhThu1()", BigDecimal.class);

            // Tính lợi nhuận
            BigDecimal loiNhuan = doanhThu.subtract(chiPhi);

            // Tạo đối tượng LoiNhuan từ kết quả và trả về trong ResponseEntity
            LoiNhuan loiNhuanObj = new LoiNhuan(loiNhuan);
            return new ResponseEntity<>(loiNhuanObj, HttpStatus.OK);
        } catch (Exception ex) {
            // Xử lý các trường hợp ngoại lệ
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

