package com.joe007.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {

    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode nodeC = new UndirectedGraphNode(node.label);
        nodeMap.put(node.label, nodeC);
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode currentNode = queue.poll();
            UndirectedGraphNode copyNode = nodeMap.get(currentNode.label);

            for (UndirectedGraphNode neighbor : currentNode.neighbors) {
                if (!nodeMap.containsKey(neighbor.label)) {
                    UndirectedGraphNode neightborC = new UndirectedGraphNode(neighbor.label);
                    copyNode.neighbors.add(neightborC);
                    nodeMap.put(neighbor.label, neightborC);
                    queue.add(neighbor);
                } else {
                    copyNode.neighbors.add(nodeMap.get(neighbor.label));
                }
            }
        }

        return nodeC;
    }

    public static void main(String[] args) {
        CloneGraph instance = new CloneGraph();
        UndirectedGraphNode one = instance.new UndirectedGraphNode(1);
        UndirectedGraphNode zero = instance.new UndirectedGraphNode(0);
        UndirectedGraphNode two = instance.new UndirectedGraphNode(2);

        one.neighbors.add(zero);
        one.neighbors.add(two);

        zero.neighbors.add(one);
        zero.neighbors.add(two);

        two.neighbors.add(zero);
        two.neighbors.add(one);
        two.neighbors.add(two);

        instance.cloneGraph(one);

    }

}
