# spring-boot-java-rest-api-secure-archetype

## How to use?

This archetype is published to Maven central. 
You can generate project using this archetype using `mvn archetype:generate` and select the archetype number.

### Install archetype locally

```bash
git clone https://github.com/sivalabs/spring-boot-java-rest-api-secure-archetype.git
cd spring-boot-java-rest-api-secure-archetype
./mvnw clean install
```

### Generate application from archetype

```
mvn archetype:generate \
    -B -DarchetypeGroupId=io.github.sivalabs.maven.archetypes \
    -DarchetypeArtifactId=spring-boot-java-rest-api-secure-archetype \
    -DarchetypeVersion=0.0.1 \
    -DgroupId=com.mycompany \
    -DartifactId=myapp \
    -Dversion=1.0-SNAPSHOT \
    -Dpackage=com.mycompany.myapp
```

Generates basic SpringBoot REST API application with the following features:
1. Database support (H2/Postgres)
2. Configured Dockerfile, Jenkinsfile
3. Flyway DB migrations
4. Monitoring with Prometheus, Grafana
5. ELK based logging

## Developer Notes

Procedure for deploying to Maven Central https://central.sonatype.org/pages/apache-maven.html

Create or update archetypes and set version to SNAPSHOT (ex: 1.0.0-SNAPSHOT)

Deploy SNAPSHOT version to https://oss.sonatype.org/content/repositories/snapshots/

`spring-boot-java-rest-api-secure-archetype> ./mvnw clean deploy -P release`

Deploy release version to Maven Central

```
spring-boot-java-rest-api-secure-archetype> ./mvnw release:clean release:prepare -P release
spring-boot-java-rest-api-secure-archetype> ./mvnw release:perform -P release
```
