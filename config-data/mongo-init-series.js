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

