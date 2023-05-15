// 
// 
// 

package com.taoxiuxia.service.impl;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.taoxiuxia.model.PayMethod;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.taoxiuxia.mapper.PayMethodMapper;
import org.springframework.stereotype.Service;
import com.taoxiuxia.service.IPayMethodService;

@Service("payMethodService")
public class PayMethodServiceImpl implements IPayMethodService
{
    private PayMethodMapper payMethodMapper;
    
    public PayMethodMapper getPayMethodMapper() {
        return this.payMethodMapper;
    }
    
    @Autowired
    public void setPayMethodMapper(final PayMethodMapper payMethodMapper) {
        this.payMethodMapper = payMethodMapper;
    }
    
    @Override
    public List<PayMethod> loadPayMethods(final int id, final String inOrEx) {
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", id);
        map.put("inOrEx", inOrEx);
        return this.payMethodMapper.selectPayMethodsByUserId(map);
    }
    
    @Override
    public void addPayMethod(final int userId, final String payMethodName, final int isCountInThisMonthEx, final String inOrEx, final String remark) {
        final Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("userId", userId);
        parameterMap.put("name", payMethodName);
        parameterMap.put("isCountInThisMonthEx", (isCountInThisMonthEx == -1) ? null : isCountInThisMonthEx);
        parameterMap.put("inOrEx", inOrEx);
        parameterMap.put("remark", remark);
        parameterMap.put("dele", 1);
        this.payMethodMapper.insert(parameterMap);
    }
    
    @Override
    public void changePayMethod(final int payMethodId, final String payMethodName, final int isCountInThisMonthEx, final String remark) {
        final PayMethod payMethod = new PayMethod();
        payMethod.setId(payMethodId);
        payMethod.setName(payMethodName);
        payMethod.setIsCountInThisMonthEx((isCountInThisMonthEx == -1) ? null : isCountInThisMonthEx);
        payMethod.setRemark(remark);
        this.payMethodMapper.updateByPrimaryKeySelective(payMethod);
    }
    
    @Override
    public void delePayMethod(final int payMethodId) {
        final PayMethod payMethod = new PayMethod();
        payMethod.setId(payMethodId);
        payMethod.setDele(-1);
        this.payMethodMapper.updateByPrimaryKeySelective(payMethod);
    }
    
    @Override
    public String upAndDownPayMethod(final int userId, final int payMethodId, final String inOrEx, final String upAndDown) {
        List<PayMethod> payMethodList = new ArrayList<PayMethod>();
        if ("ex".equals(inOrEx)) {
            payMethodList = this.loadPayMethods(userId, "ex");
        }
        else {
            if (!"in".equals(inOrEx)) {
                return "\u8f93\u5165\u53c2\u6570\u4e0d\u5408\u6cd5";
            }
            payMethodList = this.loadPayMethods(userId, "in");
        }
        final int listSize = payMethodList.size();
        final int[] payMethodIdArray = new int[listSize];
        final int[] sortArray = new int[listSize];
        for (int i = 0; i < listSize; ++i) {
            payMethodIdArray[i] = payMethodList.get(i).getId();
            sortArray[i] = payMethodList.get(i).getSort();
        }
        int curI = 0;
        for (int j = 0; j < listSize; ++j) {
            if (payMethodId == payMethodIdArray[j]) {
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
            this.exchange(userId, payMethodIdArray[curI], sortArray[curI], payMethodIdArray[curI - 1], sortArray[curI - 1]);
            return "\u4e0a\u79fb\u6210\u529f";
        }
        if ("down".equals(upAndDown)) {
            this.exchange(userId, payMethodIdArray[curI], sortArray[curI], payMethodIdArray[curI + 1], sortArray[curI + 1]);
            return "\u4e0b\u79fb\u6210\u529f";
        }
        return "\u4e0a\u79fb\u6216\u4e0b\u79fb\u5931\u8d25";
    }
    
    public void exchange(final int userId, final int payMethodId1, final int sort1, final int payMethodId2, final int sort2) {
        final PayMethod payMethod = new PayMethod();
        payMethod.setId(payMethodId1);
        payMethod.setSort(sort2);
        this.payMethodMapper.updateByPrimaryKeySelective(payMethod);
        payMethod.setId(payMethodId2);
        payMethod.setSort(sort1);
        this.payMethodMapper.updateByPrimaryKeySelective(payMethod);
    }
}
