//https://leetcode.com/problems/largest-substring-between-two-equal-characters/?envType=daily-question&envId=2023-12-31
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int alpha[]=new int[26];
        int max=-1;
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            //store index of the first occurence
            if(alpha[temp-'a']==0)
                alpha[temp-'a']=i+1;
            //updating the max length when second occurence
            else{
                max=Math.max(max,i-alpha[temp-'a']);
            }
        }
        return max;
    }
}
