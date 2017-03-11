package com.framework.base.util.hessian;

import java.util.ArrayList;
import java.util.List;

public class CitationServiceImpl implements CitationService {

	
	public Citation getCitationsForVehicle() {
		// TODO Auto-generated method stub
		Citation citation=new Citation();
		citation.setName("名字");
		List<Integer> list=new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		citation.setList(list);
		return citation;
	}

}
