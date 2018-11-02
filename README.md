# Jikan4java
Java api client for Jikan api
Website for Jikan: https://jikan.moe/

Currently this is in beta stages. Once I release version 1.0 it will be completely covering the Jikan api

## Capabilities
Look at task list for it's API coverage

### Basic documentation

>How to use things
```java
import Jikan4java.types.Anime.AnimeConnection;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class ExampleClass {
public static void main(String[] args) throws IOException, ParseException {
    
        System.out.println(new MangaConnection().search("Attack on titan").toString());

        System.out.println(new AnimeConnection().search("Attack on titan").toString);

        System.out.println(new CharacterConnection().search("Caster").toString());

        System.out.println(new PersonConnection().search("Hajime Isayama").toString());

        System.out.println(new BasicConnection().searchAnimeGenre(1,0).toString());

        System.out.println(new BasicConnection().searchMangaGenre(1,0).toString());

        System.out.println(new BasicConnection().seasonSearch(2016,"winter").toString());

        System.out.println(new BasicConnection().seasonArchiveSearch().toString());

        System.out.println(new BasicConnection().scheduleSearch().toString());

        System.out.println(new BasicConnection().scheduleSearch("monday")); //`monday` can be replaced with any other day or unknown / other
        
        System.out.println(new BasicConnection().topSearch("anime",0,"").toString());
        System.out.println(new BasicConnection().topSearch("manga",0,"").toString());
        System.out.println(new BasicConnection().topSearch("people",0,"").toString());
        System.out.println(new BasicConnection().topSearch("characters",0,"").toString());    
}
}
```

### Task list
- [X] Search and return Anime
- [X] Search and return Manga
- [X] Search and return Person
- [X] Search and return Character
- [X] Search and return GenreAnimeSearch
- [X] Search and return GenreMangaSearch
- [X] Search and return Season
- [X] Search and return SeasonArchive
- [X] Search and return Top list
- [ ] Search and return Producer
- [ ] Search and return Magazine
- [ ] Search and return User
- [ ] Search and return Meta
- [ ] Search and return Search results of all of above
- [X] Add 'related' objects

### Dependencies 
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