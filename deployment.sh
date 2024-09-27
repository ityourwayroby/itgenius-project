docker-compose down
docker rmi -f robystunna2/itgenius &>/dev/null && echo 'Removed old container'
docker-compose up -d
