package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    @JsonProperty("userId")
    public int userId;

    @JsonProperty("title")
    public String title;

    @JsonProperty("body")
    public String body;

    public Post(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public Post() {

    }
}
