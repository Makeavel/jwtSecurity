# jwtSecurity
Sistema de criptografia de senha, autenticação de usuário e geração de token para o sistema Marmita Social.

Frameworks: <br>
Spring Boot<br>
Spring Security<br>
JWT<br>
JPA<br><br>
Banco de dados: <br>
Postgres <br>

**OBSERVAÇÃO:** Caso não tenha o Postgres instalado em sua máquina, no arquivo **application.properties** remova tudo que tiver a ver com o Postgres e adicione ao **POM.xml** do projeto a seguinte dependencia:<br>

**application.properties:**
```
# Configurações do H2
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver

# Configurações do JPA
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
```
**POM.xml:**
```
<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```


## Rotas

- Salvar Usuario:  localhost:8080/api/users/<br>

```
 Json:
 {
	"login":"user",
	"password":"password"
}
```
<br><hr>

- Login : localhost:8080/api/users/auth
```
Json:
{
	"login":"mayte",
	"password":"1234",
	"email":"email_email@gmail.com",
	"cep":"70737022",
	"dataNascimento":"2022-05-21",
	"intoleranciaAlimentar": ["lactose", "gluten"],
	"restricaoAlimentar": ["vegano","outro"]
}
```
<br><hr>
