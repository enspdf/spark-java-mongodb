package me.shackox.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by SHACKOX on 17/12/16.
 */

@Entity
public class Blog {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private String oth;

    public Blog() {
    }

    public Blog(String title, String description, String oth) {
        this.title = title;
        this.description = description;
        this.oth = oth;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
