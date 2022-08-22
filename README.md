# javashiki
Implementation shikimori api (https://shikimori.one/api/doc) for Java.

## Dependency
To use this library youu need to add current repository to your project (example in maven):
```xml
<dependencies>
  <dependency>
    <groupId>com.yauhescha</groupId>
    <artifactId>javashiki</artifactId>
    <version>1.1.0</version>
  </dependency>
</dependencies>
```


Also you need to add library in dependencies:
```xml
<repositories>
  <repository>
    <id>javashiki-mvn-repo</id>
    <url>https://raw.github.com/Yauhescha/javashiki/mvn-repo/</url>
    <snapshots>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
    </snapshots>
  </repository>
</repositories>
```

## Important dependency
If you want to receive access to shikimori api directly without preporation, you have to download chromedriver for selenium (to have opportunity get authorization code) from https://chromedriver.chromium.org/downloads. 
After downloading put .exe file in rool of your application.
So after starting application
```java
AuthShikimori authShikimori = new AuthShikimori();
```
You will be moved to shikimori authorization page, where you must authorize your application so you could receive an authorization token and get authorization code:

![image](https://user-images.githubusercontent.com/68643078/185960862-a74f315d-f07e-4f5e-a4fd-870d00243944.png)


Copy-paste this code to console:

![image](https://user-images.githubusercontent.com/68643078/185961002-8ecda222-ca70-4a33-a47d-16a7013002da.png)

After that token was saved for one day.


If you don't want to download any additional thinks, use AuthShikimori constructor with parameter authorizationCode and put this code directly.
```java
String authorizationCode = "7tzXM2qVJ_E186sswspcH-M4K2C11GFOl8G-ppdxNXY;
AuthShikimori auth = new AuthShikimori(authorizationCode);
```

## Example

```java
AuthShikimori authShikimori = new AuthShikimori();
AnimeApi animeApi = authShikimori.getAnimeApi();

AnimeSearchParameters parameters = AnimeSearchParameters
        .builder()
        .limit(5)
        .search("naruto")
        .build();

List<Anime> animes = animeApi.getAnimes(parameters);
animes.forEach(anime -> System.out.println("Anime with name '" + anime.getName() + "' has '" + anime.getEpisodes() + "' episodes"));
```
