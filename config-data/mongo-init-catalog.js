db.createCollection("catalog");
{
        user: "user-catalog-mongo",
          pwd: "password-catalog-mongo",
        roles: [
            {
                role: "readWrite",
                db: "catalog-dev-mongo"
            }
        ]
    }
);
db.createCollection("catalog");
