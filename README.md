# Jikan4java
Java api wrapper for Jikan api
Website for Jikan: https://jikan.moe/

To add to your project, head over to https://jitpack.io/#Doomsdayrs/Jikan4java and select the method you need to use!
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
  - [X] Clubs

## Basic documentation

>How to use things, it's fairly basic. RN it's a find out by yourself since i haven't finished commenting
```java
import Jikan4java.types.Anime.AnimeConnection;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class ExampleClass {
public static void main(String[] args) {
  AnimeConnection animeConnection = new AnimeConnection();
        CharacterConnection characterConnection = new CharacterConnection();
        ClubConnection clubConnection = new ClubConnection();
        GenreConnection genreConnection = new GenreConnection();
        MagazineConnection magazineConnection = new MagazineConnection();
        MangaConnection mangaConnection = new MangaConnection();
        MetaConnection metaConnection = new MetaConnection();
        PersonConnection personConnection = new PersonConnection();
        ProducerConnection producerConnection = new ProducerConnection();
        ScheduleConnection scheduleConnection = new ScheduleConnection();
        SeasonConnection seasonConnection = new SeasonConnection();
        TopConnection topConnection = new TopConnection();
        UserConnection userConnection = new UserConnection();

        int a = 0;

        CompletableFuture<Anime> animeCompletableFuture = animeConnection.searchAnimeById(1);
        if (animeCompletableFuture != null) {
            while (!animeCompletableFuture.isDone()) a++;
            System.out.println(animeCompletableFuture.get());
        }

        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<CharacterPage> characterCompletableFuture = characterConnection.searchPage("re", 1);
        if (characterCompletableFuture != null) {
            while (!characterCompletableFuture.isDone()) a++;
            System.out.println(characterCompletableFuture.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<Club> clubCompletableFuture = clubConnection.search(12);
        if (clubCompletableFuture != null) {
            while (!clubCompletableFuture.isDone()) a++;
            System.out.println(clubCompletableFuture.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<GenreSearchAnimePage> searchAnimeGenre = genreConnection.searchAnimeGenre(AnimeGenres.ACTION);
        if (searchAnimeGenre != null) {
            while (!searchAnimeGenre.isDone()) a++;
            System.out.println(searchAnimeGenre.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<GenreSearchMangaPage> searchMangaGenre = genreConnection.searchMangaGenre(MangaGenres.ACTION);
        if (searchMangaGenre != null) {
            while (!searchMangaGenre.isDone()) a++;
            System.out.println(searchMangaGenre.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<MagazinePage> magazinePageCompletableFuture = magazineConnection.searchPage(1, 1);
        if (magazinePageCompletableFuture != null) {
            while (!magazinePageCompletableFuture.isDone()) a++;
            System.out.println(magazinePageCompletableFuture.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<Manga> mangaCompletableFuture = mangaConnection.search("Ajin");
        if (mangaCompletableFuture != null) {
            while (!mangaCompletableFuture.isDone()) a++;
            System.out.println(mangaCompletableFuture.get());
        }
        TimeUnit.SECONDS.sleep(1);
        CompletableFuture<Status> statusCompletableFuture = metaConnection.getStatus();
        if (statusCompletableFuture != null) {
            while (!statusCompletableFuture.isDone()) a++;
            System.out.println(statusCompletableFuture.get());
        }

        // Well, after this point you should get an idea, use code completion or decompile the classes to see what are methods available;
               
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
                <version>2.9.8</version>
            </dependency>
            <dependency>
                <groupId>com.fasterxml.jackson.core</groupId>
                <artifactId>jackson-core</artifactId>
                <version>2.9.8</version>
            </dependency>
            <dependency>
                <groupId>com.fasterxml.jackson.core</groupId>
                <artifactId>jackson-databind</artifactId>
                <version>2.9.8</version>
            </dependency>
    </dependencies>
    ```
- Gradle
    ```groovy
      dependencies {
          compile group: 'com.squareup.okhttp3', name: 'okhttp', version:'3.11.0'
          compile group: 'com.fasterxml.jackson.core', name: 'jackson-annotations', version:'2.9.8'
          compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version:'2.9.8'
          compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version:'2.9.8'
          compile group: 'com.googlecode.json-simple', name: 'json-simple', version:'1.1.1'
      }
    ```
