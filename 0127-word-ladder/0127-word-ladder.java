class Pair{
    String first;
    int second;
    Pair(String f,int s){
        this.first=f;
        this.second=s;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> set=new HashSet<>();
        int len=wordList.size();
        for(int i=0;i<len;i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair curr=q.poll();
            String word=curr.first;
            int step=curr.second;
            if(word.equals(endWord)) return step;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                   char[] replaceArray=word.toCharArray();
                    replaceArray[i]=ch;
                    String replaceWord=new String(replaceArray);
                    if(set.contains(replaceWord)){
                        set.remove(replaceWord);
                        q.offer(new Pair(replaceWord,step+1));
                    }
                }
            }
        }
        return 0;
    }
}