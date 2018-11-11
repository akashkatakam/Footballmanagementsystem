/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.analytics;

import assignment_4.entities.Order;
import assignment_4.entities.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class AnalysisHelper {
    Map<Integer,Order> orders = DataStore.getInstance().getOrders();
    Map<Integer,Product> Prdoucts = DataStore.getInstance().getProducts();
    
    public void getPopularProduct(){
        System.out.println("-------------Best 3 popular products----------------------------");
        HashMap<Integer,Integer> productQuantityMap = new HashMap<>();
        for(Order o:orders.values()){
            int productId = o.getItem().getProductId();
            int quantity = o.getItem().getQuantity();
            if(productQuantityMap.containsKey(productId)){
                productQuantityMap.put(productId, quantity + productQuantityMap.get(productId));
            }else
                productQuantityMap.put(productId,quantity);
        }
        LinkedHashMap<Integer, Integer> sortedProductMap = sortHashMapByValues(productQuantityMap);
        for(int i = sortedProductMap.size()-1; i>sortedProductMap.size()-4 ;--i){
         System.out.println(sortedProductMap.entrySet().toArray()[i]);
        }
    }
    
    public void getTotalRevenue() {
        System.out.println("-------------Total revenue----------------------------");
        int totalRevenue = 0;
        for(Order o: orders.values()){
            int price = o.getItem().getSalesPrice();
            int productId = o.getItem().getProductId();
            int minPrice = Prdoucts.get(productId).getMinPrice();
            int quantity = o.getItem().getQuantity();
            int orderRevenue = (price - minPrice)*quantity;
            totalRevenue = orderRevenue + totalRevenue;
        }
        System.out.println(totalRevenue);
    }
    
    public LinkedHashMap<Integer, Integer> sortHashMapByValues(HashMap<Integer, Integer> passedMap) {
        List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<Integer> keyIt = mapKeys.iterator();
            while (keyIt.hasNext()) {
                Integer key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;
                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }
}
