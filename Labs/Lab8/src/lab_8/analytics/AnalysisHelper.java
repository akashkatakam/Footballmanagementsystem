/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_8.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lab_8.entities.Comment;
import lab_8.entities.Post;
import lab_8.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    private Map<Integer, Comment> comments = DataStore.getInstance().getComments();
    private Map<Integer,Post> posts = DataStore.getInstance().getPosts();
    private Map<Integer, User> users = DataStore.getInstance().getUsers();
    private HashMap<Integer, Integer> userLikecount = new HashMap<Integer, Integer>();   
    
    public void userWithMostLikes(){
       System.out.println("-------------User with most Number Of Likes----------------------------");
       for(User user : users.values()){
           for(Comment c : user.getComments()){
               int likes = 0;
               if(userLikecount.containsKey(user.getId()))
                   likes = userLikecount.get(user.getId());
               likes += c.getLikes();
               userLikecount.put(user.getId(), likes);
           }   
       }
       LinkedHashMap<Integer, Integer> sortedHashmap = sortHashMapByValues(userLikecount);
       System.out.println(sortedHashmap.keySet().toArray()[0]);
    }
    public LinkedHashMap<Integer, Integer> sortHashMapByValues(
        HashMap<Integer, Integer> passedMap) {
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
    
    public void getFiveMostLikedComment(){ 
        System.out.println("-------------Five Most Liked Comments----------------------------");
        List<Comment> commentList = new ArrayList<>(comments.values());
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override  
            public int compare(Comment o1, Comment o2) { 
                //so as to get decending list 
                return o2.getLikes() - o1.getLikes();
            }
        });
    for(int i =0;i<5;i++){
            System.out.println(commentList.get(i).getId());
        }
    }
    
    public void getAverageNumberOfLikesPerComment() {
        System.out.println("-------------Average Number Of Likes Per Comment----------------------------");
        List<Comment> commentList = new ArrayList<>(comments.values());
        int sum = 0;
        for(Comment c :commentList){
            sum = c.getLikes() + sum;
        }
        //System.out.println(sum);
        double avg = Math.ceil(sum/commentList.size());
        System.out.println(avg);
    }
    
    
    
    public void getPostWithMostComments() {
    System.out.println("-------------Post with most comments----------------------------");
    List<Post> postList = new ArrayList<>(posts.values());
        Collections.sort(postList, new Comparator<Post>() {
            @Override
            public int compare(Post p1,Post p2){
                return p2.getComments().size()- p1.getComments().size();
            }
        });
        System.out.println(postList.get(0).getPostId());
    }
    
        
    public void getPostWithMostLikedComments(){
    System.out.println("-------------Post with most liked comments----------------------------");
    List<Post> postList = new ArrayList<>(posts.values());
        Collections.sort(postList, new Comparator<Post>() {
            @Override
            public int compare(Post p1,Post p2){
                int numLikesp1 = 0;
                int numLikesP2 = 0;
                for(Comment c:p1.getComments()){
                    numLikesp1 = c.getLikes()+numLikesp1;
                }
                for(Comment c:p2.getComments()){
                    numLikesP2 = c.getLikes()+numLikesP2;
                }
                return numLikesP2-numLikesp1;
            }
        });
        System.out.println(postList.get(0).getPostId());
    }
    
    public void getInactiveUsersOnPosts(){
    System.out.println("-------------Inactive user based on posts----------------------------");
    List<User> userList = new ArrayList<>(users.values());
      Collections.sort(userList, new Comparator<User>() {
          @Override
          public int compare(User o1, User o2) {
              return o1.getPosts().size() - o2.getPosts().size();
          }
      });
      for(int i = 0; i<5;i++){
          System.out.println(userList.get(i).getId());
      }
    }
    
    public void getInactiveUsersOnComments() {
    System.out.println("-------------Inactive user based on comments----------------------------");
    List<User> userList = new ArrayList<>(users.values());
      Collections.sort(userList, new Comparator<User>() {
          @Override
          public int compare(User o1, User o2) {
              return o1.getComments().size() - o2.getComments().size();
          }
      });
      for(int i = 0; i<5;i++){
          System.out.println(userList.get(i).getId());
      }
    }
     
    
    public void getInactiveUsersOnPostsandComments(){
     System.out.println("-------------Inactive user based on posts,likes and comments----------------------------");
     List<User> userList = new ArrayList<>(users.values());
     Collections.sort(userList, new Comparator<User>() {
         @Override
         public int compare(User o1, User o2) {
             return (o1.getPosts().size()+ o1.getComments().size()+ userLikecount.get(o1.getId())) - ( o2.getPosts().size() + o2.getComments().size() + userLikecount.get(o2.getId()));
         }
     });
     for(int i = 0; i<5;i++){
         System.out.println(userList.get(i).getId());
     }
    }
    
    public void getProactiveUsersOnPostsandComments(){
     System.out.println("-------------Proactive user based on posts,likes and comments----------------------------");
     List<User> userList = new ArrayList<>(users.values());
     Collections.sort(userList, new Comparator<User>() {
         @Override
         public int compare(User o1, User o2) {
             return (o2.getPosts().size()+ o2.getComments().size()+ userLikecount.get(o2.getId())) - ( o1.getPosts().size() + o1.getComments().size() + userLikecount.get(o1.getId()));
         }
     });
     for(int i = 0; i<5;i++){
         System.out.println(userList.get(i).getId());
     }
    }
    }

