package me.shackox;

import com.google.gson.Gson;
import me.shackox.model.Blog;
import me.shackox.service.UserService;

import static spark.Spark.post;
import static spark.Spark.get;

/**
 * Created by SHACKOX on 17/12/16.
 */
public class Api {
    public static UserService userService = new UserService();

    public static void main(String[] args) {
        final Gson gson = new Gson();

        post("/add-post", (request, response) -> {
            response.type("application/json");
            Blog blog = gson.fromJson(request.body(), Blog.class);
            return userService.addPost(blog);
        }, gson::toJson);

        get("/", (request, response) -> {
            response.type("application/json");
            return userService.getAllPost();
        }, gson::toJson);

        get("/:oth", (request, response) -> {
            response.type("application/json");
            Blog blog =  userService.getPostByOTH(request.params("oth"));
            if (blog != null) {
                return blog;
            } else {
                return "No post found";
            }
        }, gson::toJson);
    }
}
