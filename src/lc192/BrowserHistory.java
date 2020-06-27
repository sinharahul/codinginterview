package lc192;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Two pointers.Check if pointers dont exceed bounds
 * 
 */
class BrowserHistory {
        String homepage;
        int c=-1;
        int max=0;
        List<String> history=new ArrayList<>();
        public BrowserHistory(String homepage) {
          this.homepage=homepage;
          history.add(homepage);
          c++;
        }

        public void visit(String url) {
            c++;
            max=c;
            history.add(c,url);
        }

        public String back(int steps) {
            //why c+1
          int n=Math.min(steps,c+1);
          c=c-n;
          if(c<0){
              c=0;
          }
          return history.get(c);
        }

        public String forward(int steps) {
            int n=Math.min(steps,max-c);
            if(n>history.size()-1){
                n=history.size()-1;
            }
            c=c+n;
            return history.get(c);

        }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7);                   //
    }
}
