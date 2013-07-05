package com.path.bfs;

import com.path.PathNode;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BfsPathFinderTest {
    private BfsPathFinder pathFinder;
    private BfsPathNode nodes[][];

    @org.junit.Before
    public void setUp() throws Exception {
        pathFinder = new BfsPathFinder();
        nodes = new BfsPathNode[10][10];

        // Create all the nodes
        for ( int y = 0; y < 10; y++ ) {
            for ( int x = 0; x < 10; x++ ) {
                nodes[y][x] = new BfsPathNode(true);
            }
        }

        // Set up connections for the nodes
        for ( int y = 0; y < 10; y++ ) {
            for ( int x = 0; x < 10; x++ ) {
                if ( y > 0 ) {
                    nodes[y][x].addConnection(nodes[y - 1][x]);
                }

                if ( y < 9 ) {
                    nodes[y][x].addConnection(nodes[y + 1][x]);
                }

                if ( x > 0 ) {
                    nodes[y][x].addConnection(nodes[y][x - 1]);
                }

                if ( x < 9 ) {
                    nodes[y][x].addConnection(nodes[y][x + 1]);
                }
            }
        }
    }

    @Test
    public void testIfPathIsReturnedWhenEndIsBesidesStart() throws Exception {
        Vector<PathNode> path = pathFinder.findPath(nodes[0][0], nodes[0][1]);
        assertTrue(path.size() == 2);
        assertTrue(path.elementAt(0) == nodes[0][0]);
        assertTrue(path.elementAt(1) == nodes[0][1]);
    }

    @Test
    public void testThatUnwalkabaleAreasIsAffectingPath() throws Exception {
        Vector<PathNode> path = pathFinder.findPath(nodes[0][0], nodes[0][3]);
        assertTrue(path.size() == 4);

        nodes[0][1].setWalkable(false);
        path = pathFinder.findPath(nodes[0][0], nodes[0][3]);
        assertTrue(path.size() != 4);
    }

    @Test
    public void testThatFindPathReturnsNullWhenNoValidPathExists() throws Exception {
        nodes[0][1].setWalkable(false);
        nodes[1][0].setWalkable(false);
        Vector<PathNode> path = pathFinder.findPath(nodes[0][0], nodes[1][1]);
        assertNull(path);
    }
}
