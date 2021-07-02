package com.zorigt.ime.approximate.matching;

public class StringDistanceInfo {
    private int distance;
    private MountObject mountObject;

    public StringDistanceInfo(int distance, MountObject mountObject) {
        this.distance = distance;
        this.mountObject = mountObject;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public MountObject getMountObject() {
        return mountObject;
    }

    public void setMountObject(MountObject mountObject) {
        this.mountObject = mountObject;
    }
}
