# Название проекта
PROJECT_NAME=friendlybooking-0.0.1-SNAPSHOT

# Путь к JAR-файлу
JAR_FILE=target/$(PROJECT_NAME).jar

# Команда для сборки JAR
build-jar:
	mvn clean package -DskipTests

# Команда для пересборки Docker-образа
docker-build:
	docker-compose build

# Команда для пересборки и перезапуска контейнеров
docker-up:
	docker-compose up --build -d

# Команда для остановки контейнеров
docker-down:
	docker-compose down

# Автоматизация всего процесса
deploy: build-jar docker-build docker-up
	@echo "Deployment successful!"

# Очистка
clean:
	mvn clean
	docker-compose down --volumes --remove-orphans
	docker system prune -f