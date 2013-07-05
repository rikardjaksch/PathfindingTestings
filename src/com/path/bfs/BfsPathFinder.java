package com.path.bfs;

import com.path.PathFinder;
import com.path.PathNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class BfsPathFinder implements PathFinder {
    private Queue<BfsPathNode> searchQueue;
    private Vector<BfsPathNode> visitedNodes;
    public BfsPathFinder() {
        resetInternalLists();
    }

    @Override
    public Vector<PathNode> findPath(PathNode start, PathNode end) {
        resetInternalLists();
        BfsPathNode endNodeFound = null;

        searchQueue.add((BfsPathNode)start);
        while (searchQueue.size() != 0) {
            BfsPathNode item = searchQueue.poll();
            visitedNodes.add(item);

            Vector<PathNode> itemConnections = item.getConnections();

            for (int i = 0; i < itemConnections.size(); i++) {
                BfsPathNode node = (BfsPathNode) itemConnections.elementAt(i);
                if (node.isWalkable() && !visitedNodes.contains(node)) {
                    node.parent = item;
                }
            }

            for (int i = 0; i < itemConnections.size(); i++) {
                BfsPathNode node = (BfsPathNode) itemConnections.elementAt(i);
                if (node.isWalkable() && !visitedNodes.contains(node)) {
                    if (end.equals(node)) {
                        endNodeFound = node;
                        break;
                    } else {
                        searchQueue.add(node);
                    }
                }
            }

            if (endNodeFound != null) {
                break;
            }
        }

        if (endNodeFound != null) {
            Vector<PathNode> path = new Vector<PathNode>();

            while (endNodeFound != null) {
                path.add(0, endNodeFound);
                endNodeFound = endNodeFound.parent;
            }

            return path;
        } else {
            return null;
        }
    }

    private void resetInternalLists() {
        searchQueue = new LinkedList<BfsPathNode>();
        visitedNodes = new Vector<BfsPathNode>();
    }
}
