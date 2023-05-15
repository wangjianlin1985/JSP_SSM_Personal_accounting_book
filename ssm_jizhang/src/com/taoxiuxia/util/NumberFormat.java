// 
// 
// 

package com.taoxiuxia.util;

public class NumberFormat
{
    public static float to2Decimals(final float num) {
        return (int)num / 100.0f;
    }
    
    public static float save2Decimals(final float num) {
        return (int)(num * 100.0f) / 100.0f;
    }
    
    public static double save2Decimals(final double num) {
        return (int)(num * 100.0) / 100.0;
    }
}
