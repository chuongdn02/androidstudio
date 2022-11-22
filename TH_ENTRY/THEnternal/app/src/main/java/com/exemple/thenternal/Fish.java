package com.exemple.thenternal;

import java.util.HashMap;
import java.util.Map;

public class Fish {
    String id,name, science, chara,color,pic;

    public Fish(String id, String name, String science, String chara, String color, String pic) {
        this.id = id;
        this.name = name;
        this.science = science;
        this.chara = chara;
        this.color = color;
        this.pic = pic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScience() {
        return science;
    }

    public void setScience(String science) {
        this.science = science;
    }

    public String getChara() {
        return chara;
    }

    public void setChara(String chara) {
        this.chara = chara;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    public Map<String, Object> toMap(){
        HashMap<String,Object> result =new HashMap<>();
        result.put("id",id);
        result.put("name",name);
        result.put("science",science);
        result.put("chara",chara);
        result.put("color",color);
        result.put("pic",pic);

        return result;
    }
}
