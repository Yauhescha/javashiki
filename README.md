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


If you don't want to download any additional things, use AuthShikimori constructor with parameter authorizationCode and put this code directly.
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

## Implemented methods from Shikimori API

### Achievements

* [x] GET /api/achievements

### Animes
* [x] GET /api/animes
* [x] GET /api/animes/:id
* [x] GET /api/animes/:id/roles
* [x] GET /api/animes/:id/similar
* [x] GET /api/animes/:id/related
* [x] GET /api/animes/:id/screenshots
* [x] GET /api/animes/:id/videos DEPRECATED
* [x] GET /api/animes/:id/franchise
* [x] GET /api/animes/:id/external_links
* [x] GET /api/animes/search DEPRECATED
* [x] GET /api/animes/:id/topics

### Appear
* [x] POST /api/appears

### Bans
* [ ] GET /api/bans

### Calendars
* [ ] GET /api/calendar

### Characters
* [ ] GET /api/characters/:id
* [ ] GET /api/characters/search

### Clubs
* [ ] GET /api/clubs
* [ ] PATCH /api/clubs/:id
* [ ] PUT /api/clubs/:id
* [ ] GET /api/clubs/:id
* [ ] GET /api/clubs/:id/animes
* [ ] GET /api/clubs/:id/mangas
* [ ] GET /api/clubs/:id/ranobe
* [ ] GET /api/clubs/:id/characters
* [ ] GET /api/clubs/:id/members
* [ ] GET /api/clubs/:id/images
* [ ] POST /api/clubs/:id/join
* [ ] POST /api/clubs/:id/leave

### Comments
* [ ] GET /api/comments/:id
* [ ] GET /api/comments
* [ ] POST /api/comments
* [ ] PATCH /api/comments/:id
* [ ] PUT /api/comments/:id
* [ ] DELETE /api/comments/:id

### Constants
* [ ] GET /api/constants/anime
* [ ] GET /api/constants/manga
* [ ] GET /api/constants/user_rate
* [ ] GET /api/constants/club
* [ ] GET /api/constants/smileys

### Dialogs
* [ ] GET /api/dialogs
* [ ] GET /api/dialogs/:id
* [ ] DELETE /api/dialogs/:id

### Favorites
* [ ] POST /api/favorites/:linked_type/:linked_id(/:kind)
* [ ] DELETE /api/favorites/:linked_type/:linked_id
* [ ] POST /api/favorites/:id/reorder

### Forums
* [ ] GET /api/forums

### Friends
* [ ] POST /api/friends/:id
DELETE /api/friends/:id

### Genres
* [ ] GET /api/genres

### Ignores
* [ ] POST /api/ignores/:id DEPRECATED
* [ ] DELETE /api/ignores/:id DEPRECATED

### Mangas
* [ ] GET /api/mangas
* [ ] GET /api/mangas/:id
* [ ] GET /api/mangas/:id/roles
* [ ] GET /api/mangas/:id/similar
* [ ] GET /api/mangas/:id/related
* [ ] GET /api/mangas/:id/franchise
* [ ] GET /api/mangas/:id/external_links
* [ ] GET /api/mangas/search DEPRECATED
* [ ] GET /api/mangas/:id/topics

### Messages
* [ ] GET /api/messages/:id
* [ ] POST /api/messages
* [ ] PATCH /api/messages/:id
* [ ] PUT /api/messages/:id
* [ ] DELETE /api/messages/:id
* [ ] POST /api/messages/mark_read
* [ ] POST /api/messages/read_all
* [ ] POST /api/messages/delete_all

### People
* [ ] GET /api/people/:id
* [ ] GET /api/people/search

### Publishers
* [ ] GET /api/publishers

### Ranobe
* [ ] GET /api/ranobe
* [ ] GET /api/ranobe/:id
* [ ] GET /api/ranobe/:id/roles
* [ ] GET /api/ranobe/:id/similar
* [ ] GET /api/ranobe/:id/related
* [ ] GET /api/ranobe/:id/franchise
* [ ] GET /api/ranobe/:id/external_links
* [ ] GET /api/ranobe/:id/topics

### Stats
* [ ] GET /api/stats/active_users

### Studios
* [ ] GET /api/studios

### Styles
* [ ] GET /api/styles/:id
* [ ] POST /api/styles/preview
* [ ] POST /api/styles
* [ ] PATCH /api/styles/:id
* [ ] PUT /api/styles/:id

### Topic ignores
* [ ] POST /api/topic_ignores DEPRECATED
* [ ] DELETE /api/topic_ignores/:id DEPRECATED

### Topics
* [ ] GET /api/topics
* [ ] GET /api/topics/updates
* [ ] GET /api/topics/hot
* [ ] GET /api/topics/:id
* [ ] POST /api/topics
* [ ] PATCH /api/topics/:id
* [ ] PUT /api/topics/:id
* [ ] DELETE /api/topics/:id

### User images
* [ ] POST /api/user_images

### User rates
* [ ] GET /api/user_rates/:id DEPRECATED
* [ ] POST /api/user_rates DEPRECATED
* [ ] PATCH /api/user_rates/:id DEPRECATED
* [ ] PUT /api/user_rates/:id DEPRECATED
* [ ] POST /api/user_rates/:id/increment DEPRECATED
* [ ] DELETE /api/user_rates/:id DEPRECATED
* [ ] DELETE /api/user_rates/:type/cleanup
* [ ] DELETE /api/user_rates/:type/reset

### Users
* [ ] GET /api/users
* [ ] GET /api/users/:id
* [ ] GET /api/users/:id/info
* [ ] GET /api/users/whoami
* [ ] GET /api/users/sign_out
* [ ] GET /api/users/:id/friends
* [ ] GET /api/users/:id/clubs
* [ ] GET /api/users/:id/anime_rates
* [ ] GET /api/users/:id/manga_rates
* [ ] GET /api/users/:id/favourites
* [ ] GET /api/users/:id/messages
* [ ] GET /api/users/:id/unread_messages
* [ ] GET /api/users/:id/history
* [ ] GET /api/users/:id/bans

### Videos
* [ ] GET /api/animes/:anime_id/videos
* [ ] POST /api/animes/:anime_id/videos
* [ ] DELETE /api/animes/:anime_id/videos/:id
