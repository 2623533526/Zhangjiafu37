package com.bawei.zhangjiafu37.entity;

import java.util.List;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class FlowEntity {
    List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "FlowEntity{" +
                "tags=" + tags +
                '}';
    }
}
