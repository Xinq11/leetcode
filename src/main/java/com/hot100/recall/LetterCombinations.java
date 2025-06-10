package com.hot100.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        StringBuilder sb = new StringBuilder();

        dfs(res, 0, digits, sb, phoneMap);

        return res;
    }

    public void dfs(List<String> res, int index, String digits, StringBuilder sb, Map<Character, String> phoneMap) {
        if (index == digits.length()) {
            res.add(new StringBuilder(sb).toString());
            return;
        }
        for (int i = 0; i < phoneMap.get(digits.charAt(index)).length(); i++) {
            Character c = phoneMap.get(digits.charAt(index)).charAt(i);
            sb.append(c);
            dfs(res, index + 1, digits, sb, phoneMap);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> ab = letterCombinations.letterCombinations("23");
        System.out.println(ab);
    }
}
