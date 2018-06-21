/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicetype.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 请求响应：菜单数据-工具类
 */
public class Node<T> implements Comparable<Node> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String id; //[treeview]节点的编号，一般为模型数据的id

    private String text; //[treeview]节点显示的名称

    private int index; //[程序逻辑排序用]节点的顺序

    private T data;//[程序逻辑便于操作数据]节点携带的完整数据

    private List<Node<T>> nodes = new ArrayList<>();//当前节点的子节点

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Node<T>> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node<T>> nodes) {
        this.nodes = nodes;
    }

    /**
     * 生成节点
     *
     * @param id
     * @param text
     * @param index
     * @param data
     */
    public Node(String id, String text, int index, T data) {
        this.data = data;
        this.index = index;
        this.text = text;
        this.id = id;
    }

    /**
     * 排序
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Node o) {
        if (this.getIndex() == o.getIndex()) {
            return 0;//一样大前后无所谓
        }
        if (this.getIndex() > o.getIndex()) {
            return 1;//大靠后
        }
        if (this.getIndex() < o.getIndex()) {
            return -1;//小靠前
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", index=" + index +
                ", data=" + data +
                ", nodes=" + nodes +
                '}';
    }
}
