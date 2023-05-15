// 
// 
// 

package com.taoxiuxia.service.impl;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.taoxiuxia.model.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.taoxiuxia.mapper.ItemMapper;
import org.springframework.stereotype.Service;
import com.taoxiuxia.service.IItemService;

@Service("itemService")
public class ItemServiceImpl implements IItemService
{
    private ItemMapper itemMapper;
    
    public ItemMapper getItemMapper() {
        return this.itemMapper;
    }
    
    @Autowired
    public void setItemMapper(final ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }
    
    @Override
    public List<Item> loadIncomeItems(final int id) {
        return this.itemMapper.selectIncomeItemByUserId(id);
    }
    
    @Override
    public List<Item> loadExpenditureItems(final int id) {
        return this.itemMapper.selectExpenditureItemByUserId(id);
    }
    
    @Override
    public void addItem(final int userId, final String itemName, final String remark, final String inOrEx) {
        final Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("userId", userId);
        parameterMap.put("itemName", itemName);
        parameterMap.put("inOrEx", inOrEx);
        parameterMap.put("remark", remark);
        parameterMap.put("dele", 1);
        this.itemMapper.insert(parameterMap);
    }
    
    @Override
    public void changeItem(final int itemId, final String itemName, final String remark) {
        final Item item = new Item();
        item.setId(itemId);
        item.setName(itemName);
        item.setRemark(remark);
        this.itemMapper.updateByPrimaryKeySelective(item);
    }
    
    @Override
    public void deleItem(final int itemId) {
        final Item item = new Item();
        item.setId(itemId);
        item.setDele(-1);
        this.itemMapper.updateByPrimaryKeySelective(item);
    }
    
    @Override
    public String upAndDownItem(final int userId, final int itemId, final String inOrEx, final String upAndDown) {
        List<Item> itemList = new ArrayList<Item>();
        if ("ex".equals(inOrEx)) {
            itemList = this.loadExpenditureItems(userId);
        }
        else {
            if (!"in".equals(inOrEx)) {
                return "\u8f93\u5165\u53c2\u6570\u4e0d\u5408\u6cd5";
            }
            itemList = this.loadIncomeItems(userId);
        }
        final int listSize = itemList.size();
        final int[] itemIdArray = new int[listSize];
        final int[] sortArray = new int[listSize];
        for (int i = 0; i < listSize; ++i) {
            itemIdArray[i] = itemList.get(i).getId();
            sortArray[i] = itemList.get(i).getSort();
        }
        int curI = 0;
        for (int j = 0; j < listSize; ++j) {
            if (itemId == itemIdArray[j]) {
                curI = j;
                break;
            }
        }
        if (curI == 0 && "up".equals(upAndDown)) {
            return "\u5df2\u7ecf\u662f\u7b2c\u4e00\u4e2a\u4e86\uff0c\u65e0\u6cd5\u4e0a\u79fb";
        }
        if (curI == listSize - 1 && "down".equals(upAndDown)) {
            return "\u5df2\u7ecf\u662f\u6700\u540e\u4e00\u4e2a\u4e86\uff0c\u65e0\u6cd5\u4e0b\u79fb";
        }
        if ("up".equals(upAndDown)) {
            this.exchange(userId, itemIdArray[curI], sortArray[curI], itemIdArray[curI - 1], sortArray[curI - 1]);
            return "\u4e0a\u79fb\u6210\u529f";
        }
        if ("down".equals(upAndDown)) {
            this.exchange(userId, itemIdArray[curI], sortArray[curI], itemIdArray[curI + 1], sortArray[curI + 1]);
            return "\u4e0b\u79fb\u6210\u529f";
        }
        return "\u4e0a\u79fb\u6216\u4e0b\u79fb\u5931\u8d25";
    }
    
    public void exchange(final int userId, final int itemId1, final int sort1, final int itemId2, final int sort2) {
        final Item item = new Item();
        item.setId(itemId1);
        item.setSort(sort2);
        this.itemMapper.updateByPrimaryKeySelective(item);
        item.setId(itemId2);
        item.setSort(sort1);
        this.itemMapper.updateByPrimaryKeySelective(item);
    }
}
