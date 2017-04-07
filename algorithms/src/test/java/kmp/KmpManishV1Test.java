package kmp;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by manishsharma on 4/6/17.
 */
public class KmpManishV1Test {

    private KmpManishV1 kmpManishV1;

    @Before
    public void setup(){
        kmpManishV1 = new KmpManishV1();
    }

    @Test
    public void processMatchStringTest() throws Exception {
        int[] actual = kmpManishV1.processMatchString("abcdabca".toCharArray());
        int [] expected = {0,0,0,0,1,2,3,1};
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);

        actual = kmpManishV1.processMatchString("aabaabaaa".toCharArray());
        int[] expected1 = {0,1,0,1,2,3,4,5,2};
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected1, actual);

        actual = kmpManishV1.processMatchString("abcaby".toCharArray());
        int[] expected2 = {0,0,0,1,2,0};
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected2, actual);
    }

    @Test
    public void findSubStringTest() throws Exception {
        String rawString = "abcdabcdabcde";
        String matchStr = "abcde";
        int actual = kmpManishV1.findSubString(rawString, matchStr);
        assertEquals(8, actual);
    }

    @Test
    public void findSubStringMiddleTest() throws Exception {
        String rawString = "abcdabcdabcdeabcabcabc";
        String matchStr = "abcde";
        int actual = kmpManishV1.findSubString(rawString, matchStr);
        assertEquals(8, actual);
    }

    @Test
    public void findSubStringBeginTest() throws Exception {
        String rawString = "abcdeabcdabcdabcabcabc";
        String matchStr = "abcde";
        int actual = kmpManishV1.findSubString(rawString, matchStr);
        assertEquals(0, actual);
    }

    @Test
    public void findSubStringMissingTest() throws Exception {
        String rawString = "abcdabcdabcdabcabcabc";
        String matchStr = "abcde";
        int actual = kmpManishV1.findSubString(rawString, matchStr);
        assertEquals(-1, actual);
        "abc".contains("abc");
    }
}