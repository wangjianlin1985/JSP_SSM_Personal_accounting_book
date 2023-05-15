// 
// 
// 

package com.taoxiuxia.service;

import com.taoxiuxia.model.Item;
import java.util.List;

public interface IItemService
{
    List<Item> loadIncomeItems(int p0);
    
    List<Item> loadExpenditureItems(int p0);
    
    void addItem(int p0, String p1, String p2, String p3);
    
    void changeItem(int p0, String p1, String p2);
    
    void deleItem(int p0);
    
    String upAndDownItem(int p0, int p1, String p2, String p3);
}
