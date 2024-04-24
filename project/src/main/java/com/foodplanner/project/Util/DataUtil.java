package com.foodplanner.project.Util;

import java.util.Arrays;

public class DataUtil {
    // [1, 2, 3] -> "1,2,3"
    public static String intsToCommaSeparatedString(int... ints) {
        return String.join(",", Arrays.stream(ints).mapToObj(String::valueOf).toArray(String[]::new));
    }
}
