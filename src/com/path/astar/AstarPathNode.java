package com.path.astar;

import com.path.PathNode;

/**
 * User: rikardj
 * Date: 2013-07-05
 * Time: 05:22
 */
public class AstarPathNode extends PathNode {

    public int heuristic;

    public AstarPathNode(boolean walkable) {
        super(walkable);
        heuristic = 0;
    }
}
