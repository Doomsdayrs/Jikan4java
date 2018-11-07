# Jikan4java
Java api wrapper for Jikan api
Website for Jikan: https://jikan.moe/

0.8 is the most updated version. With most functionality. 1.0 will have user objects, Complete documentation, and excessive comments.

## Capabilities
- Basic
  - [X] Search and return Anime
  - [X] Search and return Manga
  - [X] Search and return Person
  - [X] Search and return Character
- Search
  - [X] Search and return Search results of all of above
  - [X] Search and return GenreAnimeSearch
  - [X] Search and return GenreMangaSearch
  - [X] Search and return Season
  - [X] Search and return SeasonArchive
  - [X] Search and return Top list
  - [X] Search and return Producer
  - [X] Search and return Magazine
  - [ ] Search and return User >Critical Error preventing the completion at the current time
- Other 
  - [ ] Search and return Meta >Not till its formatted.


## Basic documentation

>How to use things, it's fairly basic. RN it's a find out by yourself since i haven't finished commenting
```java
import Jikan4java.types.Anime.AnimeConnection;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class ExampleClass {
public static void main(String[] args) throws IOException, ParseException {
    
        // Gets first search result
        System.out.println(new MangaConnection().search("Attack on titan").toString());
        System.out.println(new AnimeConnection().searchSimple("Attack on titan").toString());
        System.out.println(new CharacterConnection().search("Caster").toString());
        System.out.println(new PersonConnection().search("Hajime Isayama").toString());

        // Returns search results
        System.out.println(new AnimeConnection().searchPage("Attack on titan",1).toString());
        System.out.println(new MangaConnection().searchPage("Tensei",1));
        System.out.println(new CharacterConnection().searchPage("caster",1));
        System.out.println(new PersonConnection().searchPage("Hajime Isayama", 1));

        
        System.out.println(new GenreConnection().searchAnimeGenre(1,0).toString());
        System.out.println(new GenreConnection().searchMangaGenre(1,0).toString());

        System.out.println(new SeasonConnection().seasonSearch(2016,"winter").toString());
        System.out.println(new SeasonConnection().seasonArchiveSearch().toString());

        System.out.println(new ScheduleConnection().scheduleSearch().toString());
        System.out.println(new ScheduleConnection().scheduleSearch("monday").toString()); //`monday` can be replaced with any other day or unknown / other

        System.out.println(new TopConnection().topSearch("anime",0,"").toString());
        System.out.println(new TopConnection().topSearch("manga",0,"").toString());
        System.out.println(new TopConnection().topSearch("people",0,"").toString());
        System.out.println(new TopConnection().topSearch("characters",0,"").toString());
        
        System.out.println(new UserConnection().searchUser("kuglefang").toString()); 
        
        System.out.println(new MagazineConnection().search(11,1));
        System.out.println(new ProducerConnection().search(135,1));
        }
}
```

## Dependencies 
```xml
<dependencies>
        <dependency>
            <groupId>com.squareup.okhttp3</groupId>
            <artifactId>okhttp</artifactId>
            <version>3.11.0</version>
        </dependency>
        <!-- Json -->
        <dependency>
            <groupId>com.googlecode.json-simple</groupId>
            <artifactId>json-simple</artifactId>
            <version>1.1.1</version>
        </dependency>

        <dependency>
            <!-- Note: core-annotations version x.y.0 is generally compatible with
                 (identical to) version x.y.1, x.y.2, etc. -->
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.9.6</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.9.6</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.6</version>
        </dependency>
</dependencies>
```
