// 
// 
// 

package com.taoxiuxia.service.impl;

import java.util.Date;
import com.taoxiuxia.util.MyDateFormat;
import java.util.HashMap;
import com.taoxiuxia.model.Expenditure;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.taoxiuxia.mapper.ExpenditureMapper;
import org.springframework.stereotype.Service;
import com.taoxiuxia.service.IExpenditureService;

@Service("expenditureService")
public class ExpenditureServiceImpl implements IExpenditureService
{
    private ExpenditureMapper expenditureMapper;
    
    public ExpenditureMapper getExpenditureMapper() {
        return this.expenditureMapper;
    }
    
    @Autowired
    public void setExpenditureMapper(final ExpenditureMapper expenditureMapper) {
        this.expenditureMapper = expenditureMapper;
    }
    
    @Override
    public List<Expenditure> loadExpenditures(final int userId) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("dataScale", "only_this_month");
        return this.expenditureMapper.selectAllExpenditures(map);
    }
    
    @Override
    public void addExpenditure(final int userId, final String date, final int item, final float money, final String moneyType, final String remark) {
        final Expenditure expenditure = new Expenditure();
        expenditure.setItemId(item);
        expenditure.setUserId(userId);
        expenditure.setDele(1);
        expenditure.setMoney(money);
        expenditure.setType_of_money(moneyType);
        expenditure.setDate(MyDateFormat.dateFormat(date));
        expenditure.setRemark(remark);
        this.expenditureMapper.insert(expenditure);
    }
    
    @Override
    public void changeExpenditure(final int expenditureId, final float money, final String moneyType, final int itemId, final String remark, final Date date) {
        final Expenditure expenditure = new Expenditure();
        expenditure.setId(expenditureId);
        expenditure.setItemId(itemId);
        expenditure.setMoney(money);
        expenditure.setType_of_money(moneyType);
        expenditure.setRemark(remark);
        expenditure.setDate(date);
        this.expenditureMapper.updateByPrimaryKeySelective(expenditure);
    }
    
    @Override
    public void deleExpenditure(final int expenditureId) {
        final Expenditure expenditure = new Expenditure();
        expenditure.setId(expenditureId);
        expenditure.setDele(-1);
        this.expenditureMapper.updateByPrimaryKeySelective(expenditure);
    }
}
