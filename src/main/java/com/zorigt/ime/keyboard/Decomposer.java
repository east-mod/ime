package com.zorigt.ime.keyboard;

import com.zorigt.ime.common.Strings;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.*;

public class Decomposer {
    private static final transient Logger logger = LoggerFactory.getLogger(Decomposer.class);

    private final Node root;

    public Decomposer() {
        this.root = new Node();
        this.build();
    }

    private void build() {
        if (CollectionUtils.isEmpty(KeyboardLayout.getKeys())) {
            return;
        }
        Node current;
        String str;
        Node endNode;
        for (String key : KeyboardLayout.getKeys()) {
            if (Strings.isBlank(key)) {
                continue;
            }
            current = root;
            str = key;
            for (int i = 0; i != str.length(); i++) {
                Character character = str.charAt(i);
                if (!current.contain(character)) {
                    current.put(character);
                }
                if (i == str.length() - 1) {
                    endNode = current.get(character);
                    endNode.setEnd(true);
                    endNode.setKey(key);
                }
                current = current.get(character);
            }
        }
    }

    public List<List<String>> decompose(final String str) {
        long time1 = Instant.now().toEpochMilli();
        try {
            return this.decompose(new ArrayList<>(8), str);
        } finally {
            logger.info("decompose run time:{}", Instant.now().toEpochMilli() - time1);
        }
    }

    private List<List<String>> decompose(final List<String> prefixes, final String str) {
        List<List<String>> cases = new ArrayList<>(8);
        if (Strings.isBlank(str)) {
            cases.add(prefixes);
            return cases;
        }

        List<Node> matchedNodes = this.check(str);
        if (CollectionUtils.isEmpty(matchedNodes)) {
            cases.addAll(decompose(prefixes, str.substring(1)));
            return cases;
        }
        for (Node matchedNode : matchedNodes) {
            List<String> newPrefixes = new LinkedList<>(prefixes);
            newPrefixes.add(matchedNode.getKey());
            cases.addAll(decompose(newPrefixes, str.substring(matchedNode.key.length())));
        }
        return cases;
    }

    private List<Node> check(final String str) {
        if (Strings.isBlank(str)) {
            return null;
        }
        char c;
        Node current = root;
        List<Node> matchNodes = new LinkedList<>();
        for (int i = 0; i != str.length(); i++) {
            c = str.charAt(i);
            current = current.get(c);
            if (current != null && current.isEnd()) {
                matchNodes.add(current);
            }
            if (current == null) {
                break;
            }
        }
        return matchNodes;
    }

    private static class Node {
        @Getter
        @Setter
        private String key;
        @Getter
        @Setter
        private boolean isEnd;
        private final Map<Character, Node> children;

        public Node() {
            this.isEnd = false;
            this.children = new HashMap<>(8);
        }

        public Node get(Character character) {
            return children.get(character);
        }

        public boolean contain(Character character) {
            return this.children.containsKey(character);
        }

        public void put(Character character) {
            children.put(character, new Node());
        }
    }
}
