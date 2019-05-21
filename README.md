# Jikan4java
Java api wrapper for Jikan api
Website for Jikan: https://jikan.moe/

To add to your project, head over to https://jitpack.io/#Doomsdayrs/Jikan4java and select the method you need to use!

**ALERT**: Connection classes are obsolete in the next version, do not use them.

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
[Here](https://github.com/Doomsdayrs/Jikan4java/blob/master/Documentation.md)

oh and remember i rarely test the methods~ 

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
