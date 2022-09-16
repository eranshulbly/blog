# blog
backend of a blog application
# Requirements
1. Users can create account: Username, password, avatar, 3rd party login(Google)
2. Users can login
3. Write Blog articles
   1. Should have a heading and subheading
   2. body content 
   3. delete articles created
   4. timestamp
   5. edit articles
4. Can comment on articles
   1. Should have commentator name and timestamp
   2. Can delete comments
5. Can follow other members
6. Can like blog articles
7. Feed to see all blog articles (Order sroted by date)
   1. Filter by name
   2. Filter by title
   3. Sort by likes and date

# Entities

User
```json
    {
        "id": 12,
        "username": "johndoe001",
        "email": "john@mail.com",
        "bio": "I am a software developer",
        "avatar": "https://avatars.dicebear.com/v2/johndoe001.png",
        "createdAt": "2020-01-01T00:00:00.000Z"
    }
```

Article
```json
    {
        "id": 12,
        "heading": "article1",
        "subHeading": "topic1",
        "content": "I am a software developer",
        "authorId": 21,
        "createdAt": "2020-01-01T00:00:00.000Z",
        "updatedAt": "2020-01-01T00:00:00.000Z"
    }
```

Comment
```json
    {
      "id": 17,
      "title": "My first comment",
      "body": "This is my first comment",
      "articleId": 124,
      "authorId": 42,
      "createdAt": "2020-01-01T00:00:00.000Z"
    }
```
UML Diagram

<img>![](C:/Users/Agarwal/Downloads/blogUml.drawio.png)

# API Endpoints
```json
User
   POST: /user
   POST: /user/login
   GET: /users
         query parameters
         ?sort=date and ?sort=followers
         ?username=something
         ?follower=something
         ?following=something
   GET: /user/{userId}
   GET: /user/{userName}
   PUT: /user/{username}/follow -> follow a user
   DELETE: /user/{username}/follow -> remove following
Articles
   POST: /articles
   GET: /articles/{article-slug}
   GET: /articles 
      query parameters
      ?sort=date and ?sort=likes
      ?author=something
      ?following=true
   PATCH: /articles/{article-slug}
   DELETE: /articles/{article-slug}
   PUT: /articles/{article-slug}/likes -> like a article
   DELETE: /articles/{article-slug}/likes -> unlike a article
Comments
   POST: /articles/{article-slug}/comments
   GET: /articles/{article-slug}/comments
   DELETE: /articles/{article-slug}/comments/{commentId} -> delete a comment


```