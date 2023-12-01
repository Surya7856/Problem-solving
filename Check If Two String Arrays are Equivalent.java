//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/?envType=daily-question&envId=2023-12-01
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();

    for (String str : word1) {
        s1.append(str);
    }

    for (String str : word2) {
        s2.append(str);
    }

    return s1.toString().equals(s2.toString());
    }
}
