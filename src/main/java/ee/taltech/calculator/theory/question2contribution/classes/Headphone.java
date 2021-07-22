package ee.taltech.calculator.theory.question2contribution.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Headphone {

    private Long id;
    private String manufacturer;
    private String price;
    private String anc;
    private String rating;
    private String releaseYear;
    //... and more

    public Headphone(Long id, String manufacturer, String price, String anc, String rating, String releaseYear) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.price = price;
        this.anc = anc;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    //getters and setters

}
