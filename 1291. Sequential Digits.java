class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        String s="123456789";
        for(int i=2;i<=9;i++){
            for(int j=0;j<10-i;j++){
                int num=Integer.parseInt(s.substring(j,i+j));
                if(low<=num && num<=high)
                    res.add(num);
            }
        }
        return res;
    }
}
