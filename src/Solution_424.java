public class Solution_424 {


    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 1));
    }

    public static int characterReplacement(String s, int k) {

        char[] charArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }
        int localMax = -999;
        for(int i = 0; i < charArray.length ; i++){
            int tempMax = 1+findNext(charArray,charArray[i],i,k);
            if (tempMax > localMax){
                localMax = tempMax;
            }
        }

        return localMax;
    }

    public static int findNext(char[] charArray,char left, int cur, int attempts) {
        if (cur >= charArray.length-1){ return 0; }
        else{
            if (charArray[cur+1] == left){
                return (1+findNext(charArray, left, cur+1, attempts));
            }
            else if(attempts ==0) return 0;
            else return (1+findNext(charArray, left,cur+1, attempts-1));
        }
    }
}
/*
    public int characterReplacement(String s, int k) {

        char[] charArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }

        // - matrix[*][0] is tempCounting
        // - matrix[*][1] is remaining attempts of replacement
        // - matrix[*][2] is localMax counting of each character

        Integer[][] matrix = new Integer[26][3];

        for (char cur : charArray){
            // find the position of the character in the matrix
            int charIndex = (int) cur - 65;

            // initialize a counting
            if (matrix[charIndex][0] == null) {
                matrix[charIndex][0] = 1;
                matrix[charIndex][1] = k;
                matrix[charIndex][2] = 1;
            }
            // when character matches, tempCounting +1,
            // attempts +1 because it will be reduced by 1 latter
            // also check localMax
            else{
                matrix[charIndex][0] ++;
                matrix[charIndex][1] ++;
                if (matrix[charIndex][0] > matrix[charIndex][2]){matrix[charIndex][2] = matrix[charIndex][0];}
            }
            for (int i = 0; i < 25; i++){

                // attempts reduced since it might be possible to make long
                // string by replacement
                if(matrix[charIndex][1]!= null) {
                    matrix[charIndex][1]--;
                    // if attempts = -1, that means it can not reach the next repetition
                    // ======================= warning ===================
                    // it's possible that the last character can be used in next string
                }
            }
        }


        return 0;
    }
*/

