
package com.rest.services;

import java.util.List;

import com.rest.models.Bill;
import com.rest.repo.BillRepo;

public class BillService {

    private BillRepo billRepo;

    
    public BillService() {
        this.billRepo = new BillRepo();
    }

  
    public String addBill(Bill bill) {
        if (bill == null) {
            return "Invalid bill";
        }

        if (bill.getId() <= 0) {
            return "Invalid bill ID";
        }

        if (bill.getCustName() == null ||
                bill.getCustName().trim().isEmpty()) {
            return "Customer name cannot be empty";
        }

        if (bill.getTotalPrice() < 0) {
            return "Total price cannot be negative";
        }

        return billRepo.addBill(bill);
    }

   
    public List<Bill> getAllBills() {
        return billRepo.getAllBills();
    }

    public Bill getBillById(int id) {
        if (id <= 0) {
            return null;
        }

        return billRepo.getBillById(id);
    }

   
    public String removeBill(int id) {
        if (id <= 0) {
            return "Invalid bill ID";
        }

        return billRepo.removeBill(id);
    }
}
