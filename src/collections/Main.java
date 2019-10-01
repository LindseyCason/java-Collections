package collections;

import java.util.*;

import java.lang.ProcessBuilder.Redirect.Type;

public class Main
{
    public static void main(String[] args)
    {
        //fixed index
        //0 -> 1st element
        //1 -> 2nd element etc.
        // Fixed element Type
        // Fixed length
        System.out.println("****ARRAYS****");
        // Dogs dogArr[];
        // dogArr = new Dogs[5]; //<-- initializing, elements 0-5, must indicate amount of elements.
        Dogs[] dogArr = new Dogs[5]; //this is the shortcut to the code above
        dogArr[0] = new Dogs("Springer", 50, false);
        dogArr[4] = new Dogs("Corgi", 35, true);
        dogArr[1] = new Dogs("Bulldog", 50, true);
        dogArr[2] = new Dogs("Collie", 50, false);
        dogArr[3] = new Dogs("Chihuahua", 5, true);
        // dogArr[5] = new Dogs("Mutt", 15, true); This returns out of bounds for index because there is only 5 spaces available for memory and element[5] is the 6th.

        for (int i = 0; i < dogArr.length; i++)
        {
            System.out.println(dogArr[i]);
        }
        System.out.println("Breed Sub 3 good for an apartment? " + dogArr[3].isApartment()); //this is how to access the information. ArrayName[element].invokedMethod().
        System.out.println("\n print out arrays");
        System.out.println(dogArr.toString()); //this just prints the memory location pointer here//this is an object method
        System.out.println(Arrays.toString(dogArr));//this is a class method

        //fixed element type
        //varied length
        //most commonly used, especially in java spring
        //Everything starts as an Object -> Collections -> List -> ArrayList
        System.out.println("****ARRAY LIST****");
        ArrayList<Dogs> dogsArrayList = new ArrayList<Dogs>();
        dogsArrayList.addAll(Arrays.asList(dogArr));

        dogsArrayList.add(new Dogs("Mutt", 15, true));//this will add to the bottom of the list and will remain in order of how we added them.

        //PRINT OUT WITH BRANCHING
        for(Dogs element : dogsArrayList){
            System.out.println(element);
        }

        System.out.println();

         //PRINTING OUT ARRAY LIST
        for (Dogs element : dogsArrayList){
            //element can be anything, convention is d which is the lower case of the thing we're looking at "Dogs"
            if(element.getAvgWeight() >= 50){
                System.out.println(element.getBreed() + " are large");
            }else{
                System.out.println(element.getBreed() + " are small");
            }
        }

        //COMPARING STRINGS
        // When you're checking and comparing strings....
        // if ("a" == "b"){
        //     // This will not work!
        //     //if you want to compare strings you have to use .equals (as seen below)
        // };


        if(dogsArrayList.get(2).getBreed().equals("Turtle"))
        {
            System.out.println("Equals");
        }else{
            System.out.println("Not Equal to a Turtle");
        }
        System.out.println();

        //ADDING ELEMENTS
        dogsArrayList.add(2, new Dogs("Labrador", 75, false));
        dogsArrayList.forEach(element -> System.out.println(element));
        //This will put Labrador in the [2] location and shift everything else down.
        System.out.println();

        dogsArrayList.set(2, new Dogs("Poodle", 50, false));
        dogsArrayList.forEach(element -> System.out.println(element));
        //This will REPLACE what is in the location[2] and keep all other elements in place.
        System.out.println();

        System.out.println("Size " + dogsArrayList.size()); //***** .size for array list instead of length as array
        System.out.println(dogsArrayList.get(3)); //this prints dog at [3]
        dogsArrayList.remove(3); //This removes the dog at [3] and shifts everything up.
        System.out.println(dogsArrayList.get(3)); //Seeing what's at [3] when dog three is removed.

        System.out.println();



        //varied length
        //choice in index -> you can pick but it's fixed after that.
        //fixed element type after picking
        System.out.println("****HASHMAPS****");
        HashMap<Integer, Dogs> dogsHashMap = new HashMap<Integer, Dogs>();//every HashMap takes in two classes. A type and a value. The integer is the "key" and value is "value".

        int hashcount = 0;
        for (Dogs element : dogsArrayList){
            //PUT IS HOW YOU PUT DATA INTO A HASHMAP
            //If the key does not exist, add it to the hashmap.
            //if the key DOES exist, it will REPLACE it with the new put "value".
            dogsHashMap.put(hashcount, element);
            hashcount++;
        }
        dogsArrayList.clear();//This will clear the memory from the arrayList
        System.out.println(dogsHashMap.get(3)); //This will find and print out the value of the key of 3.
        System.out.print(dogsHashMap.size());
        dogsHashMap.remove(3);
        System.out.println(dogsHashMap.get(3));//This will return null after ^^

        for(Integer i : dogsHashMap.keySet()){
            System.out.println("key: " + i + " value: " + dogsHashMap.get(i));
        }
        System.out.println();


        //Sorting a Hashmap, it cannot be sorted but we can convert to Array List. Every element in a HashMap is an Entry. Then it takes a KV pair from your HashMap
        ArrayList<HashMap.Entry<Integer, Dogs>> sortedMap = new ArrayList<HashMap.Entry<Integer, Dogs>>();
        sortedMap.addAll(dogsHashMap.entrySet());
        //this method called sort takes two params. The array list you want to sort + and object of type "Comparator"
        Collections.sort(sortedMap, new Comparator<HashMap.Entry<Integer, Dogs>>()
        {
            public int compare(HashMap.Entry<Integer, Dogs> o1, HashMap.Entry<Integer, Dogs> o2){
                return o1.getValue().getBreed().compareToIgnoreCase(o2.getValue().getBreed());
                //This will sort from alphabetical 
                // return o2.getValue().getAvgWeight() - o1.getValue().getAvgWeight();
            }
        });

        for (HashMap.Entry<Integer, Dogs> element : sortedMap)
        {
            System.out.println("key: " + element.getKey() + " value: " + element.getValue());
        }
        System.out.println();
        
    }
}