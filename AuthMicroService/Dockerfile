#öncelikle uygulmamızı çalıştırabileceği bir imaj kullanıyoruz
#burda içinde OS ve Java JDK olan bir versiyonu hub.docker.com dan
#seçerek buraya ekliyoruz

FROM amazoncorretto:17

#uygulamamızın jar dosyasını oluşturacağımız docker container içinde
#copy ile ekliyoruz COPY[dosya adı][kopyalanan yer]

COPY build/libs/AuthMicroService-v.0.1.jar app.jar

# Container ayağa kaldırıldığında çalışması için gerekli komutları işletecek
# kısmı yazıyorsunuz

ENTRYPOINT ["java","-jar","/app.jar"]

# Bu dosyayı kullanarak yeni bir docker imge oluşturmak için
# docker build komutunu kullanıyoruz. tam olarak komut şu şekilde
# cd AuthMicroService
# docker build -t [hub.docker repository name]/[project Name]:[version] .


