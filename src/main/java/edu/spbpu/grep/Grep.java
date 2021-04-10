package edu.spbpu.grep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Grep {
    public static List<String> lines(boolean r, boolean v, boolean i, String word, String inputFile) throws IOException {
        String reg = word;
        if (!r) {
            //при quote все специальные символы превращаются в обычные(это если флага r нет)
            reg = Pattern.quote(word);
        }
        //класс pattern нужен для задания регулярного выражения и далее для поиска подстроки в строке
        Pattern pattern;
        if (i) {
            //скомпилируем строку reg в регулярное выражение, нечувсвительное к регистру
            pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        } else {
            //скомпилируем строку reg в регулярное выражение
            pattern = Pattern.compile(reg);
        }

        List<String> result = new ArrayList<>();
        FileReader fr = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(fr);
        String string = br.readLine();
        while (string != null) {
            //flag == true если в string будет найден pattern
            boolean flag = pattern.matcher(string).find();
            if (v) {
                    flag = !flag;
            }
            if (flag) {
                result.add(string);
            }
            string = br.readLine();
        }
        br.close();
        return result;
    }
}


