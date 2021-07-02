package com.zorigt.ime.keyboard;

import com.google.common.collect.Lists;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.Letters;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

public class KeyboardLayout {
    private static final transient Logger logger = LoggerFactory.getLogger(KeyboardLayout.class);

    private static final List<String> KEYS = Lists.newArrayList(
            "a", "e", "i", "o", "u",
            "n", "b", "p", "h", "g", "m", "l", "s", "x", "t", "d", "q", "j", "y", "r",
            "w", "f", "k", "c", "z",
            "H", "R", "L", "Z", "C");

    private static final Map<String, List<Letter>> keyMap = new HashMap<>(64);


    static {
        keyMap.put("a", Lists.newArrayList(Letters.A));
        keyMap.put("e", Lists.newArrayList(Letters.E));
        keyMap.put("i", Lists.newArrayList(Letters.I));
        keyMap.put("o", Lists.newArrayList(Letters.O));
        keyMap.put("u", Lists.newArrayList(Letters.U));

        keyMap.put("n", Lists.newArrayList(Letters.N));
        keyMap.put("b", Lists.newArrayList(Letters.B));
        keyMap.put("p", Lists.newArrayList(Letters.P));
        keyMap.put("h", Lists.newArrayList(Letters.H));
        keyMap.put("g", Lists.newArrayList(Letters.G));
        keyMap.put("m", Lists.newArrayList(Letters.M));
        keyMap.put("l", Lists.newArrayList(Letters.L));
        keyMap.put("s", Lists.newArrayList(Letters.S));
        keyMap.put("x", Lists.newArrayList(Letters.X));
        keyMap.put("t", Lists.newArrayList(Letters.T));
        keyMap.put("d", Lists.newArrayList(Letters.D));
        keyMap.put("q", Lists.newArrayList(Letters.Q));
        keyMap.put("j", Lists.newArrayList(Letters.J));
        keyMap.put("y", Lists.newArrayList(Letters.Y));
        keyMap.put("r", Lists.newArrayList(Letters.R));
        keyMap.put("w", Lists.newArrayList(Letters.W));
        keyMap.put("f", Lists.newArrayList(Letters.F));
        keyMap.put("k", Lists.newArrayList(Letters.K));
        keyMap.put("c", Lists.newArrayList(Letters.C));
        keyMap.put("z", Lists.newArrayList(Letters.Z));
        keyMap.put("H", Lists.newArrayList(Letters.GALIG_H));
        keyMap.put("R", Lists.newArrayList(Letters.GALIG_R));
        keyMap.put("L", Lists.newArrayList(Letters.GALIG_L));
        keyMap.put("Z", Lists.newArrayList(Letters.GALIG_ZH));
        keyMap.put("C", Lists.newArrayList(Letters.GALIG_CH));
    }

    public static List<LetterShape> get(String key, byte letterLocation) {
        List<Letter> letterList = keyMap.get(key);
        if (CollectionUtils.isEmpty(letterList)) {
            return Collections.emptyList();
        }
        List<LetterShape> letterShapeList = Lists.newArrayListWithExpectedSize(16);
        try {
            LetterShape tmp;
            for (Letter letter : letterList) {
                for (Field declaredField : letter.getClass().getDeclaredFields()) {
                    if (!declaredField.getType().equals(LetterShape.class)) {
                        continue;
                    }
                    tmp = (LetterShape) declaredField.get(letter);
                    if (tmp.getLocation() == letterLocation) {
                        letterShapeList.add(tmp);
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("throw exception when get the letter shape");
        }
        return letterShapeList;
    }

    public static Set<String> getKeys() {
        return Collections.unmodifiableSet(new HashSet<>(KEYS));
    }
}
