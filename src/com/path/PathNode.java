package com.path;

import java.util.Vector;

public class PathNode {
    private Vector<PathNode> connections;
    private boolean walkable;

    public PathNode(boolean walkable) {
        connections = new Vector<PathNode>();
        setWalkable(walkable);
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public Vector<PathNode> getConnections() {
        return connections;
    }

    public void addConnection(PathNode node) {
        connections.add(node);
    }

    public boolean equals(PathNode node) {
        return (this == node);
    }
}
