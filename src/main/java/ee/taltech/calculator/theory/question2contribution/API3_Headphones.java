package ee.taltech.calculator.theory.question2contribution;

import ee.taltech.calculator.theory.question2contribution.classes.Cake;
import ee.taltech.calculator.theory.question2contribution.classes.Headphone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class API3_Headphones {

    // todo this is contribution question
    //  this assignment is only for one team member (if this code is not committed by that team member how do I know this code was theirs?)

    // todo
    //  this assignment consists of 2 parts
    //  practical assignment A, B, C, D, E
    //          All classes are available in classes package
    //          If you want to test these practical assignments add these to your project.
    //          Example: If you Application.java is in the package ee.taltech, make sure theory is in package ee.taltech as well (ee.taltech.theory)
    //  theoretical assignment F, G, H

    //todo practical assignment
    // Management wants to define an API endpoint so frontend can display data about headphones (think headphones e-shop)
    // + A Add necessary annotations to this class so this class can serve data
    // + B Add a method to query all the headphones (method content is not important - I am grading urls, annotations, names, and parameters)
    // + C Add a method to query a single headphones by it's unique identifier (method content is not important - I am grading urls, annotations, names, and parameters)
    // + D Modify an existing method to query/filter headphones by price while keeping existing functionality (price can be a string)
    // E Modify an existing method to query/filter anc (active noise cancellation) while keeping existing functionality (anc can be a string)

    Headphone airPods = new Headphone(1L, "Apple", "120", "7.2", "9.2", "2008");
    Headphone airPodsPRO = new Headphone(2L, "Apple", "320", "9.6", "9.5", "2019");
    Headphone earBuds = new Headphone(3L, "Xiaomi", "40", "4.7", "8.5", "2018");
    Headphone airDots = new Headphone(4L, "Xiaomi", "30", "7.2", "8.2", "2019");
    Headphone bits = new Headphone(5L, "Bits", "250", "9.9", "9.8", "2017");

    List<Headphone> headphones = List.of(airPods, airPodsPRO, earBuds, airDots, bits);

    @GetMapping(value = "/headphones")
    public List<Headphone> getHeadphones(@RequestParam(required = false) String price, @RequestParam(required = false) String anc)
    {
        if (price != null && anc != null){
            return headphones.stream().filter(headphone -> headphone.getPrice().equals(price) && headphone.getAnc().equals(anc)).collect(Collectors.toList());
        } else if (price != null){
            return headphones.stream().filter(headphone -> headphone.getPrice().equals(price)).collect(Collectors.toList());
        } else if (anc != null){
            return headphones.stream().filter(headphone -> headphone.getAnc().equals(anc)).collect(Collectors.toList());
        }
        return headphones;
    }

    @GetMapping(value = "/headphone/{id}")
    public Headphone getHeadphone(@PathVariable Long id)
    {
        for (Headphone headphone : headphones) {
            if (headphone.getId().equals(id)){
                return headphone;
            }
        }
        return null;
    }


    //todo theoretical assignment

    // F write pseudocode for saving a new pair of headphones (add annotations or http method names, urls, necessary parameters)
    // POST method with url /headphones/new and all required parameters except ID field
    // if all are fields valid:
    //      save the new pair to the database and return HTTP status 201
    // else:
    //      return HTTP error status

    // G write pseudocode for updating existing pair of headphones (add annotations or http method names, urls, necessary parameters)
    // HTTP method either PUT or PATCH with ID and fields to be updated
    // if all are fields valid:
    //      save the new pair to the database and return HTTP status 201
    // else:
    //      return HTTP error status

    // H write pseudocode for deleting a pair of headphones (add annotations or http method names, urls, necessary parameters)
    // HTTP DELETE method with ID or any other PRIMARY KEY
    // if user have permission to delete the headphones:
    //      delete the headphones
    // else:
    //      return HTTP error status
}
