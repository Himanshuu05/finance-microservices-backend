package com.himanshu.dashboard_service.controller;

import com.himanshu.dashboard_service.dto.RecordsDTO;
import com.himanshu.dashboard_service.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService service;

    @GetMapping("/summary")
    public Map<String, Double> getSummary(@RequestHeader("Role") String role) {
        return service.getSummary(role);
    }
    @GetMapping("/category")
    public Map<String, Double> category(@RequestHeader("Role") String role) {
        return service.categoryWise(role);
    }

    @GetMapping("/recent")
    public List<RecordsDTO> recent(@RequestHeader("Role") String role) {
        return service.recent(role);
    }

    @GetMapping("/monthly")
    public Map<String, Double> monthly(@RequestHeader("Role") String role) {
        return service.monthlyTrend(role);
    }
}
