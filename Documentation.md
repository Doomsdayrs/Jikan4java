#Documentation

+ [Introduction]() 
+ Connection 
+ Going down the objects



##Introduction
So you want to use this wrapper? Well get ready, as it is as easy as ```.search(""")```. 

to get started, understand that i have never written one of these before. So good luck. 

##Connection 
The base of this wrapper is the connection classes. These classes make up the primary way to connect to the API. 
And have no built in method to prevent overloading the API. So that's on you to code. 

[Here](./src/main/java/com/github/Doomsdayrs/Jikan4java/connection) are the wonderful connection classes! 

They all should run fairly the same. For example, AnimeConnection. 
```java
import com.github.Doomsdayrs.Jikan4java.*;
class Example
{
	public static void main(String[] args){
	  AnimeConnection animeConnection = new AnimeConnection();
	  animeConnection.searchAnimeById(1).thenAccept(System.out::println);
	  //Then accept means, once the anime object is done. Do this action, in this case. It is to print it out. Below is a way to print out something else
	  TimeUnit.SECONDS.sleep(1);
	  
	  animeConnection.searchAnimeById(1).thenAccept(anime -> {
	      System.out.println(anime.name);
	      // then the rest of your junk ya wanna do with this
	  });
	}
}
```

The above creates a new AnimeConnection object, uses the .searchSimple method to retrieve an anime object. Then the .toString() method turns it into a string! Quite easy isn't it? ~~Was not easy to program it tho~~ 

##Going down the objects
Now that you know the basic class! Enjoy figuring your way through the 15k lines of code that i typed. 
