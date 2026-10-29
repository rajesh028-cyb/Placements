package com.rest.services;
import com.rest.models.menu;
import com.rest.repo.MenuRepo;
import java.util.List;

public class MenuService {
    private final MenuRepo repository;
    public MenuService(){
        repository=new MenuRepo();
    }
    public List<menu> getAll(){
        return repository.getMenus();
    }
    public String removeMenu(int id){
        if(id <=0 ){
            return "Invalid id";
        }
        for(menu m:repository.getMenus()){
            if(m.getId()==id){
                repository.removeMenu(m);
                return "Menu removed successfully";
            }
        }
        return "Menu not found";
    }
}
