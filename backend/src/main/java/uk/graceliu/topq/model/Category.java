package uk.graceliu.topq.model;

import java.util.List;

public interface Category extends Tag {
    public List<Category> getChildern();
}
