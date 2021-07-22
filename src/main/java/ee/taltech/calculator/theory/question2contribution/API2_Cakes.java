package ee.taltech.calculator.theory.question2contribution;

import ee.taltech.calculator.theory.question2contribution.classes.Cake;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
public class API2_Cakes {

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
    // Management wants to define an API endpoint so frontend can display data about cakes (think cake e-shop)
    // A Add necessary annotations to this class so this class can serve data
    // B Add a method to query all the cakes (method content is not important - I am grading urls, annotations, names, and parameters)
    // C Add a method to query a single cake by it's unique identifier (method content is not important - I am grading urls, annotations, names, and parameters)
    // D Modify an existing method to query/filter cakes by weight while keeping existing functionality
    // E Modify an existing method to query/filter cakes by name while keeping existing functionality

    Cake strawberryCake = new Cake(1L, "strawberry", "high", "medium", "1000", "8");
    Cake orangeCake = new Cake(2L, "orange", "low", "big", "1500", "5");
    Cake chocolateCake = new Cake(3L, "chocolate", "high", "medium", "750", "10");
    Cake cheeseCake = new Cake(4L, "cheese", "medium", "small", "1500", "7");
    Cake cinnamonCake = new Cake(5L, "cinnamon", "medium", "small", "500", "10");
    Cake vanillaCake = new Cake(6L, "vanilla", "high", "big", "2000", "7");
    Cake appleCake = new Cake(7L, "apple", "low", "medium", "1000", "8");

    List<Cake> cakes = List.of(strawberryCake, orangeCake, chocolateCake, cheeseCake, cinnamonCake, vanillaCake, appleCake);

    @GetMapping(value = "/getCakes")
    public List<Cake> getCakes(@RequestParam(required = false) String name, @RequestParam(required = false) String weight)
    {
        if(name == null && weight == null){ return cakes; }
        return cakes.stream().filter(cake -> cake.getName().equals(name == null ? "" : name.toLowerCase())
                || cake.getWeight().equals(weight == null ? "" : weight)).collect(Collectors.toList());
    }

    @GetMapping(value = "/getCake/{id}")
    public Cake getCakeById(@PathVariable Long id)
    {
        return cakes.stream().filter(cake -> cake.getId() == id).findFirst().orElse(null);
    }

    //todo theoretical assignment
    // F write pseudocode for saving a new cake (add annotations or http method names, urls, necessary parameters)
    //@GetMapping(valueOfUrl = "/addCake")
    //public String addCake(@RequestParam [id(required = false), name, sweetness, size, weight, rating ])
    //  if any input variables, except id, are null then
    //      return "Invalid arguments have been provided";
    //  Cake newCake = new Cake();
    //  if id is not provided then
    //      stream cakeList to find the maximum id number and save it to variable maxId, if not found return null
    //      if maxId is null then
    //          newCake.setId to 1
    //      else
    //          newCake.setId to maxId+1
    //  set newCake.setName to LowerCased name string
    //  set newCake.setSweetness to LowerCased sweetness string
    //  set newCake.setSize to LowerCased size string
    //  set newCake.Weight to weight string
    //  set newCake.setRating to rating string
    //  cakes.add(newCake);
    //  return "A new cake has been successfully added"
    //
    // G write pseudocode for updating existing cake (add annotations or http method names, urls, necessary parameters)
    //@GetMapping(valueOfUrl = "/updateCake")
    //public String updateCake(@RequestParam [id(required = true), name(required = false), sweetness(required = false), weight(required = false), rating(required = false)])
    //  if id is null then
    //      return "Enter an ID of cake to be updated";
    //  Stream cakeList with filter that matches two identical IDs and find first found Cake value and save it to foundCake variable of Cake class, if not found save null
    //  if foundCake is not null then
    //      return "No cake with provided ID has been found and no updates were applied";
    //  if string name is not null then
    //      set newCake.setName to LowerCased name string
    //  if string sweetness is not null then
    //      set newCake.setSweetness to LowerCased sweetness string
    //  if string size is not null then
    //      set newCake.setSize to size string
    //  if string weight is not null then
    //      set newCake.setWeight to weight string
    //  if string rating is not null then
    //      set newCake.setRating to rating string
    //  return "A cake has been successfully updated"
    // H write pseudocode for deleting a cake (add annotations or http method names, urls, necessary parameters)
    //@GetMapping(valueOfUrl = "/deleteCake")
    //public String deleteCake(@RequestParam id(required = true))
    //  if id is null then
    //      return "Enter an ID of cake to be deleted";
    //  Stream cakeList with filter that matches two identical IDs and find first found Cake value and save it to foundCake variable of Cake class, if not found save null
    //  cakes.remove(cakeList.indexOf(foundCake))
    //  return "A cake has been successfully deleted"
}
