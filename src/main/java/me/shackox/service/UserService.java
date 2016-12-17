package me.shackox.service;

import com.mongodb.MongoClient;
import me.shackox.model.Blog;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import spark.utils.CollectionUtils;

import java.util.List;

/**
 * Created by SHACKOX on 17/12/16.
 */

public class UserService {
    MongoClient client = new MongoClient("localhost", 27017);
    Datastore datastore = new Morphia().createDatastore(client, "blog");

    public String addPost(Blog blog) {
        datastore.save(blog);
        return "add post";
    }

    public List<Blog> getAllPost() {
        List<Blog> list = datastore.find(Blog.class).asList();
        if (!CollectionUtils.isEmpty(list)) {
            return list;
        }
        return null;
    }

    public Blog getPostByOTH(String oth) {
        Blog blog = datastore.find(Blog.class, "oth", oth).get();
        if (blog != null) {
            return blog;
        } else {
            return null;
        }
    }
}
