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
    
    public void userWithMostLikes(){
        System.out.println("-------------User with most Number Of Likes----------------------------");
       Map<Integer, Integer> userLikecount = new HashMap<Integer, Integer>();       
       for(User user : users.values()){
           for(Comment c : user.getComments()){
               int likes = 0;
               if(userLikecount.containsKey(user.getId()))
                   likes = userLikecount.get(user.getId());
               likes += c.getLikes();
               userLikecount.put(user.getId(), likes);
           }   
       }
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
        
    }

    
    

