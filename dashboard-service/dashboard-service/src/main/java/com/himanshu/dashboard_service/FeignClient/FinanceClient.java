package com.himanshu.dashboard_service.FeignClient;

import com.himanshu.dashboard_service.dto.RecordsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name="finance-service")
public interface FinanceClient {
    @GetMapping("/records")
    List<RecordsDTO> getAllRecords(@RequestHeader("Role") String role);
}
