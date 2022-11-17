# javashiki
Implementation shikimori api (https://shikimori.one/api/doc) for Java.

## Dependency
To use this library you need to add current repository to your project (example in maven):
```xml
<dependencies>
  <dependency>
    <groupId>com.yauhescha</groupId>
    <artifactId>javashiki</artifactId>
    <version>2.2.0</version>
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

## Example

```java
AuthShikimori auth = new AuthShikimori(applicationName, applicationClientId, applicationClientSecret, applicationRedirectUri);
// or = new AuthShikimori(); to use Api Test application
String linkToAuthorizationCode = auth.getUrlToAuthorizationCode(); // use this to get authorization code
auth.authorize(scanner.nextLine());

UserInfo userInfo = auth.getUserApi().whoIAm();
System.out.printf(userInfo.toString());


AnimeApi animeApi = auth.getAnimeApi();
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

### Appear
* [x] POST /api/appears

### Animes
* [x] GET /api/animes
* [x] GET /api/animes/:id
* [x] GET /api/animes/:id/roles
* [x] GET /api/animes/:id/similar
* [x] GET /api/animes/:id/related
* [x] GET /api/animes/:id/screenshots
* [x] GET /api/animes/:id/franchise
* [x] GET /api/animes/:id/external_links
* [x] GET /api/animes/:id/topics

### Bans
* [x] GET /api/bans

### Calendars
* [x] GET /api/calendar

### Characters
* [x] GET /api/characters/:id
* [x] GET /api/characters/search

### Constants
* [x] GET /api/constants/anime
* [x] GET /api/constants/manga
* [x] GET /api/constants/user_rate
* [x] GET /api/constants/club
* [x] GET /api/constants/smileys

### Genres
* [x] GET /api/genres

### Forums
* [x] GET /api/forums

### Stats
* [x] GET /api/stats/active_users

### Studios
* [x] GET /api/studios

### Publishers
* [x] GET /api/publishers

### User images
* [x] POST /api/user_images

### People
* [x] GET /api/people/:id
* [x] GET /api/people/search

### Mangas
* [x] GET /api/mangas
* [x] GET /api/mangas/:id
* [x] GET /api/mangas/:id/roles
* [x] GET /api/mangas/:id/similar
* [x] GET /api/mangas/:id/related
* [x] GET /api/mangas/:id/franchise
* [x] GET /api/mangas/:id/external_links
* [x] GET /api/mangas/:id/topics

### Users
* [x] GET /api/users
* [x] GET /api/users/:id
* [x] GET /api/users/:id/info
* [x] GET /api/users/whoami
* [ ] GET /api/users/sign_out
* [x] GET /api/users/:id/friends
* [x] GET /api/users/:id/clubs
* [x] GET /api/users/:id/anime_rates
* [x] GET /api/users/:id/manga_rates
* [x] GET /api/users/:id/favourites
* [ ] GET /api/users/:id/messages
* [x] GET /api/users/:id/unread_messages
* [x] GET /api/users/:id/history
* [x] GET /api/users/:id/bans



## NOT Implemented methods from Shikimori API yet

### User rates
* [ ] DELETE /api/user_rates/:type/cleanup
* [ ] DELETE /api/user_rates/:type/reset

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

### Dialogs
* [ ] GET /api/dialogs
* [ ] GET /api/dialogs/:id
* [ ] DELETE /api/dialogs/:id

### Favorites
* [ ] POST /api/favorites/:linked_type/:linked_id(/:kind)
* [ ] DELETE /api/favorites/:linked_type/:linked_id
* [ ] POST /api/favorites/:id/reorder

### Friends
* [ ] POST /api/friends/:id
* [ ] DELETE /api/friends/:id

### Messages
* [ ] GET /api/messages/:id
* [ ] POST /api/messages
* [ ] PATCH /api/messages/:id
* [ ] PUT /api/messages/:id
* [ ] DELETE /api/messages/:id
* [ ] POST /api/messages/mark_read
* [ ] POST /api/messages/read_all
* [ ] POST /api/messages/delete_all

### Ranobe
* [ ] GET /api/ranobe
* [ ] GET /api/ranobe/:id
* [ ] GET /api/ranobe/:id/roles
* [ ] GET /api/ranobe/:id/similar
* [ ] GET /api/ranobe/:id/related
* [ ] GET /api/ranobe/:id/franchise
* [ ] GET /api/ranobe/:id/external_links
* [ ] GET /api/ranobe/:id/topics

### Styles
* [ ] GET /api/styles/:id
* [ ] POST /api/styles/preview
* [ ] POST /api/styles
* [ ] PATCH /api/styles/:id
* [ ] PUT /api/styles/:id

### Topics
* [ ] GET /api/topics
* [ ] GET /api/topics/updates
* [ ] GET /api/topics/hot
* [ ] GET /api/topics/:id
* [ ] POST /api/topics
* [ ] PATCH /api/topics/:id
* [ ] PUT /api/topics/:id
* [ ] DELETE /api/topics/:id

### Videos
* [ ] GET /api/animes/:anime_id/videos
* [ ] POST /api/animes/:anime_id/videos
* [ ] DELETE /api/animes/:anime_id/videos/:id
