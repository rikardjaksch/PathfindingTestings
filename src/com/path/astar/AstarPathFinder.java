package com.path.astar;

import com.path.PathFinder;
import com.path.PathNode;

import java.util.Vector;

public class AstarPathFinder implements PathFinder {
    private Vector<AstarPathNode> closedSet;
    private Vector<AstarPathNode> openSet;
    private Vector<AstarPathNode> cameFrom;

    public AstarPathFinder() {
        resetInternalLists();
    }

    @Override
    public Vector<PathNode> findPath(PathNode start, PathNode end) {
        resetInternalLists();
        openSet.add((AstarPathNode)start);

        return null;
    }

    private void resetInternalLists() {
        closedSet = new Vector<AstarPathNode>();
        openSet = new Vector<AstarPathNode>();
        cameFrom = new Vector<AstarPathNode>();
    }
}
