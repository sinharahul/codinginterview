package amazon.top;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return list of lists of the suggested products after each character of searchWord is typed.
 *
 *
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 */
import java.util.*;
public class SearchSuggestion {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }

        String key = "";
        for (char c : searchWord.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "~");
            if (ceiling == null || floor == null) break;
            res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) res.add(new ArrayList<>());
        return res;
    }
    public List<List<String>> minesuggestedProducts(String[] products, String searchWord)
    {

        List<List<String>> result=new ArrayList<>();
        if(products.length==0 || searchWord==null||searchWord.trim().equals(""))return result;
        Map<String,List<String>> map=new HashMap<>();
        for(String product:products){

            for(int i=0;i<product.length();i++)
            {
                String key=convert(product,i);
                List<String> list=map.get(key);
                if(list==null)list=new ArrayList<>();
                if(!list.contains(product))
                {
                    list.add(product);
                    //forgot this step :(
                    map.put(key,list);
                }
            }
        }
        Iterator<List<String>> iter=map.values().iterator();
        while(iter.hasNext()){
            List list=iter.next();
            Collections.sort(list);
        }
        for(int i=0;i<searchWord.length();i++){
            String key=convert(searchWord,i);
            List l=map.get(key);
            if(l!=null && l.size()>3){
                l=l.subList(0,3);
            }
            result.add(l);
        }
        return result;
    }
    String convert(String s,int i){
        return s.substring(0,i+1);
    }
    public static void main(String[] args) {
     String[] products={"mobile","mouse","moneypot","monitor","mousepad"};
     String searchWord = "mouse";
     SearchSuggestion s=new SearchSuggestion();
     //List<List<String>> list=s.minesuggestedProducts(products,searchWord);
      List<List<String>> list=s.suggestedProducts(products,searchWord);
     for(List<String> l:list){
         System.out.println(l);
     }
    }

}
