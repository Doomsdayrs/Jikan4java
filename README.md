# Jikan4java
Java api wrapper for Jikan api
Website for Jikan: https://jikan.moe/

0.9 is the most updated version. With most functionality. 1.0 Complete documentation, and excessive comments.

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
  - [X] Search and return User
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
        
        System.out.println(new UserConnection().searchUser("AreChan").toString()); 
        
        System.out.println(new MagazineConnection().search(11,1));
        System.out.println(new ProducerConnection().search(135,1));
        }
}
```
## Known issues
- API issue of user object being returned as an array list when empty. Future update of api will let me return Related fields back to normal
## What it relies on 
- Maven
    ```xml
    <dependencies>
            <dependency>
                <groupId>com.squareup.okhttp3</groupId>
                <artifactId>okhttp</artifactId>
                <version>3.11.0</version>
            </dependency>
            <dependency>
                <groupId>com.googlecode.json-simple</groupId>
                <artifactId>json-simple</artifactId>
                <version>1.1.1</version>
            </dependency>
          
            <dependency>
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
- Gradle
    ```groovy
      dependencies {
          compile group: 'com.squareup.okhttp3', name: 'okhttp', version:'3.11.0'
          compile group: 'com.fasterxml.jackson.core', name: 'jackson-annotations', version:'2.9.7'
          compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version:'2.9.7'
          compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version:'2.9.7'
          compile group: 'com.googlecode.json-simple', name: 'json-simple', version:'1.1.1'
      }
    ```
