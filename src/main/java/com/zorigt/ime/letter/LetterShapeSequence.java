package com.zorigt.ime.letter;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class LetterShapeSequence {
    public static final transient LetterShapeSequence emptyLss = new EmptyLss();

    private final List<LetterShape> letterShapes;

    private Nature nature;

    public LetterShapeSequence() {
        this.letterShapes = new ArrayList<>();
        this.nature = Nature.SAARMAG;
    }

    public void append(LetterShape letterShape) {
        this.setNature(NatureUtil.getNature(letterShape.getLatinKey()));
        letterShapes.add(letterShape);
    }

    public void append(LetterShapeSequence letterShapeSequence) {
        for (LetterShape letterShape : letterShapeSequence.letterShapes) {
            this.append(letterShape);
        }
    }

    private void setNature(Nature ntr) {
        if (ntr == nature || ntr == Nature.SAARMAG) {
            return;
        }
        this.nature = ntr;
    }

    public Nature getNature() {
        return nature;
    }

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(letterShapes);
    }

    public boolean isNotEmpty() {
        return CollectionUtils.isNotEmpty(letterShapes);
    }

    public int size() {
        return this.letterShapes.size();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (LetterShape letterShape : this.letterShapes) {
            s.append(letterShape.getShape());
        }
        return s.toString();
    }

    public LetterShape getLast() {
        return this.letterShapes.get(this.letterShapes.size() - 1);
    }

    private static class EmptyLss extends LetterShapeSequence {
        @Override
        public void append(LetterShape letterShape) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void append(LetterShapeSequence letterShapeSequence) {
            throw new UnsupportedOperationException();
        }
    }

    public static LetterShapeSequence emptyLss() {
        return emptyLss;
    }
}
