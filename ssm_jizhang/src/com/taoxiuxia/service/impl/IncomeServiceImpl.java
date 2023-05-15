// 
// 
// 

package com.taoxiuxia.service.impl;

import java.util.Date;
import com.taoxiuxia.util.MyDateFormat;
import java.util.HashMap;
import com.taoxiuxia.model.Income;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.taoxiuxia.mapper.IncomeMapper;
import org.springframework.stereotype.Service;
import com.taoxiuxia.service.IIncomeService;

@Service("incomeService")
public class IncomeServiceImpl implements IIncomeService
{
    private IncomeMapper incomeMapper;
    
    public IncomeMapper getIncomeMapper() {
        return this.incomeMapper;
    }
    
    @Autowired
    public void setIncomeMapper(final IncomeMapper incomeMapper) {
        this.incomeMapper = incomeMapper;
    }
    
    @Override
    public List<Income> loadIncomes(final int userId) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("dataScale", "only_this_month");
        return this.incomeMapper.selectAllIncomes(map);
    }
    
    @Override
    public void addIncome(final int userId, final String date, final int item, final float money, final String moneyType, final String remark) {
        final Income income = new Income();
        income.setItemId(item);
        income.setUserId(userId);
        income.setDele(1);
        income.setMoney(money);
        income.setType_of_money(moneyType);
        income.setDate(MyDateFormat.dateFormat(date));
        income.setRemark(remark);
        this.incomeMapper.insert(income);
    }
    
    @Override
    public void changeIncome(final int incomeId, final float money, final String moneyType, final int itemId, final String remark, final Date date) {
        final Income income = new Income();
        income.setId(incomeId);
        income.setItemId(itemId);
        income.setMoney(money);
        income.setType_of_money(moneyType);
        income.setRemark(remark);
        income.setDate(date);
        this.incomeMapper.updateByPrimaryKeySelective(income);
    }
    
    @Override
    public void deleIncome(final int incomeId) {
        final Income income = new Income();
        income.setId(incomeId);
        income.setDele(-1);
        this.incomeMapper.updateByPrimaryKeySelective(income);
    }
}
