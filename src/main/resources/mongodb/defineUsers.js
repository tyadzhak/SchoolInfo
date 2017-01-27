use schoolInfoDb
db.createUser(
   {
     user: "tiad",
     pwd: "tiad",
     roles: [ { role: "readWrite", db: "schoolInfoDb" } ]
   }
);