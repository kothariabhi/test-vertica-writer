package com.abhi.testmongo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestSortMap {
	
	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0) {
					return 1;
				} else {
					return compare;
				}
			}
		};
		
		Map<K, V> sortedMap = new TreeMap<K,V>(valueComparator);
		sortedMap.putAll(map);
		return sortedMap;
	}
	
	public static void main(String args[]) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Delhi", 5);
		map.put("Mumbai", 15);
		map.put("Chennai", 12);
		map.put("Agra", 18);
		
		System.out.println("Map : " + map.toString());
		System.out.println("Map : " + sortByValues(map).toString());
	}

}
