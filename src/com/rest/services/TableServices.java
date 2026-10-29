package com.rest.services;
import java.util.List;

import com.rest.models.table;
import com.rest.repo.TableRepo;


public class TableServices {
    private final TableRepo repository;
    public TableServices(){
        repository=new TableRepo();
    }
    public List<table> getAll(){
        return repository.getTables();
    }
    public String removeTable(int id){
        if(id <=0 ){
            return "Invalid id";
        }
        for(table t:repository.getTables()){
            if(t.getId()==id){
                repository.removeTable(t);
                return "Table removed successfully";
            }
        }
        return "Table not found";
    }


}
