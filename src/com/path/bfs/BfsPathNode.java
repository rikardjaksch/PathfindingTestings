package com.path.bfs;

import com.path.PathNode;

public class BfsPathNode extends PathNode {
    public BfsPathNode parent;

    public BfsPathNode(boolean walkable) {
        super(walkable);
        parent = null;
    }
}
