package com.himanshu.dashboard_service.service;

import com.himanshu.dashboard_service.FeignClient.FinanceClient;
import com.himanshu.dashboard_service.dto.RecordsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DashboardService {
    @Autowired
    private FinanceClient financeClient;

    public Map<String, Double> getSummary(String role) {

        List<RecordsDTO> records = financeClient.getAllRecords(role);

        double income = 0;
        double expense = 0;

        for (RecordsDTO r : records) {
            if ("INCOME".equalsIgnoreCase(r.getType())) income += r.getAmount();
            else expense += r.getAmount();
        }

        Map<String, Double> map = new HashMap<>();
        map.put("income", income);
        map.put("expense", expense);
        map.put("balance", income - expense);

        return map;
    }

    public Map<String, Double> categoryWise(String role) {

        List<RecordsDTO> records = financeClient.getAllRecords(role);

        Map<String, Double> map = new HashMap<>();

        if (records != null) {
            for (RecordsDTO r : records) {

                if (r == null || r.getCategory() == null) continue;

                map.put(
                        r.getCategory(),
                        map.getOrDefault(r.getCategory(), 0.0) + r.getAmount()
                );
            }
        }

        return map;
    }
    public List<RecordsDTO> recent(String role) {

        List<RecordsDTO> records = financeClient.getAllRecords(role);

        if (records == null) return new ArrayList<>();

        return records.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(
                        RecordsDTO::getDate,
                        Comparator.nullsLast(Comparator.reverseOrder())
                ))
                .limit(5)
                .toList();
    }
    public Map<String, Double> monthlyTrend(String role) {

        List<RecordsDTO> records = financeClient.getAllRecords(role);

        Map<String, Double> map = new HashMap<>();

        if (records != null) {
            for (RecordsDTO r : records) {

                if (r == null || r.getDate() == null) continue;

                String month = r.getDate().getMonth().toString();

                map.put(
                        month,
                        map.getOrDefault(month, 0.0) + r.getAmount()
                );
            }
        }

        return map;
    }
}
