package ee.taltech.calculator.theory.question2contribution.classes;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter

public class Cake {

    private Long id;
    private String name;
    private String sweetness;
    private String size;
    private String weight;
    private String rating;
    //... and more
    public Cake(Long id, String name, String sweetness, String size, String weight, String rating)
    {
        this.id = id;
        this.name = name;
        this.sweetness = sweetness;
        this.size = size;
        this.weight = weight;
        this. rating = rating;
    }

    //getters and setters
}
