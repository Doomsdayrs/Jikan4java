#Documentation
For version 1.1.0
+ [Introduction]() 
+ Connection 
+ Going down the objects



##Introduction
So you want to use this wrapper? Well get ready, as it is as easy as 1 2 insert parameters. 
To get started, understand that i have never written one of these before. So good luck. 
Please also take note that this is a huge wrapper and i forget junk here and there. So enjoy errors every so often.

All returns from jikan are as CompletableFutures. So you can have async computing!

##How this wrapper works
There is a single class that communicates to jikan and back, this class is the [Retriever](https://github.com/Doomsdayrs/Jikan4java/blob/master/src/main/java/com/github/Doomsdayrs/Jikan4java/core/Retriever.java).
The class is the parent class of many objects within this wrapper, being the main driving force for parsing and communication. 
You can use this class to bypass the convenient pre-built objects to parse data. But do so at your own risk, as you need to make all the URLs yourself.

The Retriever class parents two main classes, the [Connector](https://github.com/Doomsdayrs/Jikan4java/blob/master/src/main/java/com/github/Doomsdayrs/Jikan4java/core/Connector.java) and
the [Search](https://github.com/Doomsdayrs/Jikan4java/blob/master/src/main/java/com/github/Doomsdayrs/Jikan4java/core/search/Search.java) classes. These allow you to easily retrieve data from jikan with mostly no worries.

###Connector class
If you peak at the code of the class [Connector](https://github.com/Doomsdayrs/Jikan4java/blob/master/src/main/java/com/github/Doomsdayrs/Jikan4java/core/Connector.java), you can see that this class takes care of most operations.

An example of usage is as following
```java
public class Main{
    public static void main(String[] args){
        //Option A
        new Connector().seasonLater().thenAccept(System.out::println);
       
        //OptionB
        CompletableFuture<SeasonSearch> seasonSearchCompletableFuture = new Connector().seasonLater();
        int a = 0;
        while (!seasonSearchCompletableFuture.isDone())a++;
        SeasonSearch seasonSearch = seasonSearchCompletableFuture.get();
    }
}
```
The above prints out the results of seasonLater search, it can also be used to assign variables with option B;

###Search objects
If you look into the code of [Search](https://github.com/Doomsdayrs/Jikan4java/blob/master/src/main/java/com/github/Doomsdayrs/Jikan4java/core/search/Search.java), you can see it is the parent object of multiple classes (go up the directory)

An example of usage would be the following
```java
public class Main{
    public static void main(String[] args){
        //Method A
      MangaSearch core = new MangaSearch().setQuery("boku");
              core.setLimit(2);
              core.addGenre(MangaGenres.ACTION);
              core.setStatus(Stati.COMPLETE);
      
              CompletableFuture completableFuture = core.get();
              while (!completableFuture.isDone()) {
                  a++;
              }
              System.out.println(completableFuture.get());
      
              TimeUnit.SECONDS.sleep(1);
      
              completableFuture = core.getFirst();
              while (!completableFuture.isDone()) {
                  a++;
              }
              System.out.println(completableFuture.get());
      //Method B
      
              Search<PersonPage> personPageSearch = new Search<>(Types.PERSON);
              personPageSearch.setQuery("shim").setLimit(5);
              CompletableFuture<PersonPage> completableFuture = personPageSearch.get();
              int a = 0;
              while (!completableFuture.isDone()) a++;
              System.out.println(completableFuture.get());
        
              completableFuture = personPageSearch.getFirst();
              while (!completableFuture.isDone()) a++;
              System.out.println(completableFuture.get());
                     
              CompletableFuture<Person> personCompletableFuture = personPageSearch.getByID(1);
              while (!personCompletableFuture.isDone()) a++;
              System.out.println(personCompletableFuture.get());
    }
}
```
* Method A uses a child object to retrieve a more complex querying of Manga; there is also a similar class for Anime.
* Method B uses the search class with appropriate parameters (PersonPage, MangaPage,CharacterPage,AnimePage) and a secondary Type reinforcements (if they are mismatched an ERROR is 100% likely to occur). Method A first searches for someone with a limit of 2, then it gets the first one, then it retrieves someone by their ID.

These are the basic things you should know, ask questions on the main discord server to the dev (me) Clocks.