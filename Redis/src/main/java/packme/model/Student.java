package packme.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Student")
public class Student implements Serializable {
    private String id;
    private String name;
    private int grade;
}
