
package com.rest.repo;

import java.util.ArrayList;
import java.util.List;
import com.rest.models.Bill;

public class BillRepo {

    private List<Bill> bills = new ArrayList<>();

   
    public String addBill(Bill bill) {
        bills.add(bill);
        return "Bill added successfully";
    }

    public List<Bill> getAllBills() {
        return bills;
    }

    
    public Bill getBillById(int id) {
        for (Bill bill : bills) {
            if (bill.getId() == id) {
                return bill;
            }
        }
        return null;
    }

   
    public String removeBill(int id) {
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getId() == id) {
                bills.remove(i);
                return "Bill removed successfully";
            }
        }
        return "Bill not found";
    }
}
