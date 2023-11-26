# KURULUMLA

## MongoDB İşlemler
    Not: MongoDB ile işlem yaparken admin kullanıcısı ve admin şifresi kullanılmamalıdır.
    Bu nedenle oluşturulacak her DB için yeni kullanıcı ve şifre tanımlanmalı
    1- Öncelikle DB yi tanımlayın
    2- üzerinde çalışma yapabilmek için mongoDB Compass üzerinden MONGOSH ı açın (sol en altta)
    3- "user- DB_Adı" şeklinde komut girilir 
    4- bu DB yi yönetecek olan bir kullanıcı tanımlıyorsunuz 
    db.createUser({
        user: "defaultUSer",
        pwd: "bilge!*123",
        roles: ["readWrite", "dbAdmin"]
    })
    
  
### DOCKER ÜZERİNDE MONGODBKURULUMU
    docker run --name mongodb -e "MONGO_INITDB_ROOT_USERNAME=admin" -e "MONGO_INITDB_ROOT_PASSWORD=root" -p 27017:27017 mongo:7.0-rc-jammy

### DOCKER ÜZERİNDE POSTGRESQL KURULUMU
    docker run --name postgresdb -e POSTGRES_PASSWORD=root -p 5433:5432 -d postgres

### bunları docker hubtan alıyoruz 

