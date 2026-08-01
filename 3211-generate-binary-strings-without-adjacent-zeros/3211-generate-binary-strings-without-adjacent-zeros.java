class Solution {
    List<String> res;
    public List<String> validStrings(int n) {
        res=new ArrayList<>();
        String curr="";
        boolean zero=false;
        solve(curr,n,zero);
        return res;
    }
    private void solve(String curr,int n,boolean zero){
        if(curr.length()==n){
            res.add(curr);
            return ;
        }
        if(!zero){
        solve(curr+'0',n,true);
        }
        solve(curr+1,n,false);
    }
}