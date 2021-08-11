package com.testOTS.demo.demo.dao;

import com.testOTS.demo.demo.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
