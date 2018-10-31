# Jikan4java
Java api client for Jikan api
Website for Jikan: https://jikan.moe/

## Capabilities
So far can search Anime by it's name

### Basic documentation

>How to search shiz up
```java
import Jikan4java.types.Anime.AnimeConnection;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class ExampleClass {
public static void main(String[] args) throws IOException, ParseException {
    
        System.out.println(new MangaConnection().search("Attack on titan").toString());

        System.out.println(new AnimeConnection().search("Caster").toString());

        System.out.println(new CharacterConnection().search("Attack on titan").toString());

        System.out.println(new PersonConnection().search("Hajime Isayama").toString());
    }
}
```

### Task list
- [X] Search and return Anime
- [X] Search and return Manga
- [X] Search and return Person
- [X] Search and return Character
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