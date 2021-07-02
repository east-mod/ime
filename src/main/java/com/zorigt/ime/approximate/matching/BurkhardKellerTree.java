package com.zorigt.ime.approximate.matching;

import com.zorigt.ime.common.Strings;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class BurkhardKellerTree {
    private final Node root;

    private final LevenshteinDistance levenshteinDistance;

    public BurkhardKellerTree(final MountObject rootMount) {
        this.levenshteinDistance = new LevenshteinDistance();
        this.root = new Node(rootMount);
        this.root.isRoot = true;
    }

    public BurkhardKellerTree(final MountObject rootMount, final List<? extends MountObject> mountObjectList) {
        this.levenshteinDistance = new LevenshteinDistance();
        this.root = new Node(rootMount);
        this.root.isRoot = true;
        this.addAll(mountObjectList);
    }

    public void addAll(final List<? extends MountObject> mountObjectList) {
        if (CollectionUtils.isEmpty(mountObjectList)) {
            return;
        }
        for (MountObject mountObject : mountObjectList) {
            if (Strings.isNotBlank(mountObject.getString())) {
                this.mount(root, mountObject);
            }
        }
    }

    public void add(final MountObject mountObject) {
        if (Strings.isNotBlank(mountObject.getString())) {
            this.mount(root, mountObject);
        }
    }

    private void mount(final Node node, final MountObject mountObject) {
        int d = levenshteinDistance.getDistance(node.mountObject.getString(), mountObject.getString());
        if (d == 0) {
            return;
        }
        Node child = node.getChild(d);
        if (child == null) {
            node.putChild(d, new Node(mountObject));
        } else {
            mount(child, mountObject);
        }
    }

    public List<StringDistanceInfo> matching(final String str, final int n) {
        List<StringDistanceInfo> matchedList = new ArrayList<>();
        this.match(matchedList, root, str, n);
        return matchedList;
    }

    private void match(final List<StringDistanceInfo> list, final Node node, final String str, final int n) {
        if (node == null) {
            return;
        }
        int d = levenshteinDistance.getDistance(node.mountObject.getString(), str);
        if (d <= n && !node.isRoot) {
            list.add(new StringDistanceInfo(d, node.mountObject));
        }
        if (MapUtils.isEmpty(node.children)) {
            return;
        }
        for (int i = Math.max(0, d - n); i <= d + n; i++) {
            if (node.children.containsKey(i)) {
                match(list, node.getChild(i), str, n);
            }
        }
    }

    private static class Node {
        private boolean isRoot = false;

        private final MountObject mountObject;

        private final TreeMap<Integer, Node> children;

        public Node(final MountObject mountObject) {
            this.mountObject = mountObject;
            this.children = new TreeMap<>();
        }

        public void putChild(final int distance, final Node child) {
            this.children.put(distance, child);
        }

        public Node getChild(final int distance) {
            if (MapUtils.isEmpty(this.children)) {
                return null;
            }
            return this.children.get(distance);
        }
    }
}
