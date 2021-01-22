class leetcode242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int counter[] = new int[26];
        for(int i = 0 ; i< s.length(); i++) {
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        boolean p=true;
        for(int i=0 ; i< counter.length ;i++) {
            if(counter[i] !=0){
                p=false;
            }

        }
        return p;







    }
}