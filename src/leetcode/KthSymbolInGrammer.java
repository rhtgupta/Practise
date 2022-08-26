package leetcode;


public class KthSymbolInGrammer {

    public static void main(String[] args) {
        System.out.println(kthGrammar(3, 3));
    }


    static int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        String str = createTable(n, k);
        if (k > str.length()) {
            return 0;
        }
        return Integer.parseInt(String.valueOf(str.charAt(k - 1)));
    }

    static String createTable(int noOfRows, int k) {
        String previousRowString = "";
        for (int i = 0; i < noOfRows; i++) {
            if (i == 0) {
                previousRowString = "0";
            } else {
                StringBuilder builder = new StringBuilder();
                builder.append(previousRowString);
                for (int j = 0; j < previousRowString.length(); j++) {
                    if (previousRowString.charAt(j) == '0') {
                        builder.append("1");
                    } else {
                        builder.append("0");
                    }
                }
                previousRowString = new String(builder);
            }
            if(previousRowString.length() >= k){
                break;
            }
        }
        return previousRowString;
    }

}
