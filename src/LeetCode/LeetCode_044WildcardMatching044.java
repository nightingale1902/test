package LeetCode;

public class LeetCode_044WildcardMatching044 {
    //time: O(n)  space: O(1)
    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        int match = 0;
        int star = -1;
        while (sp < s.length()){
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')){
                sp++;
                pp++;
            }else if (pp < p.length() && p.charAt(pp) == '*'){
                star = pp;
                match = sp;
                pp++;
            }else if (star != -1){
                /*
                * bbarc  sp
                * *c     pp
                * 两者的比较
                * */
                pp = star + 1;
                match++;
                sp = match;
            }else
                return false;
        }
        //pp可能未走到头
        while (pp < p.length() && p.charAt(pp) == '*'){
            pp++;
        }
        return pp == p.length();
    }
}
