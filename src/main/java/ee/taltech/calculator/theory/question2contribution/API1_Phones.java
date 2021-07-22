package ee.taltech.calculator.theory.question2contribution;

import ee.taltech.calculator.theory.question2contribution.classes.Phone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class API1_Phones {

    // todo this is contribution question
    //  this assignment is only for one team member (if this code is not committed by that team member how do I know this code was theirs?)

    // todo
    //  this assignment consists of 2 parts
    //  practical assignment A, B, C, D, E
    //     * All classes are available in classes package
    //     * If you want to test these practical assignments add these to your project.
    //       Example: If you Application.java is in the package ee.taltech, make sure theory is in package ee.taltech as well (ee.taltech.theory)
    //  theoretical assignment F, G, H

    //todo practical assignment
    // Management wants to define an API endpoint so frontend can display data about phones (think phone e-shop)
    // A Add necessary annotations to this class so this class can serve data
    // B Add a method to query all the phones (method content is not important - I am grading urls, annotations, names, and parameters)
    // C Add a method to query a single phone by it's unique identifier (method content is not important - I am grading urls, annotations, names, and parameters)
    // D Modify an existing method to query/filter phones by manufacturer while keeping existing functionality
    // E Modify an existing method to query/filter phones by release year while keeping existing functionality

    Phone phone1 = new Phone(12L, "apple", "X", "90", "2018");
    Phone phone2 = new Phone(25L, "samsung", "S21", "92", "2021");
    Phone phone3 = new Phone(14L, "xiaomi", "Mi9", "95", "2019");
    Phone phone4 = new Phone(6L, "oneplus", "9T", "85", "2017");
    Phone phone5 = new Phone(30L, "oppo", "S10", "75", "2017");

    List<Phone> phoneList = List.of(phone1, phone2, phone3, phone4, phone5);

    @GetMapping(value = "/phones")
    public List<Phone> getPhones(@RequestParam(required = false) String year, @RequestParam(required = false) String manufacturer) {
        if(year == null && manufacturer == null){return phoneList;}
        return phoneList.stream().filter(x -> x.getReleaseYear().equals(year) ||
                x.getManufacturer().toLowerCase().equals(manufacturer == null ? "" : manufacturer.toLowerCase())).collect(Collectors.toList());
    }

    @GetMapping(value = "/phone")
    public Phone phoneById(@RequestParam int id) {
        return phoneList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    //todo theoretical assignment
    // F write pseudocode for saving a new phone (add annotations or http method names, urls, necessary parameters)
    //@GetMapping(valueOfUrl = "/add")
    //public String addPhone(@RequestParam [id(optional), manufacturer, modelNr, rating, releaseYear])
    //  if any input variables, except id, are null then
    //      return "Invalid arguments have been provided";
    //  Phone newPhone = new Phone();
    //  if id is not provided then
    //      stream phoneList to find the maximum id number and save it to variable maxId, if not found return null
    //      if maxId is null then
    //          set newPhone.setId to 1
    //      else
    //          set newPhone.setId to maxId+1
    //  set newPhone.setManufacturer to LowerCased manufacturer string
    //  set newPhone.setModelNr to modelNr string
    //  set newPhone.setRating to rating string
    //  set newPhone.setReleaseYear to releaseYear string
    //  phoneList.add(newPhone);
    //  return "A new phone has successfully been added"
    //
    // G write pseudocode for updating existing phone (add annotations or http method names, urls, necessary parameters)
    //@GetMapping(valueOfUrl = "/update")
    //public String addPhone(@RequestParam [id(required), manufacturer(optional), modelNr(optional), rating(optional), releaseYear(optional)])
    //  if id is null then
    //      return "Please, provide an ID of phone to be updated";
    //  Stream phoneList with filter that matches two identical IDs and find first found Phone value and save it to foundPhone variable of Phone class, if not found save null
    //  if foundPhone is not null then
    //      return "No phone with provided ID has been found and no updates were applied";
    //  if manufacturer string is not null then
    //      set newPhone.setManufacturer to LowerCased manufacturer string
    //  if modelNr string is not null then
    //      set newPhone.setModelNr to modelNr string
    //  if Rating string is not null then
    //      set newPhone.setRating to rating string
    //  if ReleaseYear string is not null then
    //      set newPhone.setReleaseYear to releaseYear string
    //  return "A phone has successfully been updated"
    // H write pseudocode for deleting a phone (add annotations or http method names, urls, necessary parameters)
    //@GetMapping(valueOfUrl = "/delete")
    //public String addPhone(@RequestParam id(required))
    //  if id is null then
    //      return "Please, provide an ID of phone to be deleted";
    //  Stream phoneList with filter that matches two identical IDs and find first found Phone value and save it to foundPhone variable of Phone class, if not found save null
    //  phoneList.remove(phoneList.indexOf(foundPhone))
    //  return "A phone has successfully been deleted"
}
