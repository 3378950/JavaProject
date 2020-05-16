package com.neuedu.test;

import java.util.List;

import com.neuedu.entity.Order;
import com.neuedu.entity.PayInfo;
import com.neuedu.util.DBUtils;

public class testPayInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<PayInfo> payInfoList = DBUtils.findAll(PayInfo.class);
		for (PayInfo payinfo : payInfoList) {
//			System.out.println(payinfo.getName());
		}
	}

}
