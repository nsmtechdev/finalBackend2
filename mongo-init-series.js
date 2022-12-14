db.createUser(
    {
        user: "user-series-mongo",
          pwd: "password-series-mongo",
        roles: [
            {
                role: "readWrite",
                db: "series-dev-mongo"
            }
        ]
    }
);
db.createCollection("Series");

db.holiday.insert({
  serieId: 1,
  name: "abc",
  genre: "accion",
  seasons: [
    {
      seasonId: 1,
      seasonNumber: 1,
      chapters: [
        {
          chapterId: 1,
          name: 1,
          number: 1,
          urlStream: "https://netflix.com",
        },
      ],
    },
  ],
});

