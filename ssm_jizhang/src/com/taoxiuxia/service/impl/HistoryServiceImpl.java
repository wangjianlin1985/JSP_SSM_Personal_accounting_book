// 
// 
// 

package com.taoxiuxia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Arrays;
import com.taoxiuxia.util.NumberFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import com.taoxiuxia.mapper.ExpenditureMapper;
import com.taoxiuxia.mapper.IncomeMapper;
import org.springframework.stereotype.Service;
import com.taoxiuxia.service.IHistoryService;

@Service("historyService")
public class HistoryServiceImpl implements IHistoryService
{
    private IncomeMapper incomeMapper;
    private ExpenditureMapper expenditureMapper;
    
    @Override
    public List<Map> loadIncomesAndExpenditure(final int userId, final String inOrEx, final int year, final int month, final String keyword, final String sortBy, int curPage, final int totalPages) {
        final int limit = 20;
        final HashMap<String, Object> map = new HashMap<String, Object>();
        if (year != -1) {
            if (month != -1) {
                String monthStr;
                if (month < 10) {
                    monthStr = "0" + month;
                }
                else {
                    monthStr = new StringBuilder().append(month).toString();
                }
                map.put("beginDate", String.valueOf(year) + "-" + monthStr + "-01");
                map.put("endDate", String.valueOf(year) + "-" + monthStr + "-28");
            }
            else {
                map.put("beginDate", String.valueOf(year) + "-01-01");
                map.put("endDate", String.valueOf(year) + "-12-28");
            }
        }
        else {
            map.put("beginDate", null);
            map.put("endDate", null);
        }
        map.put("inOrEx", inOrEx);
        map.put("userId", userId);
        map.put("keyword", keyword);
        if (curPage < 1) {
            curPage = 1;
        }
        else if (curPage > totalPages) {
            curPage = totalPages;
        }
        map.put("sortBy", sortBy);
        map.put("beginRecord", ((curPage - 1) * limit < 0) ? 0 : ((curPage - 1) * limit));
        map.put("limit", limit);
        final List<Map> list = this.incomeMapper.selectIncomesAndExpenditure(map);
        return list;
    }
    
    @Override
    public int countIncomesAndExpenditure(final int userId, final String inOrEx, final int year, final int month, final String keyword) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        if (year != -1) {
            if (month != -1) {
                String monthStr;
                if (month < 10) {
                    monthStr = "0" + month;
                }
                else {
                    monthStr = new StringBuilder().append(month).toString();
                }
                map.put("beginDate", String.valueOf(year) + "-" + monthStr + "-01");
                map.put("endDate", String.valueOf(year) + "-" + monthStr + "-28");
            }
            else {
                map.put("beginDate", String.valueOf(year) + "-01-01");
                map.put("endDate", String.valueOf(year) + "-12-28");
            }
        }
        else {
            map.put("beginDate", null);
            map.put("endDate", null);
        }
        map.put("inOrEx", inOrEx);
        map.put("userId", userId);
        map.put("keyword", keyword);
        return this.incomeMapper.countIncomesAndExpenditure(map);
    }
    
    @Override
    public List<Map> last12Income(final int userId) {
        final Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("userId", new StringBuilder(String.valueOf(userId)).toString());
        final List<Map> list = this.incomeMapper.searchLast12Income(paraMap);
        this.completMonth(list);
        return this.sortListByMonth(list);
    }
    
    @Override
    public List<Map> last12Expenditure(final int userId) {
        final Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("userId", new StringBuilder(String.valueOf(userId)).toString());
        final List<Map> list = this.expenditureMapper.searchLast12Expenditure(paraMap);
        this.completMonth(list);
        return this.sortListByMonth(list);
    }
    
    private void completMonth(final List<Map> list) {
        LocalDate date = LocalDate.now();
        for (int i = 0; i < 12; ++i) {
            final String key = date.toString().substring(0, 7);
            boolean containKeyFlag = false;
            for (int j = 0; j < list.size(); ++j) {
                final Map map = list.get(j);
                if (map.get("month").equals(key)) {
                    map.put("sumMoney", NumberFormat.save2Decimals(map.get("sumMoney")));
                    containKeyFlag = true;
                }
            }
            if (!containKeyFlag) {
                final Map map2 = new HashMap();
                map2.put("month", key);
                map2.put("sumMoney", 0);
                list.add(map2);
            }
            date = date.minusMonths(1L);
        }
    }
    
    private List<Map> sortListByMonth(final List<Map> list) {
        final String[] arr = new String[12];
        for (int i = 0; i < list.size(); ++i) {
            arr[i] = list.get(i).get("month");
        }
        Arrays.sort(arr);
        final List<Map> retList = new ArrayList<Map>();
        for (int j = 0; j < 12; ++j) {
            for (int k = 0; k < list.size(); ++k) {
                if (list.get(k).get("month").equals(arr[j])) {
                    retList.add(list.get(k));
                    list.remove(k);
                }
            }
        }
        return retList;
    }
    
    @Override
    public List<Map> selectIncomeGroupByItemName(final int userId, final String startTime, final String endTime) {
        final Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("userId", new StringBuilder(String.valueOf(userId)).toString());
        paraMap.put("startTime", startTime);
        paraMap.put("endTime", endTime);
        final List<Map> list = this.incomeMapper.selectIncomeGroupByItemName(paraMap);
        return list;
    }
    
    @Override
    public List<Map> selectExpenditureGroupByItemName(final int userId, final String startTime, final String endTime) {
        final Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("userId", new StringBuilder(String.valueOf(userId)).toString());
        paraMap.put("startTime", startTime);
        paraMap.put("endTime", endTime);
        final List<Map> list = this.expenditureMapper.selectExpenditureGroupByItemName(paraMap);
        return list;
    }
    
    @Override
    public List<Map> selectAllExpenditureGroupByItemName(final int userId, final String startTime, final String endTime) {
        final Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("userId", new StringBuilder(String.valueOf(userId)).toString());
        paraMap.put("startTime", startTime);
        paraMap.put("endTime", endTime);
        final List<Map> list = this.expenditureMapper.selectAllExpenditureGroupByItemName(paraMap);
        return list;
    }
    
    public IncomeMapper getIncomeMapper() {
        return this.incomeMapper;
    }
    
    @Autowired
    public void setIncomeMapper(final IncomeMapper incomeMapper) {
        this.incomeMapper = incomeMapper;
    }
    
    public ExpenditureMapper getExpenditureMapper() {
        return this.expenditureMapper;
    }
    
    @Autowired
    public void setExpenditureMapper(final ExpenditureMapper expenditureMapper) {
        this.expenditureMapper = expenditureMapper;
    }
}
