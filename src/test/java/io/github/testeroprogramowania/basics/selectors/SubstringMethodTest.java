package io.github.testeroprogramowania.basics.selectors;

public class SubstringMethodTest {
    public static void main(String[] args) {
        String test = "username";
        // substring jako parametry przyjmuje:
        // beginIndex - liczbowy ciąg znaków, który ma być wycięty
        String substring = test.substring(test.length()-"ame".length());
        System.out.println(substring);
    }
}
