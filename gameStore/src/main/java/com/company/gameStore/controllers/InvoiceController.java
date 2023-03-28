package com.company.gameStore.controllers;

import com.company.gameStore.models.Invoice;
import com.company.gameStore.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceRepository invoiceRepository;

    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);

    }

    @GetMapping("/invoice/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoice(@PathVariable int id) {
        Optional<Invoice> returnVal = invoiceRepository.findById(id);

        return returnVal.orElse(null);
    }

    @GetMapping("/invoices")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @GetMapping("/invoice/customer/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceByCustomerName(@PathVariable String name) {
        return invoiceRepository.findByCustomerName(name);
    }

}
