package jwtexample3.example.kanbanflow.apiResponse;

import lombok.Data;

import java.util.ArrayList;


@Data
public class SunbaseTemplatesResp{
    public ArrayList<Course> courses = new ArrayList<>();

    @Data
    public static class Course{
        public String uuid;
        public String name;
        public String fileType;
        public String createUserUuid;
        public String data;
    }
}
