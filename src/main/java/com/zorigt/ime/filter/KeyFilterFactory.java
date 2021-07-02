package com.zorigt.ime.filter;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KeyFilterFactory {
    private final Map<String, KeyFilter> filterMap;

    public KeyFilterFactory() {
        filterMap = new HashMap<>(16);
        BTailKeyFilter bTailKeyFilter = new BTailKeyFilter();
        filterMap.put(bTailKeyFilter.getKey(), bTailKeyFilter);
    }

    public KeyFilter get(String key) {
        return filterMap.get(key);
    }

}
