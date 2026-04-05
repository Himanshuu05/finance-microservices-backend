package com.himanshu.finance_service.controller;

import com.himanshu.finance_service.model.Records;
import com.himanshu.finance_service.model.Type;
import com.himanshu.finance_service.repository.RecordRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {
    @Autowired
    private RecordRepository repo;

    @PostMapping("/create")
    public Records create(@Valid @RequestBody Records record) {
        return repo.save(record);
    }

    @GetMapping
    public List<Records> getAll() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public Records update(@PathVariable Long id, @RequestBody Records record) {
        Records existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        existing.setAmount(record.getAmount());
        existing.setType(record.getType());
        existing.setCategory(record.getCategory());
        existing.setDate(record.getDate());
        existing.setDescription(record.getDescription());

        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted successfully";
    }

    @GetMapping("/filter")
    public List<Records> filter(
            @RequestParam(required = false) Type type,
            @RequestParam(required = false) String category) {

        if (type != null) return repo.findByType(type);
        if (category != null) return repo.findByCategory(category);

        return repo.findAll();
    }
}
