package com.rest.repo;
import java.util.ArrayList;
import java.util.List;
import com.rest.models.menu;
public class MenuRepo {
private final List<menu> menus = new ArrayList<>();
     public MenuRepo(){
      menus.add(new menu(1,"Pizza",250,menu.Type.FOOD));
      menus.add(new menu(2,"Coke",50,menu.Type.DRINK));
      menus.add(new menu(3,"Ice Cream",100,menu.Type.DESSERT));
      menus.add(new menu(4,"Salad",150,menu.Type.STARTERS));
     }
     public List<menu> getMenus(){
        return menus;
     }
     public boolean addMenu(menu m){
        return menus.add(m);
     }
    public boolean removeMenu(menu m){
            return menus.remove(m);
        }
    public menu getMenuById(int id) {
        for (menu m : menus) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null; 
    }
    
}
