public class StringSplit {
    public static void main(String[] args) {
        String s ="i loe   s      a";
        String[] arr=s.split(" ");
        System.out.println(reverseWords("a good   example"));
    }
    public static String reverseWords(String s) {
        String[] arr=s.split(" ");
        StringBuilder sb =new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            if(!arr[i].trim().equals("")){
                sb.append(arr[i].trim());
                if(i != 0){
                    sb.append(" ");
                }
            }

        }
        return sb.toString().trim();
    }
}
