docker-compose down
docker rmi -f mhbappy18/itgenius &>/dev/null && echo 'Removed old container'
docker-compose up -d