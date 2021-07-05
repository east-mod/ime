package com.zorigt.ime.input.method.controller;

import com.zorigt.ime.approximate.matching.SuggestWord;
import com.zorigt.ime.common.Strings;
import com.zorigt.ime.common.result.GenericResult;
import com.zorigt.ime.common.result.ResultBase;
import com.zorigt.ime.input.method.service.InputMethodService;
import com.zorigt.ime.input.method.value.MatchResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping(path = "/ime")
public class InputMethodController {

    @Resource
    private InputMethodService inputMethodService;

    @GetMapping(path = "/{key}")
    public ResultBase inputMethod(@PathVariable String key) {
        if (Strings.isBlank(key)) {
            return GenericResult.get(Collections.emptyList());
        }
        return GenericResult.get(inputMethodService.makeWord(key));
    }

    @GetMapping(path = "/fuzzy/score/{key}")
    public ResultBase getFuzzyWithScore(@PathVariable String key) {
        if (Strings.isBlank(key)) {
            return GenericResult.get(Collections.emptyList());
        }
        List<String> suggestList = new LinkedList<>();
        MatchResult<List<SuggestWord>> result = inputMethodService.fuzzyMakeWord(key);
        if (CollectionUtils.isNotEmpty(result.getObj())) {
            for (SuggestWord suggestWord : result.getObj()) {
                suggestList.add(suggestWord.toString());
            }
        }
        MatchResult<List<String>> resultStr = new MatchResult<>();
        resultStr.setRunTime(result.getRunTime());
        resultStr.setObj(suggestList);
        return GenericResult.get(resultStr);
    }

    @GetMapping(path = "/fuzzy/{key}")
    public ResultBase getFuzzy(@PathVariable String key) {
        if (Strings.isBlank(key)) {
            return GenericResult.get(Collections.emptyList());
        }
        List<String> suggestList = new LinkedList<>();
        MatchResult<List<SuggestWord>> result = inputMethodService.fuzzyMakeWord(key);
        if (CollectionUtils.isNotEmpty(result.getObj())) {
            for (SuggestWord suggestWord : result.getObj()) {
                suggestList.add(suggestWord.getStr());
            }
        }
        MatchResult<List<String>> result1 = new MatchResult<>();
        result1.setRunTime(result.getRunTime());
        result1.setObj(suggestList);
        return GenericResult.get(result1);
    }

    @GetMapping(path = "/severe/{key}")
    public ResultBase getSevere(@PathVariable String key) {
        if (Strings.isBlank(key)) {
            return GenericResult.get(Collections.emptyList());
        }
        return GenericResult.get(inputMethodService.severeMakeWord(key));
    }
}
