package com.framework.base.util.apacheCommonsUtil.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.bidimap.TreeBidiMap;
import org.apache.commons.collections.map.LinkedMap;
/**
 * org.apache.commons.collections – Commons Collections自定义的一组公用的接口和工具类
	org.apache.commons.collections.bag – 实现Bag接口的一组类
	org.apache.commons.collections.bidimap – 实现BidiMap系列接口的一组类
	org.apache.commons.collections.buffer – 实现Buffer接口的一组类
	org.apache.commons.collections.collection – 实现java.util.Collection接口的一组类
	org.apache.commons.collections.comparators – 实现java.util.Comparator接口的一组类
	org.apache.commons.collections.functors – Commons Collections自定义的一组功能类
	org.apache.commons.collections.iterators – 实现java.util.Iterator接口的一组类
	org.apache.commons.collections.keyvalue – 实现集合和键/值映射相关的一组类
	org.apache.commons.collections.list – 实现java.util.List接口的一组类
	org.apache.commons.collections.map – 实现Map系列接口的一组类
	org.apache.commons.collections.set – 实现Set系列接口的一组类
 * @author Administrator
 *
 */
public class CollectionsUtilTest {

	/**
	 * @param args
	 *@author lyj [May 27, 2015]
	 */
	public static void main(String[] args) {
		/** 
	        * 得到集合里按顺序存放的key之后的某一Key 
	        */  
	        OrderedMap map = new LinkedMap();  
	        map.put("FIVE", "5");  
	        map.put("SIX", "6");  
	        map.put("SEVEN", "7");  
	        map.firstKey(); // returns "FIVE"  
	        map.nextKey("FIVE"); // returns "SIX"  
	        map.nextKey("SIX"); // returns "SEVEN"   
	      
	        /** 
	        * 通过key得到value 
	        * 通过value得到key 
	        * 将map里的key和value对调 
	        */  
	      
	        BidiMap bidi = new TreeBidiMap();  
	        bidi.put("SIX", "6");  
	        bidi.get("SIX");  // returns "6"  
	        bidi.getKey("6");  // returns "SIX"  
	        //       bidi.removeValue("6");  // removes the mapping  
	        BidiMap inverse = bidi.inverseBidiMap();  // returns a map with keys and values swapped  
	        System.out.println(inverse);  
	  
	        /** 
	         * 得到两个集合中相同的元素 
	         */  
	        List<String> list1 = new ArrayList<String>();  
	        list1.add("1");  
	        list1.add("2");  
	        list1.add("3");  
	        List<String> list2 = new ArrayList<String>();  
	        list2.add("2");  
	        list2.add("3");  
	        list2.add("5");  
	        Collection c = CollectionUtils.retainAll(list1, list2);  
	        System.out.println(c);// TODO Auto-generated method stub

	}

}
