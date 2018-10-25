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
    
        AnimeConnection animeConnection = new AnimeConnection();
        System.out.println(animeConnection.search("Another").toString());
        
    }
}
```

### Task list
- [X] Search and return Anime
- [ ] Search and return Manga
- [ ] Search and return Person
- [ ] Search and return Character
- [ ] Search and return Search results of all of above
