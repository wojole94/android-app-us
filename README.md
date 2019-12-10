# android-app-us
How to run:
1. Register and download docker from its official website. https://www.docker.com/
2. Set up db using 'docker-compose up' command in git repo main localization
3. Build project using 'mvn spring-boot:run'command in main sky-scanner-app-backend project directory
4. You can get access to REST API (front-end side) at http://localhost:8080/api/v1
5. Database is exposed at http://localhost:3306. u:root p:admin. You can use MySQLWorkbench f.e. to view schemas in UI.
