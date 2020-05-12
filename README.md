# Software Configuration Management #

## Exercise01: Testing ###

Our team members:
* [Martin Guevara-Kunerth](https://github.com/martin-gk)
* [Michael Lamprecht](https://github.com/lammia07)
* [Samuel Angerer](https://github.com/SamBrix)

The first exercise is about building a project in a team and testing it. For our 
build process we will use Maven and the tests will be written with JUnit 5. 
We will manage our source with git over github and we will develop with the 
help of IntelliJ IDEA.

## The Drinks Template ##

Original Template: [Drinks](https://github.com/michaelulm/software-configuration-management/tree/master/test-automation/junit5/Drinks)
This is the project we will be working on and the most important classes are:
 * class `Liquid`
 * abstract class `Drink` 
 
 The `Drink` class is composed of one or more `Liquids` and in the template, 
 there was already an implementation of the Drink class called `SimpleDrink` 
 which is only composed of one `Liquid` object and a name.



## Extensions ##
**Our goal for this project is to extend the existing template and to write unit tests.**  
The first extension will be the base `Drink` class with a getter method for the `name` field.  
The following classes will be added:

* [Cocktails](#cocktails)
* [Wine](#wine)
    
### Cocktails ###
The `Cocktail` class is an implementation of the abstract class `Drinks` and consists of more than one `Liquid`.  
The `Liquids` will be stored in an `ArrayList`.  
If the alcohol percentage exceeds more than 80% then the custom Exception `BlackoutException` will be thrown.  
The constructor will get a name String and a Collection of Liquids.  
The last extension will be an addLiquid method to add Liquids at a later time.

### Wine ###

The class `Wine` is an implementation of the abstract class `Drinks`.  
The `Liquids` will be stored in an `Array`.  
The constructor will get the name String, a `Liquid` and the boolean isSpritzer which will add the `Liquid` mineral water and the suffix Spritzer to the name.   

### Exemplary Code Snippet ###

As required for our homework we have added a code snippet that we find relevant.  
It's relevancy comes from the custom exception `BlackoutException` that is thrown if the alcohol content exceeds 80%. 
  
  ```java
    /**
     * Method allows to add liquids at a later time, throws BlackoutException if alcohol percentage is above 80%
     *
     * @param newLiquid Liquid to be added
     */
    public void addLiquid (Liquid newLiquid) throws BlackoutException{
        mixture.add(newLiquid);
        if (this.getAlcoholPercent() >= 80){
            throw new BlackoutException();
        }
    }
```
