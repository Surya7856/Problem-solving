public class Solution {
    static ArrayList<Integer> com(String s){
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                ArrayList<Integer> left=com(s.substring(0,i));
                ArrayList<Integer> right=com(s.substring(i+1));
                for(int k:left){
                    for(int j:right){
                        if(c=='+')
                            result.add(k+j);
                        else if(c=='-'){
                            result.add(k-j);
                        }
                        else if(c=='*')
                            result.add(k*j);
                    }
                }
            }
        }
        if(result.isEmpty()){
            result.add(Integer.parseInt(s));
        }
        return result;
    }
    public static int[] diffWaysToCompute(String s) {
        // Write your code here.
        ArrayList<Integer> out=com(s);
        int ans[]=new int[out.size()];
        for(int i=0;i<out.size();i++){
            ans[i]=out.get(i);
        }
        return ans;
    }
}
