# javashiki

Java wrapper for [Shikimori API](https://shikimori.one/api/doc/1.0).

## Requirements

- Java 11+
- Maven

## Installation

### Maven Dependency

```xml
<dependencies>
  <dependency>
    <groupId>com.yauhescha</groupId>
    <artifactId>javashiki</artifactId>
    <version>2.2.1</version>
  </dependency>
</dependencies>

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

## Quick Start

### 1. OAuth Authorization

To use the API, you need to obtain an OAuth2 token from Shikimori:

```java
// Option 1: Use the built-in test application (limited scope)
AuthShikimori auth = new AuthShikimori();

// Option 2: Use your own application (recommended)
AuthShikimori auth = new AuthShikimori(
    "YourAppName",
    "your_client_id",
    "your_client_secret",
    "urn:ietf:wg:oauth:2.0:oob"
);

// Get authorization URL and open it in browser
String authUrl = auth.getUrlToAuthorizationCode();
System.out.println("Open this URL: " + authUrl);

// After authorization, enter the code
Scanner scanner = new Scanner(System.in);
auth.authorize(scanner.nextLine());
```

### 2. Make API Calls

```java
// Get current user info
UserInfo userInfo = auth.getUserApi().whoIAm();
System.out.println("Logged in as: " + userInfo.getNickname());

// Search for anime
AnimeSearchParameters params = AnimeSearchParameters.builder()
    .search("naruto")
    .limit(5)
    .build();
List<Anime> animes = auth.getAnimeApi().getAnimes(params);

// Get anime details
Optional<AnimeFull> anime = auth.getAnimeApi().getAnimeDetail(20, true);
anime.ifPresent(a -> System.out.println(a.getName()));
```

## Configuration

### OAuth Application Setup

1. Go to https://shikimori.one/oauth/applications
2. Create a new application
3. Note your `client_id` and `client_secret`
4. Set redirect URI to `urn:ietf:wg:oauth:2.0:oob`

### Required OAuth Scopes

Some API endpoints require specific OAuth scopes:

| Scope | Endpoints |
|-------|-----------|
| `comments` | Comment create/update/delete |
| `user_rates` | User rate create/update/delete |
| `messages` | Message create/update/delete |
| `topics` | Topic create/update/delete |
| `content` | Video create/delete |
| `clubs` | Club join/leave |
| `styles` | Style create/update |

To use write operations, make sure your application has the required scopes.

## API Reference

### Available API Classes

All API classes are accessible via `AuthShikimori`:

```java
auth.getAnimeApi()         // Anime operations
auth.getMangaApi()         // Manga operations
auth.getUserApi()          // User operations
auth.getCharacterApi()     // Character operations
auth.getClubApi()          // Club operations
auth.getCommentApi()       // Comment operations
auth.getDialogApi()         // Dialog operations
auth.getFavoriteApi()      // Favorite operations
auth.getFriendApi()        // Friend operations
auth.getMessageApi()       // Message operations
auth.getRanobeApi()        // Ranobe operations
auth.getReviewApi()        // Review operations
auth.getStyleApi()         // Style operations
auth.getTopicApi()         // Topic operations
auth.getUserRateApi()      // User rate operations
auth.getVideoApi()         // Video operations
auth.getAchievementApi()   // Achievement operations
auth.getBanApi()           // Ban operations
auth.getCalendarApi()      // Calendar operations
auth.getConstantApi()      // Constant operations
auth.getForumApi()         // Forum operations
auth.getGenreApi()         // Genre operations
auth.getPeopleApi()        // People operations
auth.getPublisherApi()     // Publisher operations
auth.getStatsApi()         // Stats operations
auth.getStudioApi()         // Studio operations
auth.getUserImageApi()     // User image operations
auth.getAppearsApi()       // Appear operations
```

## Implementation Status

### ✅ Implemented

#### Achievements
- [x] GET /api/achievements - List user achievements

#### Animes
- [x] GET /api/animes - List animes (with search parameters)
- [x] GET /api/animes/:id - Show anime details
- [x] GET /api/animes/:id/roles - Show anime roles
- [x] GET /api/animes/:id/similar - Show similar animes
- [x] GET /api/animes/:id/related - Show related animes
- [x] GET /api/animes/:id/screenshots - Show anime screenshots
- [x] GET /api/animes/:id/franchise - Show anime franchise
- [x] GET /api/animes/:id/external_links - Show anime external links
- [x] GET /api/animes/:id/topics - Show anime topics

#### Appear
- [x] POST /api/appears - Mark comments/topics as read

#### Bans
- [x] GET /api/bans - List bans

#### Calendars
- [x] GET /api/calendar - Show calendar

#### Characters
- [x] GET /api/characters/:id - Show character
- [x] GET /api/characters/search - Search characters

#### Clubs
- [x] GET /api/clubs - List clubs
- [x] GET /api/clubs/:id - Show club details
- [x] PATCH/PUT /api/clubs/:id - Update club
- [x] GET /api/clubs/:id/animes - Show club's animes
- [x] GET /api/clubs/:id/mangas - Show club's mangas
- [x] GET /api/clubs/:id/ranobe - Show club's ranobe
- [x] GET /api/clubs/:id/characters - Show club's characters
- [x] GET /api/clubs/:id/collections - Show club's collections
- [x] GET /api/clubs/:id/clubs - Show club's clubs
- [x] GET /api/clubs/:id/members - Show club's members
- [x] GET /api/clubs/:id/images - Show club's images
- [x] POST /api/clubs/:id/join - Join club
- [x] POST /api/clubs/:id/leave - Leave club

#### Comments
- [x] GET /api/comments - List comments
- [x] GET /api/comments/:id - Show comment
- [x] POST /api/comments - Create comment
- [x] PATCH/PUT /api/comments/:id - Update comment
- [x] DELETE /api/comments/:id - Delete comment

#### Constants
- [x] GET /api/constants/anime - Get anime constants
- [x] GET /api/constants/manga - Get manga constants
- [x] GET /api/constants/user_rate - Get user rate constants
- [x] GET /api/constants/club - Get club constants
- [x] GET /api/constants/smileys - Get smileys

#### Dialogs
- [x] GET /api/dialogs - List dialogs
- [x] GET /api/dialogs/:id - Show dialog messages
- [x] DELETE /api/dialogs/:id - Delete dialog

#### Favorites
- [x] POST /api/favorites/:linked_type/:linked_id(/:kind) - Create favorite
- [x] DELETE /api/favorites/:linked_type/:linked_id - Delete favorite
- [x] POST /api/favorites/:id/reorder - Reorder favorite

#### Forums
- [x] GET /api/forums - List forums

#### Friends
- [x] POST /api/friends/:id - Add friend
- [x] DELETE /api/friends/:id - Remove friend

#### Genres
- [x] GET /api/genres - List genres

#### Mangas
- [x] GET /api/mangas - List mangas
- [x] GET /api/mangas/:id - Show manga details
- [x] GET /api/mangas/:id/roles - Show manga roles
- [x] GET /api/mangas/:id/similar - Show similar mangas
- [x] GET /api/mangas/:id/related - Show related mangas
- [x] GET /api/mangas/:id/franchise - Show manga franchise
- [x] GET /api/mangas/:id/external_links - Show manga external links
- [x] GET /api/mangas/:id/topics - Show manga topics

#### Messages
- [x] GET /api/messages/:id - Show message
- [x] POST /api/messages - Create message
- [x] PATCH/PUT /api/messages/:id - Update message
- [x] DELETE /api/messages/:id - Delete message
- [x] POST /api/messages/mark_read - Mark messages as read/unread
- [x] POST /api/messages/read_all - Mark all messages as read
- [x] POST /api/messages/delete_all - Delete all messages

#### People
- [x] GET /api/people/:id - Show person
- [x] GET /api/people/search - Search people

#### Publishers
- [x] GET /api/publishers - List publishers

#### Ranobe
- [x] GET /api/ranobe - List ranobe
- [x] GET /api/ranobe/:id - Show ranobe details
- [x] GET /api/ranobe/:id/roles - Show ranobe roles
- [x] GET /api/ranobe/:id/similar - Show similar ranobe
- [x] GET /api/ranobe/:id/related - Show related ranobe
- [x] GET /api/ranobe/:id/franchise - Show ranobe franchise
- [x] GET /api/ranobe/:id/external_links - Show ranobe external links
- [x] GET /api/ranobe/:id/topics - Show ranobe topics

#### Reviews
- [x] POST /api/reviews - Create review
- [x] PATCH/PUT /api/reviews/:id - Update review
- [x] DELETE /api/reviews/:id - Delete review

#### Stats
- [x] GET /api/stats/active_users - Active users stats

#### Studios
- [x] GET /api/studios - List studios

#### Styles
- [x] GET /api/styles/:id - Show style
- [x] POST /api/styles/preview - Preview style
- [x] POST /api/styles - Create style
- [x] PATCH/PUT /api/styles/:id - Update style

#### Topics
- [x] GET /api/topics - List topics
- [x] GET /api/topics/updates - Topic updates
- [x] GET /api/topics/hot - Hot topics
- [x] GET /api/topics/:id - Show topic
- [x] POST /api/topics - Create topic
- [x] PATCH/PUT /api/topics/:id - Update topic
- [x] DELETE /api/topics/:id - Delete topic

#### User Images
- [x] POST /api/user_images - Upload user image

#### User Rates
- [x] GET /api/user_rates/:id - Show user rate
- [x] POST /api/user_rates - Create user rate
- [x] PATCH/PUT /api/user_rates/:id - Update user rate
- [x] POST /api/user_rates/:id/increment - Increment episodes/chapters
- [x] DELETE /api/user_rates/:id - Delete user rate
- [x] DELETE /api/user_rates/:type/cleanup - Cleanup user rates
- [x] DELETE /api/user_rates/:type/reset - Reset user scores

#### Users
- [x] GET /api/users - List users
- [x] GET /api/users/:id - Show user
- [x] GET /api/users/:id/info - Show user info
- [x] GET /api/users/whoami - Show current user
- [x] GET /api/users/:id/friends - Show user's friends
- [x] GET /api/users/:id/clubs - Show user's clubs
- [x] GET /api/users/:id/anime_rates - Show user's anime list
- [x] GET /api/users/:id/manga_rates - Show user's manga list
- [x] GET /api/users/:id/favourites - Show user's favourites
- [x] GET /api/users/:id/messages - Show user's messages
- [x] GET /api/users/:id/unread_messages - Show unread messages count
- [x] GET /api/users/:id/history - Show user history
- [x] GET /api/users/:id/bans - Show user's bans

#### Videos
- [x] GET /api/animes/:anime_id/videos - List videos
- [x] POST /api/animes/:anime_id/videos - Create video
- [x] DELETE /api/animes/:anime_id/videos/:id - Delete video

### ❌ Not Implemented (Deprecated API endpoints)

These endpoints are deprecated in the Shikimori API and not implemented:

#### Reviews (read)
- [ ] GET /api/reviews
- [ ] GET /api/reviews/:id

#### Topics (alternative)
- [ ] GET /api/topics/:id/reviews

#### User rates (deprecated)
- [ ] GET /api/user_rates (list all)

## Usage Examples

### Search Anime

```java
AnimeSearchParameters params = AnimeSearchParameters.builder()
    .search("naruto")
    .kind(SearchAnimeKind.TV)
    .status(SearchOrderStatus.RELEASED)
    .order(SearchAnimeOrder.RANKED)
    .limit(10)
    .page(1)
    .build();

List<Anime> animes = auth.getAnimeApi().getAnimes(params);
```

### Get Anime Details

```java
Optional<AnimeFull> anime = auth.getAnimeApi().getAnimeDetail(20, true);
anime.ifPresent(a -> {
    System.out.println("Name: " + a.getName());
    System.out.println("Episodes: " + a.getEpisodes());
    System.out.println("Score: " + a.getScore());
    System.out.println("Genres: " + a.getGenres());
});
```

### Work with User Rates

```java
// Create user rate
Map<String, Object> rateParams = new HashMap<>();
rateParams.put("user_id", String.valueOf(userId));
rateParams.put("target_id", "20");
rateParams.put("target_type", "Anime");
rateParams.put("status", "watching");
rateParams.put("score", "8");
rateParams.put("episodes", "5");

UserRate rate = auth.getUserRateApi().createUserRate(rateParams);

// Increment episodes
UserRate incremented = auth.getUserRateApi().incrementUserRate(rate.getId());

// Delete rate
auth.getUserRateApi().deleteUserRate(rate.getId());
```

### Work with Messages

```java
// Create message
Map<String, Object> messageParams = new HashMap<>();
messageParams.put("body", "Hello!");
messageParams.put("from_id", String.valueOf(myUserId));
messageParams.put("kind", "Private");
messageParams.put("to_id", String.valueOf(otherUserId));

Message message = auth.getMessageApi().createMessage(messageParams);

// Get message
Optional<Message> fetched = auth.getMessageApi().getMessage(message.getId());

// Delete message
auth.getMessageApi().deleteMessage(message.getId());
```

### Work with Comments

```java
// Create comment
Map<String, Object> commentParams = new HashMap<>();
commentParams.put("body", "Great anime!");
commentParams.put("commentable_id", String.valueOf(animeId));
commentParams.put("commentable_type", "Anime");

Comment comment = auth.getCommentApi().createComment(commentParams);

// Update comment
Map<String, Object> updateParams = new HashMap<>();
updateParams.put("body", "Updated comment text");
Comment updated = auth.getCommentApi().updateComment(comment.getId(), updateParams);

// Delete comment
auth.getCommentApi().deleteComment(comment.getId());
```

## Response Handling

All API methods return Java objects. For single entity endpoints, `Optional<T>` is returned:

```java
Optional<AnimeFull> anime = auth.getAnimeApi().getAnimeDetail(20, false);
if (anime.isPresent()) {
    // Process anime
}

// Or using functional style
anime.ifPresent(a -> System.out.println(a.getName()));
```

For list endpoints, `List<T>` is returned:

```java
List<Anime> animes = auth.getAnimeApi().getAnimes(params);
animes.forEach(System.out::println);
```

## Error Handling

The library handles common API errors:

- **401 Unauthorized**: Automatically refreshes the token if possible
- **404 Not Found**: Returns `null` or empty Optional
- **429 Rate Limited**: Automatically retries after 1 second
- **403 Forbidden**: Returns `null` (insufficient OAuth scopes)

Check the API response for error details when needed.

## Dependencies

- [Gson](https://github.com/google/gson) - JSON serialization
- [Lombok](https://projectlombok.org/) - Boilerplate reduction
- [http-request](https://github.com/kevinsawicki/http-request) - HTTP client

## Building

```bash
# Compile
mvn compile

# Run tests
mvn test

# Package
mvn package
```

## License

This project is provided as-is for use with the Shikimori API.
