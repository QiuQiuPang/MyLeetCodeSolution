public class Solution_Sward_20 {
    public static void main(String[] args) {
        System.out.println(isNumber("3.5e+3.5e+3.5"));
    }

    public static boolean isNumber(String s) {
        char[] array = s.toCharArray();
        int i = 0, length = array.length;
        boolean mark2= false, mark = false, mark3 = false;
        switch(1) {
            case 1: while (array[i]==' ') {i++; if(i==length) return false;}
            case 2: if(array[i] == '-' || array[i] == '+') i++; if(i==length) return false;
            case 3: if(((int)array[i]<48 || (int)array[i] >57) && array[i] != '.' ) return false;
            case 4: while ((int)array[i]>47 && (int)array[i]<58) {i++; if(i==length) return true; mark = true;}
            case 5: if(array[i] == '.') i++; if(i==length) return mark;  while ((int)array[i]>47 && (int)array[i]<58) {i++; if(i==length) return true; mark = true;} if(array[i] == ' ') {while(array[i] == ' ') {i++; if(i==length) return mark;} return false;}
            case 6: if(array[i] == 'e' ||array[i] == 'E' ) {i++; mark2=true;} if(i==length) return false;
            case 7: if(array[i] == '-' || array[i] == '+') i++; if(i==length) return false;
            case 8: if(((int)array[i]<48 || (int)array[i] >57)&& array[i] != ' ') return false;
            case 9: if((int)array[i]>47 && (int)array[i]<58){ while ((int)array[i]>47 && (int)array[i]<58) {i++; if(i==length) return mark2&&mark;} mark = false;}
            case 10: if(array[i] == ' ') {while(array[i] == ' ') {i++; if(i==length) return !mark;} return false;}
        }
        return true;
    }
}
