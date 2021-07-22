package ee.taltech.calculator.theory.question2contribution.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Phone {

    private Long id;
    private String manufacturer;
    private String modelNr;
    private String rating;
    private String releaseYear;
    //... and more

    public Phone(){}
    public Phone(Long id, String manufacturer, String modelNr, String rating, String releaseYear)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.modelNr = modelNr;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }
    //getters and setters
}
