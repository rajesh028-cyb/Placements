package com.rest.repo;
import java.util.ArrayList;
import java.util.List;

import com.rest.models.table;

public class TableRepo {
    private final List<table> tables = new ArrayList<>();
     public TableRepo(){
      tables.add(new table(1,5));
      tables.add(new table(2,2));
      tables.add(new table(3,7));
     }
     public List<table> getTables(){
        return tables;
     }
     public boolean addTable(table t){
        return tables.add(t);
     }
     public boolean removeTable(table t){
        return tables.remove(t);
     }
   
     
}
