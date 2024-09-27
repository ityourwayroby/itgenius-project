./mvnw clean install
docker rmi -f robystunna2/itgenius &>/dev/null && echo 'Removed old container'
docker build -t robystunna2/itgenius .
docker push robystunna2/itgenius
