package me.xiaozhangup.natunology.api;

import java.util.ArrayList;
import java.util.List;

import static me.xiaozhangup.natunology.api.Message.getCode;

public class NString {

    public static List<String> toStringlist(String... s) {
        List<String> strings = new ArrayList<>();
        for (String string : s) {
            strings.add(string.replace("&", getCode()));
        }
        return strings;
    }
}
