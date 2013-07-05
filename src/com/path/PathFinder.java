package com.path;

import java.util.Vector;

public interface PathFinder {
    public Vector<PathNode> findPath(PathNode start, PathNode end);
}
