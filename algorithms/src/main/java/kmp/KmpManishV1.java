package kmp;

/**
 * Created by manishsharma on 4/6/17.
 */
public class KmpManishV1 {
    public int[] processMatchString(char match[]){
        int[] result = new int[match.length];
        result[0] = 0;
        int i = 0, j=1;
        while(j < match.length){
            if(match[i] == match[j]){
                result[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = result[i-1];
                } else {
                    result[j] = 0;
                    j++;
                }
            }
        }
        return result;
    }

    public int findSubString(String rawString, String match){
        return findSubString(rawString.toCharArray(), match.toCharArray());
    }

    public int findSubString(char[] rawString, char[] match){
        int matchArr[] = processMatchString(match);

        int i=0,j=0;
        while(i < rawString.length){
            if(j == match.length){
                break;
            }
            if(rawString[i] == match[j]){
                i++;
                j++;
            } else {
                if(j !=0) {
                    j = matchArr[j - 1];
                } else {
                    i++;
                }
            }
        }

        if( j == match.length ){
            return i - match.length;
        } else {
            return -1;
        }
    }
}