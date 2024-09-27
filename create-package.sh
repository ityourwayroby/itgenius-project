./mvnw clean install
docker rmi -f mhbappy18/itgenius &>/dev/null && echo 'Removed old container'
docker build -t mhbappy18/itgenius .
docker push mhbappy18/itgenius
