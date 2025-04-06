package com.app.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.app.utils.GenericUtils;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Mgr> mgrs = new ArrayList<>(List.of(new Mgr(1000), new Mgr(1500), new Mgr(2000)));
		System.out.println(GenericUtils.computeSum(mgrs));
		Vector<TempWorker> tempWorkers = new Vector<>(
				Arrays.asList(new TempWorker(100), new TempWorker(200), new TempWorker(300)));
		System.out.println(GenericUtils.computeSum(tempWorkers));
		LinkedList<SalesMgr> salesMgrs = new LinkedList<SalesMgr>(
				List.of(new SalesMgr(3000), new SalesMgr(4000), new SalesMgr(5000)));
		System.out.println(GenericUtils.computeSum(salesMgrs));
	}

}
