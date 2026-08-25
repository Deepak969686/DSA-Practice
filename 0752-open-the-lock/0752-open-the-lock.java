class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<deadends.length;i++){
            set.add(deadends[i]);
        }
        if(set.contains("0000")) return -1;
        Queue<String> q=new LinkedList<>();
        Set<String> vis=new HashSet<>();
        q.offer("0000");
        vis.add("0000");
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String word=q.poll();
                if(word.equals(target)) return steps;
                char[] ch=word.toCharArray();
                for(int i=0;i<4;i++){
                    char original=ch[i];
                    ch[i]=(original=='9')?'0':(char)(original + 1);
                    String next=new String(ch);
                    if(!set.contains(next) && !vis.contains(next)){
                        q.offer(next);
                        vis.add(next);
                    }

                    ch[i]=(original=='0')?'9':(char)(original - 1);
                    next = new String(ch);
                    if(!set.contains(next) && !vis.contains(next)){
                        q.offer(next);
                        vis.add(next);
                    }
                    ch[i] = original;
                }
            }
            steps++;
        }
        return -1;
    }
}