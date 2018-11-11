/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4;

import assignment_4.analytics.AnalysisHelper;
import assignment_4.analytics.DataStore;
import assignment_4.entities.Item;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author harshalneelkamal
 */
public class GateWay {
    
    DataReader orderReader;
    DataReader itemReader;
    AnalysisHelper helper;
    
    public GateWay() throws FileNotFoundException, IOException{
        DataGenerator generator = DataGenerator.getInstance();
        orderReader = new DataReader(generator.getOrderFilePath());
        itemReader = new DataReader(generator.getProductCataloguePath());
        helper = new AnalysisHelper();
    }
    
    public static void main(String args[]) throws IOException{
        GateWay g = new GateWay();
        g.readData();
    }
    
    private void readData() throws IOException{
        String[] row;
        while((row = orderReader.getNextRow()) != null ){
            generateOrder(row);
        }
        while((row = itemReader.getNextRow()) != null ){
        }
        runAnalysis();
    }
    
    private void generateOrder(String[] row){
        int orderId = Integer.parseInt(row[0]);
        int itemId = Integer.parseInt(row[1]);
        int productId = Integer.parseInt(row[2]);
        int quantity = Integer.parseInt(row[3]);
        int salesId = Integer.parseInt(row[4]);
        int customerId = Integer.parseInt(row[5]);
        int salesPerProduct = Integer.parseInt(row[6]);
        Item i = new Item(productId, salesPerProduct, quantity);
        Order o = new Order(orderId, salesId, customerId, i);
        DataStore.getInstance().getOrders().put(orderId, o);
    }
    
    private void runAnalysis(){
        helper.getPopularProduct();
        helper.getTotalRevenue();
        
    }
    
}
